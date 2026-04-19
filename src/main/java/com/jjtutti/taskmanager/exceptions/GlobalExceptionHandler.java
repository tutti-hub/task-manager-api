package com.jjtutti.taskmanager.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.jjtutti.taskmanager.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ UserNotFoundException.class,
            TaskNotFoundException.class })
    public ResponseEntity<ErrorDto> handleNotFoundException(
            RuntimeException ex, HttpServletRequest request) {
        var response = new ErrorDto(LocalDateTime.now(),
                NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");

        var response = new ErrorDto(LocalDateTime.now(),
                BAD_REQUEST.value(),
                message,
                request.getRequestURI());

        return ResponseEntity.status(BAD_REQUEST).body(response);
    }
}
