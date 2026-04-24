package com.example.api_spring_boot.services;

import com.example.api_spring_boot.entities.User;

import java.util.List;

public interface UserService {

    /** Retorna la lista de todos los usuarios registrados en la base de datos. */
    List<User> findAll();

    /** Busca y retorna un usuario por su ID. Lanza excepción si no existe. */
    User findById(Long id);

    /** Crea y guarda un nuevo usuario en la base de datos. */
    User create(User user);

    /** Actualiza los datos de un usuario existente identificado por su ID. */
    User update(Long id, User user);

    /** Elimina un usuario por su ID. Lanza excepción si no existe. */
    void delete(Long id);
}
