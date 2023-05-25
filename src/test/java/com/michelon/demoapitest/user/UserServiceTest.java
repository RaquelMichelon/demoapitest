package com.michelon.demoapitest.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

/**
 * @autor raqueldarellimichelon
 * created on 24/05/23 inside the package - com.michelon.demoapitest.user
 *
 * Since userRepository was already tested, we should mock userRepository here.
 * This way we isolate the service layer to test it.
 *
 * click on Run test with coverage to see what is not covered yet
 **/
@ExtendWith(MockitoExtension.class) //with this annotation, the Autoclosable is dispensable.
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
    }


    @Test
    void canGetAllUsers() throws Exception {
        //when
        underTest.getAllUsers();

        //then - check if repository was invoked using findAll()
        verify(userRepository).findAll();

    }

    @Test
    void canAddUser() {

        //given
        User user = new User("Raquel", "raquel@gmail.com", Gender.FEMALE);

        //when
        underTest.addUser(user);

        //then - check that repository was invoked (calling save) with the same user we passed
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        //capture the value passed
        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedStudent = userArgumentCaptor.getValue();

        //make sure the value is the same we passed on the underTest
        assertThat(capturedStudent).isEqualTo(user);
    }

    @Test
    @Disabled
    void deleteUser() {
    }
}