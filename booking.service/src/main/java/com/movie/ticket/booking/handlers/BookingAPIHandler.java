package com.movie.ticket.booking.handlers;


import com.movie.ticket.booking.dtos.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class BookingAPIHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

//        List<ObjectError> errors = methodArgumentNotValidException.getBindingResult().getAllErrors();
//        List<String> errorMessages = new ArrayList<>();
//        for (ObjectError error : errors) {
//            errorMessages.add(error.getDefaultMessage());
//        }
        return new ResponseEntity<ResponseDto>(ResponseDto.builder()
                .errorMessage(
                        methodArgumentNotValidException.getBindingResult().getAllErrors()
                                .stream()
//                                .map(objectError -> objectError.getDefaultMessage())
                                .map(ObjectError::getDefaultMessage)
                                .collect(Collectors.toList())
                )
                .build(), HttpStatus.BAD_REQUEST);
    }
}
