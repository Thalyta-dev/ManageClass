package com.manageclass.ManageClass.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionNoFound extends Exception {

    public ExceptionNoFound(Long id, String tipo) {
        super("Not find " + tipo  +"with id " + id);
    }
}
