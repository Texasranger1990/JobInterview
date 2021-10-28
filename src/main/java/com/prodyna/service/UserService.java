package com.prodyna.service;

import com.prodyna.model.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserDTO> getUsers() throws IOException;

    List<UserDTO> getUsersSorted() throws IOException;
}
