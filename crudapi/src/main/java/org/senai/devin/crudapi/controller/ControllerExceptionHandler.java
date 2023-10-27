package org.senai.devin.crudapi.controller;

import org.senai.devin.crudapi.exceptions.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/* Responsável por mapear, tratar e lançar as exceções que chegarem ao controller */
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * O @ExceptionHandler informa qual a exceção tratada aqui, e o corpo da requisição
     * retorna o status 404 com a mensagem trazida pela exceção.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    /**
     * Aqui, valida-se as mensagens do Bean Validation, recuperando cada mensagem e adicionando-as na lista.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleBeanValidationException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> messages = bindingResult.getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();

//        List<String> messages = bindingResult.getFieldErrors()
//                .stream().map(error -> error.getDefaultMessage()).toList()

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messages);
    }
}
