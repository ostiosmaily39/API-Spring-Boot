package com.example.api_spring_boot.exceptions;

import java.time.LocalDateTime;

/**
 * Clase que representa la estructura estándar de una respuesta de error en JSON.
 * Se usa en el GlobalExceptionHandler para devolver errores consistentes al cliente.
 *
 * Ejemplo de respuesta generada:
 * {
 *   "status":  404,
 *   "error":   "Not Found",
 *   "message": "Usuario con id 5 no fue encontrado",
 *   "timestamp": "2026-04-24T17:00:00"
 * }
 */
public class ErrorResponse {

    /** Código HTTP del error (ej: 404, 400, 500). */
    private int status;

    /** Descripción corta del error (ej: "Not Found"). */
    private String error;

    /** Mensaje detallado con la causa del error. */
    private String message;

    /** Fecha y hora exacta en que ocurrió el error. */
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String error, String message) {
        this.status    = status;
        this.error     = error;
        this.message   = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus()             { return status; }
    public String getError()           { return error; }
    public String getMessage()         { return message; }
    public LocalDateTime getTimestamp(){ return timestamp; }
}
