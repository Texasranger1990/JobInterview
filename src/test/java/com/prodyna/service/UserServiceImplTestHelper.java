package com.prodyna.service;

import com.prodyna.model.Gender;
import com.prodyna.model.UserDTO;

import java.util.List;

public class UserServiceImplTestHelper {
    static List<UserDTO> getAllUsers() {
        return List.of(
            new UserDTO("Manly Man", Gender.MALE, 48),
            new UserDTO("Max Musermann", Gender.MALE, 41),
            new UserDTO("Maria Muserfrau", Gender.FEMALE, 29),
            new UserDTO("Buggy McGlitch", Gender.OTHER, 400)
        );
    }

    static List<UserDTO> getAllUsersSorted() {
        return List.of(
            new UserDTO("Buggy McGlitch", Gender.OTHER, 400),
            new UserDTO("Maria Muserfrau", Gender.FEMALE, 29),
            new UserDTO("Manly Man", Gender.MALE, 48),
            new UserDTO("Max Musermann", Gender.MALE, 41)
        );
    }
}
