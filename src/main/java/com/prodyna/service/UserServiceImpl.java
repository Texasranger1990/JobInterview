package com.prodyna.service;

import com.prodyna.model.UserDTO;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserServiceImpl implements UserService{
    private final HttpClient client;

    @Inject
    public UserServiceImpl(HttpClient client) {
        this.client = client;
    }

    @Override
    public List<UserDTO> getUsers() throws IOException {
        final String usersAsString = getUsersAsString();

        return null;
    }

    @Override
    public List<UserDTO> getUsersSorted() {
        return null;
    }

    private String getUsersAsString() throws IOException {
        final HttpResponse response = client.execute(new HttpGet("https://www.example.com"));
        final HttpEntity entity = response.getEntity();
        return IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8);
    }
}
