package com.michelon.demoapitest.user;

import com.michelon.demoapitest.user.exception.BadRequestException;
import com.michelon.demoapitest.user.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor raqueldarellimichelon
 * created on 24/05/23 inside the package - com.michelon.demoapitest.user
 **/
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Boolean existsByEmail = userRepository.selectExistsEmail(user.getEmail());
        if(existsByEmail) {
            throw new BadRequestException("Email " + user.getEmail() + " taken.");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " does not exist.");
        }
        userRepository.deleteById(id);
    }
}


