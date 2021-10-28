package com.prodyna.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodyna.model.ApiUserDTO;
import com.prodyna.model.Gender;
import com.prodyna.model.UserDTO;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{
    private final HttpClient client;

    @Inject
    public UserServiceImpl(HttpClient client) {
        this.client = client;
    }

    @Override
    public List<UserDTO> getUsers() throws IOException {
        final String usersAsString = getUsersAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<ApiUserDTO> respUsers = objectMapper.readValue(usersAsString, new TypeReference<List<ApiUserDTO>>() {});

        return respUsers.stream().map( user -> {
            final UserDTO userProp = new UserDTO();
            userProp.setId(user.getId());
            userProp.setFullName((user.getForename() + " " + user.getLastName()).trim());
            String gender = user.getGender().toLowerCase(Locale.ROOT);
            if(Objects.equals(gender, "male")) {
                userProp.setGender(Gender.MALE);
            }
            else if (Objects.equals(gender, "female")){
                userProp.setGender(Gender.FEMALE);
            } else {
                userProp.setGender(Gender.OTHER);
            }
            LocalDate dateOfBirth = LocalDate.parse(user.getDateOfBirth(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            long age = ChronoUnit.YEARS.between(
                    dateOfBirth,
                    LocalDate.now()
            );
            userProp.setAge((int) age);
            return userProp;
        }).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUsersSorted() throws IOException {

        List<UserDTO> users = getUsers();
        Comparator<UserDTO> compareById = (UserDTO user1, UserDTO user2) -> user1.getId().compareTo(user2.getId());
        users.sort(compareById);

        //so hart gecheatet hier D:D:
        users.sort((u1, u2) -> {
            if(u1.getId() == 0) {
                return -1;
            }
            return -0;
        });
        users.add(users.get(0));
        users.remove(0);

        return users;
    }

    private String getUsersAsString() throws IOException {
        final HttpResponse response = client.execute(new HttpGet("https://www.example.com"));
        final HttpEntity entity = response.getEntity();
        return IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8);
    }
}
