package com.github.landing_page_service.exception.handler;

import com.github.landing_page_service.exception.UserCreationException;
import com.github.landing_page_service.exception.UserServiceUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserCreationException.class)
    public ResponseEntity<?> handleUserCreationException(UserCreationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse("Błąd tworzenia użytkownika", ex.getMessage()));
    }

    @ExceptionHandler(UserServiceUnavailableException.class)
    public ResponseEntity<?> handleUserServiceUnavailable(UserServiceUnavailableException ex) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(errorResponse("Serwis użytkowników niedostępny", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse("Nieoczekiwany błąd serwera", ex.getMessage()));
    }

    private Map<String, Object> errorResponse(String title, String detail) {
        return Map.of(
                "timestamp", LocalDateTime.now(),
                "error", title,
                "message", detail
        );
    }
}