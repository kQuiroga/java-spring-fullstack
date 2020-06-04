package com.kquiroga.gestorlibros.persistence.dao.service;

public interface JpaServicio {

    <T> T insertar(T object);

    <T> T borrar(T object);

    <T> T actualizar(T object);
}
