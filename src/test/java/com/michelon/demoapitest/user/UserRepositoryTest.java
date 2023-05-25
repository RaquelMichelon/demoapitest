package com.michelon.demoapitest.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @autor raqueldarellimichelon
 * created on 24/05/23 inside the package - com.michelon.demoapitest.user
 *
 * It's important to test the methods with custom queries only.
 **/
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenUserEmailExists() {

        //given
        String email = "raquel@gmail.com";
        User user = new User("Raquel", email, Gender.FEMALE);
        underTest.save(user);

        //when
        boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenUserEmailDoesNotExist() {

        //given
        String email = "raquel@gmail.com";


        //when
        boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isFalse();
    }



}