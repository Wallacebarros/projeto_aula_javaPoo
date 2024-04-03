package br.com.poojava.exepitions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AplicationExepition extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handlerExeption(NullPointerException exception) {
        ErrosMenssage erro = new ErrosMenssage(HttpStatus.BAD_GATEWAY.value(), "usuario não encontrado");
        return new ResponseEntity<>(erro, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> hResponseEntity(DataIntegrityViolationException exception) {
        ErrosMenssage erro = new ErrosMenssage(HttpStatus.CONFLICT.value(), "email ja cadastrado");
        return new ResponseEntity<>(erro, HttpStatus.CONFLICT);
    }
}


