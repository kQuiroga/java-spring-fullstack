package com.kquiroga.gestorlibros.negocio.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Base64;
import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kquiroga.gestorlibros.negocio.LibroService;
import com.kquiroga.gestorlibros.negocio.model.Autores;
import com.kquiroga.gestorlibros.negocio.model.Libros;
import com.kquiroga.gestorlibros.negocio.model.MyUserPrincipal;
import com.kquiroga.gestorlibros.negocio.transform.LibrosTransform;
import com.kquiroga.gestorlibros.persistence.dao.AutoresDAO;
import com.kquiroga.gestorlibros.persistence.dao.LibrosDAO;
import com.kquiroga.gestorlibros.persistence.model.AutoresEntity;
import com.kquiroga.gestorlibros.persistence.model.LibrosEntity;
import com.kquiroga.gestorlibros.persistence.trasform.AutorEntityTransform;
import com.kquiroga.gestorlibros.persistence.trasform.LibroEntityTransform;
import com.kquiroga.gestorlibros.web.model.LibroBean;
import com.kquiroga.gestorlibros.web.model.LibroForm;
import com.kquiroga.gestorlibros.web.transform.LibroBeanTransform;
import com.kquiroga.gestorlibros.web.transform.LibroFormTransform;

@Service
public class LibroServiceImpl implements LibroService {
    private final String PATH_SERVIDOR = "C:\\Users\\kquiroga\\Downloads\\apache-tomcat-9.0.17\\imagenes\\";
    private final Logger LOGGER = LoggerFactory.getLogger(LibroServiceImpl.class);

    @Autowired
    private LibrosDAO librosDao;

    @Autowired
    private AutoresDAO autoresDao;

    @Autowired
    private AutorEntityTransform autorEntityTransform;

    @Autowired
    private LibroEntityTransform libroEntityTransform;

    @Autowired
    private LibroBeanTransform libroBeanTransform;

    @Autowired
    private LibroFormTransform libroFormTransform;

    @Autowired
    private LibrosTransform librosTransform;

    @Override
    @Transactional
    @Cacheable("librosBean")
    public List<LibroBean> obtenerListado() {
        final List<LibrosEntity> listaEntity = librosDao.obtenerListadoLibros();
        List<Libros> listaLibros = null;
        if (!listaEntity.isEmpty() || listaEntity != null) {
            LOGGER.info("Se va a ejecutar la query");
            listaLibros = libroEntityTransform.listaLibrosEntityALibros(listaEntity);
        }

        return libroBeanTransform.listaLibrosALibrosBean(listaLibros);
    }

    @Override
    @Transactional
    public List<LibroBean> obtenerLibrosPorAutor(final String autorNombre) {
        final Autores autor = autorEntityTransform.autorEntityAAutor(autoresDao.buscarAutoresPorNombre(autorNombre));
        final List<LibrosEntity> listLibroEntity = librosDao.buscarLibrosPorAutor(autor);
        final List<Libros> listaLibros = libroEntityTransform.listaLibrosEntityALibros(listLibroEntity);
        return libroBeanTransform.listaLibrosALibrosBean(listaLibros);
    }

    @Override
    @Transactional
    @Cacheable(value = "librosPorTitulo")
    public LibroBean obtenerLibrosPorTitulo(final String titulo) {
        final Libros libro = libroEntityTransform.libroEntityALibro(librosDao.buscarLibrosPorTitulo(titulo));
        LibroBean libroBean = null;
        if (!libro.getTitulo().isEmpty() || libro.getTitulo() != null) {
            libroBean = libroBeanTransform.libroALibroBean(libro);
        }

        return libroBean;
    }

    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "librosBean", allEntries = true),
            @CacheEvict(value = "imagenesLibros", allEntries = true) })
    public void insertarLibro(final LibroForm libroForm) throws NoResultException {
        if (null != libroForm.getNombreAutor() && null != libroForm.getTitulo()
                && null != libroForm.getImagenPortadaBase64()) {
            LOGGER.info("Se han recibidio los valores titulo: {} y autor: {} para la inserción del libro",
                    libroForm.getTitulo(), libroForm.getNombreAutor());
            if (!esDuplicado(libroForm.getTitulo())) {
                final byte[] imagenEnBytes = convertirBase64ABytes(libroForm.getImagenPortadaBase64());
                guardarImagenEnServidor(imagenEnBytes, libroForm.getNombreImagen());
                LOGGER.info("El usuario {} ha insertado correctamente el libro con titulo: {}",
                        obtenerUsuarioLoggeado(), libroForm.getTitulo());
            } else {
                LOGGER.error("El libro con el título {} ya existe en la base de datos", libroForm.getTitulo());
            }
        }

        final Libros libro = libroFormTransform.libroFormALibro(libroForm);
        try {

            if (null != libro.getTitulo()) {
                final AutoresEntity autorEntity = autoresDao.buscarAutoresPorNombre(libroForm.getNombreAutor());
                if (null != autorEntity) {
                    final LibrosEntity libroEntity = librosTransform.libroALibroEntity(libro, autorEntity);
                    libroEntity.setPathImagenPortada(PATH_SERVIDOR.concat(libroForm.getNombreImagen()));
                    librosDao.insertar(libroEntity);
                }
            }

        } catch (final NoResultException e) {
            LOGGER.error("El autor con nombre {} no existe en la base de datos", libroForm.getNombreAutor(), e);
        }
    }

    @Transactional
    private boolean esDuplicado(final String titulo) {
        final List<LibrosEntity> listaComprobar = librosDao.obtenerListadoLibros();
        for (final LibrosEntity libro : listaComprobar) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    private byte[] convertirBase64ABytes(final String imagenEnBase64) {
        return Base64.getDecoder().decode(imagenEnBase64);
    }

    private void guardarImagenEnServidor(final byte[] imagenEnBytes, final String nombreImagenYExtension) {
        File archivoDeImagen;
        try {
            archivoDeImagen = new File(PATH_SERVIDOR.concat(nombreImagenYExtension));
            if (!archivoDeImagen.exists()) {
                final FileOutputStream fileOutputStream = new FileOutputStream(archivoDeImagen);
                fileOutputStream.write(imagenEnBytes);
                fileOutputStream.close();
            } else {
                throw new FileAlreadyExistsException(archivoDeImagen.toString());
            }
        } catch (final FileNotFoundException e) {
            LOGGER.error("No se ha creado la ruta correcta para la súbida del archivo {}", nombreImagenYExtension, e);
        } catch (final IOException e) {
            LOGGER.error("Ha ocurrido un error a la hora de escribir los datos del archivo {} en el servidor",
                    nombreImagenYExtension, e);
        }
    }

    @Override
    @Transactional
    public void actualizarLibro(final LibroForm libroForm) {
        try {
            Libros libro;
            libro = libroFormTransform.libroFormALibro(libroForm);
            final AutoresEntity autorEntity = autoresDao.buscarAutoresPorNombre(libroForm.getNombreAutor());
            final LibrosEntity libroEntity = librosTransform.libroALibroEntity(libro, autorEntity);
            librosDao.actualizar(libroEntity);
            LOGGER.info("El usuario {} ha actualizado el libro con id: {} y título: {}",
                    new Object[] { obtenerUsuarioLoggeado(), libro.getId(), libro.getTitulo() });
        } catch (final NoResultException e) {
            LOGGER.error("No se podido hacer la modificación del libro con autor: {} y título: {}",
                    libroForm.getNombreAutor(), libroForm.getTitulo(), e);
        }
    }

    public String obtenerUsuarioLoggeado() {
        final Object usuarioActual = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nombreUsuario = "";
        if (usuarioActual instanceof MyUserPrincipal) {
            nombreUsuario = ((MyUserPrincipal) usuarioActual).getUsername();
        }

        return nombreUsuario;
    }

    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "imagenesLibros", allEntries = true),
            @CacheEvict(value = "librosBean", allEntries = true) })
    public void borrarLibro(final LibroForm libroForm) {
        final LibrosEntity libroEntity = librosDao.obtenerLibroPorId(libroForm.getId());
        final File archivo = new File(libroEntity.getPathImagenPortada());

        if (null == libroForm.getNombreImagen() || "" == libroForm.getNombreImagen()) {
            librosDao.borrar(libroEntity);
        } else if (archivo.delete() == true) {
            librosDao.borrar(libroEntity);
        }

        LOGGER.info("El usuario {} ha borrado un libro con id: {} y título: {}",
                new Object[] { obtenerUsuarioLoggeado(), libroForm.getId(), libroForm.getTitulo() });
    }

    @Override
    @Transactional
    public String devolverImagen(final Long id) {
        return librosDao.obtenerImagenPorId(id);
    }
}
