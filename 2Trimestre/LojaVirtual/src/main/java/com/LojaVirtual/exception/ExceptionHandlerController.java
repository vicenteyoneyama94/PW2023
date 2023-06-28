package com.LojaVirtual.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.LojaVirtual.exception.model.ErroValidacaoObjeto;
import com.LojaVirtual.exception.model.ErroValidacaoResposta;

public class ExceptionHandlerController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroValidacaoResposta> handleValidationException(MethodArgumentNotValidException ex) {
        
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<ErroValidacaoObjeto> erros = new ArrayList<>();
        for (FieldError fieldError : fieldErrors){
            ErroValidacaoObjeto erroValidacao =
            new ErroValidacaoObjeto(fieldError.getDefaultMessage(),
            fieldError.getField(), fieldError.getRejectedValue());
            erros.add(erroValidacao);
        }

        ErroValidacaoResposta errorResponse = new ErroValidacaoResposta
        ("Erro de validação", 500, "Bad Request",
        ex.getObjectName(), erros);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        
    }
}

