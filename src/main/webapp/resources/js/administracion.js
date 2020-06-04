function handlers() {
	
	$("select.libroAModificar").change(function(e) {
		e.preventDefault();		
		var textoTituloAModificar =  $("#libroAModificarSeleccionado option:selected").val();				
		mostrarCaracteristicasLibro(textoTituloAModificar);
	});	
	
	$("select.libroABorrar").change(function(e){
		e.preventDefault();
		var tituloLibroABorrar = $("#libroABorrarSeleccionado option:selected").val();
		inputarDatosParaElBorradoLibro(tituloLibroABorrar);
	});
	
	$('#formularioInsertarlibro').on('submit', function(e){
		e.preventDefault();
		procesoInsertarLibroRestConImagen();
	});
	
	$('#formularioModificarLibro').on('submit', function(e){
		e.preventDefault();		
		procesoModificarLibroRest();
	});
	
	$('#formularioBorrarLibro').on('submit', function(e){
		e.preventDefault();	
		procesoBorradoLibrosRest();
	});
}
	
function mostrarCaracteristicasLibro(textoTituloAModificar) {
	var libroAjaxAModificar =  {titulo: textoTituloAModificar} ;		
	
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/Gestorlibros/obtenerInfoLibrosPorTitulo',
		contentType: 'application/json; charset=UTF-8',
		dataType: 'json',
		data:  JSON.stringify(libroAjaxAModificar),
		success: function(response){
			console.log("SUCCESS", response);
			$('input[id="id"]').val(response.data.id);
			$('input[id="titulo_resp"]').val(response.data.titulo).focus();
			$('input[id="nombre_autor"]').val(response.data.autor).focus();
			$('input[id="isbn_resp"]').val(response.data.isbn).focus();
			$('input[id="numero_paginas"]').val(response.data.numeroPaginas).focus();
			$('input[id="fecha_publicacion"]').val(response.data.publicacion).focus();
			$('input[id="fecha_edicion"]').val(response.data.edicion).focus();
		},
		error : function(e, xhr) {
			console.log("ERROR: ", e, xhr);			
		}		
	});
};

function inputarDatosParaElBorradoLibro(tituloLibroABorrar){
	var libroAjaxABorrar =  {titulo: tituloLibroABorrar};		
	
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/Gestorlibros/obtenerInfoLibrosPorTitulo',
		contentType: 'application/json; charset=UTF-8',
		dataType: 'json',
		data:  JSON.stringify(libroAjaxABorrar),
		success: function(response){
			console.log("SUCCESS", response.data);
			$('input[id="id_borrar"]').val(response.data.id);
			$('input[id="titulo_resp_borrar"]').val(response.data.titulo).focus();
			$('input[id="nombre_autor_borrar"]').val(response.data.autor).focus();
			$('input[id="isbn_borrar"]').val(response.data.isbn).focus();
			$('input[id="numero_paginas_borrar"]').val(response.data.numeroPaginas).focus();
			$('input[id="fecha_publicacion_borrar"]').val(response.data.publicacion).focus();
			$('input[id="fecha_edicion_borrar"]').val(response.data.edicion).focus();
			
		},
		error : function(e, xhr) {
			console.log("ERROR: ", e, xhr);			
		}		
	});
};

function procesoBorradoLibrosRest(){
	var libroFormABorrar = { 
		id: $('#id_borrar').val(),
		nombreAutor: $('#nombre_autor_borrar').val(),
		titulo: $('#titulo_resp_borrar').val(),
		numPaginas: $('#numero_paginas_borrar').val(),
		fechaPublicacion: $('#fecha_publicacion_borrar').val(),
		fechaEdicion: $('#fecha_edicion_borrar').val(),
		isbn: $('#isbn_borrar').val(),
	};
	
	$.ajax({
		type: 'POST',
		url:  'http://localhost:8080/Gestorlibros/borrarLibro',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(libroFormABorrar),
		success: function(){
			console.log('SUCCESS: El libro ha sido borrado correctamente');
			$('#modalBorrarLibro').modal('hide');
		},
		error: function(e, xhr) {
			console.log('ERROR', e, xhr);
		}		
	});		
};

function procesoModificarLibroRest(){
	var libroFormAModificar = {
		id: $('#id').val(),
		nombreAutor: $('#nombre_autor').val(),
		titulo: $('#titulo_resp').val(),
		numPaginas: $('#numero_paginas').val(),
		fechaPublicacion: $('#fecha_publicacion').val(),
		fechaEdicion: $('#fecha_edicion').val(),
		isbn: $('#isbn_resp').val(),
	};
	
	$.ajax({
		type: 'POST',
		url:  'http://localhost:8080/Gestorlibros/modificarLibro',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(libroFormAModificar),
		success: function() {
			console.log('SUCCESS: El libro se ha modificado correctamente');
			$('#modalModificarLibro').modal('hide');
		},
		error: function(e, xhr) {
			console.log('ERROR', e, xhr);
		}		
	});				
};

function procesoInsertarLibroRestConImagen() {
	var fileInput = $("#anadirPortadaLibro");
    var file = fileInput.prop("files")[0];
    var extension = fileInput.val().split('.').pop().toLowerCase();
    var tiposDeImagenValidos = ['jpg', 'jpeg', 'png'];
    var dataURL = "";
    var reader = new FileReader();
    
    if (fileInput.val() == 0) {
    	if ($('#errorExtensionArchivo').text() != 0 || $('#errorExtensionArchivo').text() == 0) {
    		$('#errorExtensionArchivo').html("");
        	$('#errorExtensionArchivo').append('<p class="text-danger">Es obligatorio insertar la portada del libro</p>');
    	}
    }
    
    if ($.inArray(extension, tiposDeImagenValidos) == -1 && fileInput.val() != 0) {
    	if ($('#errorExtensionArchivo').text() != 0 || $('#errorExtensionArchivo').text() == 0) {
    		$('#errorExtensionArchivo').html("");  
        	$('#errorExtensionArchivo').append("<p class='text-danger'>El tipo de imagen <span class='text-dark'>" + "." + extension + "</span> no es válido (solo se permiten png/jpg)</p>");
    } else {
    	reader.readAsDataURL(file);
        reader.onload = function(e) {
        	console.log(reader.result);
        	dataURL = reader.result.split(",").pop();
        	var libroFormAInsertar = {
        		nombreAutor: $('#nombre_autor_insertar').val(),
    			titulo: $('#titulo_insertar').val(),
    			numPaginas: $('#numPaginas_insertar').val(),
    			fechaPublicacion: $('#fechaPublicacion_insertar').val(),
    			fechaEdicion: $('#fechaPublicacion_insertar').val(),
    			isbn: $('#isbn_insertar').val(),
    			imagenPortadaBase64: dataURL,
    			nombreImagen: $('#anadirPortadaLibro').val().replace(/C:\\fakepath\\/i, '')
    	    };
        			    
    		$.ajax({
    			type: 'POST',
    			url:  'http://localhost:8080/Gestorlibros/insertarLibro',
    			data: JSON.stringify(libroFormAInsertar),
    			contentType: 'application/json',
    			success: function(response) {
    				console.log('SUCCESS: El libro se ha insertado correctamente');		
    				$('#modalInsertarLibro').modal('hide');		
    				alert('Se ha insertado correctamente el libro');
    			},
    			error: function(data) {	
    				var errores = data.responseJSON;				
    				$('#tituloErr').html("");
    				$('#autorErr').html("");
    				$('#publicacionErr').html("");
    				$('#edicionErr').html("");
    				$('#isbnErr').html("");
    				$('#paginasErr').html("");
    				
    				if (errores.titulo != "" && errores.titulo != undefined) {
        				$('#tituloErr').append(errores.titulo);
    				}    				
    				if (errores.nombreAutor != "" && errores.nombreAutor != undefined) {
    					$('#autorErr').append(errores.nombreAutor);
    				}   				
    				if (errores.fechaPublicacion != "" && errores.fechaPublicacion != undefined) {
    					$('#publicacionErr').append(errores.fechaPublicacion);
    				}    				
    				if (errores.fechaEdicion != "" && errores.fechaEdicion != undefined) {
    					$('#edicionErr').append(errores.fechaEdicion);
    				}    				
    				if (errores.isbn != "" && errores.isbn != undefined) {
    					$('#isbnErr').append(errores.isbn);
    				}   				
    				if (errores.numPaginas != "" && errores.numPaginas != undefined) {
    					$('#paginasErr').append(errores.numPaginas);
    				}
    			}		
    		});	
        };		 
    };
};
}
function mostrarDetallesLibros(loop) {
    var loopI = loop;
	var titulo = { titulo: $('#tituloImagen'+ loopI).attr("data-titulo") };
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/Gestorlibros/obtenerInfoLibrosPorTitulo',
		contentType: 'application/json; charset=UTF-8',
		dataType: 'json',
		data:  JSON.stringify(titulo),
		success: function(response){
			$('#id' + loop).popover({
				title: response.data.titulo,
				content: "Autor: " + response.data.autor + "<br/>" +
						 "Numero de páginas: " + response.data.numeroPaginas + "<br/>" + 
						 "Fecha de edición: " + response.data.edicion + "<br/>" +
						 "Fecha de publicación: " + response.data.publicacion + "<br/>",
				placement: 'bottom',
				html: true
			});	 
		},
		error : function(e, xhr) {
			console.log("ERROR: ", e, xhr);			
		}
	});		
};

$(document).ready(function(){
	handlers();
	$('input[id="id_borrar"]').hide();
	$('input[id="id"]').hide();
	
	$('#modalInsertarLibro').on('hidden.bs.modal', function () {
	    $(this).find('form').trigger('reset');
	    $("#tituloErr").html("");
	    $("#autorErr").html("");
	    $("#publicacionErr").html("");
	    $("#edicionErr").html("");
	    $("#isbnErr").html("");
	    $("#paginasErr").html("");	    
	});
	
	$('#modalModificarLibro').on('hidden.bs.modal', function () {
	    $(this).find('form').trigger('reset');
	});
	
	$('#modalBorrarLibro').on('hidden.bs.modal', function () {
	    $(this).find('form').trigger('reset');
	});
});