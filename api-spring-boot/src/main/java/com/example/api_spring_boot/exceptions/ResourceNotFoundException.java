package com.example.api_spring_boot.exceptions;

/**
 * Excepción personalizada que se lanza cuando un recurso solicitado
 * no existe en la base de datos (por ejemplo, un usuario con cierto ID).
 * Extiende RuntimeException para que no sea obligatorio capturarla (unchecked).
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor que recibe el nombre del recurso y el ID que no fue encontrado,
     * y construye un mensaje descriptivo automáticamente.
     *
     * @param recurso Nombre del recurso (ej: "Usuario")
     * @param id      ID que no se encontró
     */
    public ResourceNotFoundException(String recurso, Long id) {
        super(recurso + " con id " + id + " no fue encontrado");
    }
}
