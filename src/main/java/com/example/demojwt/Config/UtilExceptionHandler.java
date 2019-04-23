package com.example.demojwt.Config;

import com.example.demojwt.Utils.ErrorResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Calendar;

@ControllerAdvice
public class UtilExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponseWrapper> exception(UsernameNotFoundException e) {
        ErrorResponseWrapper wrapper = new ErrorResponseWrapper();
        wrapper.statusCode = HttpStatus.OK.value();
        wrapper.message = e.getMessage();
        wrapper.setTimestamp(Calendar.getInstance().getTimeInMillis());

        return new ResponseEntity<>(wrapper,HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseWrapper> exception(Exception e) {
        ErrorResponseWrapper wrapper = new ErrorResponseWrapper();
        wrapper.statusCode = HttpStatus.OK.value();
        wrapper.message = e.getMessage();
        wrapper.setTimestamp(Calendar.getInstance().getTimeInMillis());

        return new ResponseEntity<>(wrapper,HttpStatus.OK);
    }
}