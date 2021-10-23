package com.prodyna.service;

import com.prodyna.model.UserDTO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private HttpClient client;

    @Before
    public void setup() throws IOException {
        final HttpEntity entity = mock(HttpEntity.class);
        final InputStream mockResource = getClass().getClassLoader().getResourceAsStream("mockResponse.json");
        when(entity.getContent()).thenReturn(mockResource);
        final HttpResponse response = mock(HttpResponse.class);
        when(response.getEntity()).thenReturn(entity);
        when(client.execute(any(HttpUriRequest.class))).thenReturn(response);
    }

    @Test
    public void getAllUsers() throws IOException {
        List<UserDTO> users = userService.getUsers();

        assertNotNull(users);
        assertEquals(UserServiceImplTestHelper.getAllUsers(), users);
    }

    @Test
    //The sorting is numerically ascending, with the twist, that 0 should come last
    public void getAllUsersSorted() throws IOException {
        List<UserDTO> users = userService.getUsersSorted();

        assertNotNull(users);
        assertEquals(UserServiceImplTestHelper.getAllUsersSorted(), users);
    }
}
