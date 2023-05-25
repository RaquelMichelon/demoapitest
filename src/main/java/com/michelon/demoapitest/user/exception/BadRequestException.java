package com.michelon.demoapitest.user.exception;

import jakarta.validation.constraints.Email;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @autor raqueldarellimichelon
 * created on 24/05/23 inside the package - com.michelon.demoapitest.user.exception
 **/
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) {
        super(msg);
    }
}


