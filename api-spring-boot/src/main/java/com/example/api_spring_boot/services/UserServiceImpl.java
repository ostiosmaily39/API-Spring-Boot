package com.example.api_spring_boot.services;

import com.example.api_spring_boot.entities.User;
import com.example.api_spring_boot.exceptions.ResourceNotFoundException;
import com.example.api_spring_boot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** Obtiene todos los usuarios llamando al repositorio JPA. */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /** Busca un usuario por ID; si no lo encuentra lanza ResourceNotFoundException. */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", id));
    }

    /** Persiste un nuevo usuario en la base de datos y lo retorna con su ID generado. */
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * Busca el usuario existente, sobreescribe sus campos con los nuevos valores
     * y guarda los cambios en la base de datos.
     */
    @Override
    public User update(Long id, User user) {
        User existing = findById(id);
        existing.setNombre(user.getNombre());
        existing.setEmail(user.getEmail());
        existing.setEdad(user.getEdad());
        return userRepository.save(existing);
    }

    /**
     * Verifica que el usuario exista (lanza excepción si no)
     * y luego lo elimina de la base de datos por su ID.
     */
    @Override
    public void delete(Long id) {
        findById(id); // valida que el usuario exista antes de eliminar
        userRepository.deleteById(id);
    }
}
