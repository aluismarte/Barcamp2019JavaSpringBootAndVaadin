package edu.aluismarte.barcamp.service;

import edu.aluismarte.barcamp.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by aluis on 9/30/19.
 */
@Service
public class UserService { // Forma correcta de hacer uso de los repositorios.

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metodos que se ajustan a necesidades especificas
}
