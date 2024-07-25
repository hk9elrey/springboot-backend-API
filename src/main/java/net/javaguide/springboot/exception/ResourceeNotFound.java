package net.javaguide.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceeNotFound extends RuntimeException{
    public ResourceeNotFound(String message){
        super(message);
    }
}
