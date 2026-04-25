package com.example.api_spring_boot.controllers;

import com.example.api_spring_boot.entities.User;
import com.example.api_spring_boot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST principal para la gestión de usuarios.
 *
 * @RestController  → indica que esta clase es un controlador REST; todos
 *                   sus métodos retornan datos JSON automáticamente.
 * @RequestMapping  → establece la ruta base "/api/users" para todos
 *                   los endpoints definidos en esta clase.
 *
 * Se inyecta UserService (interfaz) en lugar de UserServiceImpl (implementación)
 * para respetar el principio de inversión de dependencias (SOLID).
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Inyección de dependencia por constructor.
     * Spring detecta automáticamente el bean UserServiceImpl
     * que implementa UserService y lo inyecta aquí.
     *
     * @param userService implementación del servicio de usuarios.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ─────────────────────────────────────────────────────────────
    // GET /api/users
    // ─────────────────────────────────────────────────────────────

    /**
     * Obtiene la lista completa de usuarios registrados.
     *
     * @return HTTP 200 OK con un JSON array de todos los usuarios.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users); // 200 OK
    }

    // ─────────────────────────────────────────────────────────────
    // GET /api/users/{id}
    // ─────────────────────────────────────────────────────────────

    /**
     * Busca un usuario específico por su ID.
     *
     * Si el usuario no existe, el GlobalExceptionHandler intercepta la
     * ResourceNotFoundException lanzada por el servicio y devuelve un 404.
     *
     * @param id Identificador único del usuario (extraído de la URL).
     * @return HTTP 200 OK con el JSON del usuario encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user); // 200 OK
    }

    // ─────────────────────────────────────────────────────────────
    // POST /api/users
    // ─────────────────────────────────────────────────────────────

    /**
     * Crea y persiste un nuevo usuario en la base de datos.
     *
     * @RequestBody deserializa el JSON del cuerpo de la petición
     * en un objeto User.
     *
     * @param user Datos del nuevo usuario (nombre, email, edad).
     * @return HTTP 201 Created con el JSON del usuario recién creado (incluye su ID generado).
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created); // 201 Created
    }

    // ─────────────────────────────────────────────────────────────
    // PUT /api/users/{id}
    // ─────────────────────────────────────────────────────────────

    /**
     * Actualiza los datos de un usuario existente identificado por su ID.
     *
     * Si el usuario no existe, el GlobalExceptionHandler devuelve un 404.
     *
     * @param id   Identificador único del usuario a actualizar (extraído de la URL).
     * @param user Nuevos datos del usuario (nombre, email, edad).
     * @return HTTP 200 OK con el JSON del usuario actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updated = userService.update(id, user);
        return ResponseEntity.ok(updated); // 200 OK
    }

    // ─────────────────────────────────────────────────────────────
    // DELETE /api/users/{id}
    // ─────────────────────────────────────────────────────────────

    /**
     * Elimina un usuario de la base de datos por su ID.
     *
     * Si el usuario no existe, el GlobalExceptionHandler devuelve un 404.
     *
     * @param id Identificador único del usuario a eliminar (extraído de la URL).
     * @return HTTP 204 No Content (sin cuerpo de respuesta), indicando éxito.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
