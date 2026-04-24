package com.example.api_spring_boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Interceptor global de excepciones para toda la aplicación.
 *
 * @RestControllerAdvice hace que esta clase capture automáticamente
 * las excepciones lanzadas en cualquier controlador REST,
 * evitando que Spring devuelva su error HTML por defecto.
 *
 * Todos los métodos aquí retornan un JSON estandarizado usando ErrorResponse.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Captura ResourceNotFoundException (recurso no encontrado).
     * Retorna HTTP 404 con el mensaje de la excepción.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),  // 404
                "Not Found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    /**
     * Captura cualquier otra excepción no controlada.
     * Retorna HTTP 500 con un mensaje genérico para no exponer detalles internos.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse body = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), // 500
                "Internal Server Error",
                "Ocurrió un error inesperado en el servidor"
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
