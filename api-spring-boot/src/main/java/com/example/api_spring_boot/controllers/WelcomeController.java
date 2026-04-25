package com.example.api_spring_boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de bienvenida.
 *
 * Expone la ruta raíz "/" de la API para verificar que el servidor
 * está en línea y funcionando correctamente.
 *
 * @RestController combina @Controller + @ResponseBody, lo que significa
 * que el valor retornado se serializa directamente como respuesta HTTP
 * (en este caso, un simple String en texto plano).
 */
@RestController
public class WelcomeController {

    /**
     * GET /
     * Retorna un mensaje de bienvenida para confirmar que la API está activa.
     *
     * @return Mensaje de bienvenida en texto plano.
     */
    @GetMapping("/")
    public String welcome() {
        return "¡Bienvenido a la API de usuarios! La aplicación está corriendo correctamente.";
    }
}
