package com.michelon.demoapitest.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

/**
 * @autor raqueldarellimichelon
 * created on 24/05/23 inside the package - com.michelon.demoapitest.user
 *
 * Since userRepository was already tested, we should mock userRepository here.
 * This way we isolate the service layer to test it.
 **/
@ExtendWith(MockitoExtension.class) //with this annotation, the Autoclosable is dispensable.
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
//    private AutoCloseable autoCloseable;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        //to initialize the mock; if you have more than one, it will initialize all of them
//        autoCloseable = MockitoAnnotations.openMocks(this);

        underTest = new UserService(userRepository);
    }

//    @AfterEach
//    void tearDown() {
//        //to close the resource after each test
//        autoCloseable.close();
//    }

    @Test
    void canGetAllUsers() throws Exception {
        //when
        underTest.getAllUsers();

        //then - check if repository was invoked using findAll()
        verify(userRepository).findAll();

    }

    @Test
    @Disabled
    void addUser() {
    }

    @Test
    @Disabled
    void deleteUser() {
    }
}