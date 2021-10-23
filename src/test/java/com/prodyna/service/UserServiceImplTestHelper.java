package com.prodyna.service;

import com.prodyna.model.Gender;
import com.prodyna.model.UserDTO;

import java.util.List;

public class UserServiceImplTestHelper {
    static List<UserDTO> getAllUsers() {
        return List.of(
            new UserDTO(3, "Manly Man", Gender.MALE, 48),
            new UserDTO(0, "Max Mustermann", Gender.MALE, 41),
            new UserDTO(1, "Maria Musterfrau", Gender.FEMALE, 29),
            new UserDTO(-1, "Buggy McGlitch", Gender.OTHER, 400),
            new UserDTO(4, "Madonna", Gender.FEMALE, 63)
        );
    }

    static List<UserDTO> getAllUsersSorted() {
        return List.of(
            new UserDTO(-1, "Buggy McGlitch", Gender.OTHER, 400),
            new UserDTO(1, "Maria Musterfrau", Gender.FEMALE, 29),
            new UserDTO(3, "Manly Man", Gender.MALE, 48),
            new UserDTO(4, "Madonna", Gender.FEMALE, 63),
            new UserDTO(0, "Max Mustermann", Gender.MALE, 41)
        );
    }
}
