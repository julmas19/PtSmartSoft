package com.julmas.pt_smartsoft_back.Excepciones;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import java.util.HashMap;
import java.util.Map;

//Clase de control global para Exepciones de tipo BAD_REQUEST para obtener mas detalles sobre los errores
@RestControllerAdvice
public class GlobalExceptionHandler {
    Map<String, String> errors = new HashMap<>();
    // Manejo de errores de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        //Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Manejo de errores de formato JSON
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleJsonParseException(HttpMessageNotReadableException ex) {
        System.err.println(ex.getMessage());
        errors.put("error", "Error en el formato de la solicitud: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Manejo de excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception e) {
        e.printStackTrace();
        System.err.println(e.getMessage());
        errors.put("error", "Ocurrió un error: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Manejo de excepciones NotFound
    @ExceptionHandler(GlobalExceptionNotFound.class)
    public ResponseEntity<Map<String, String>> handleGlobalExceptionNotFound(GlobalExceptionNotFound e) {
        e.printStackTrace();
        errors.put("error", "Ocurrió un error: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    
}
