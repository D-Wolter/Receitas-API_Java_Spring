package com.example.receitaapi.error.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReceitaExceptionHandler {

  @ExceptionHandler(ReceitaNotFoundException.class)
  public ResponseEntity<?> handleReceitaNotFoundException(ReceitaNotFoundException re,
      HttpServletRequest request) {
    ErrorDetalhes errorDetalhes = new ErrorDetalhes();
    errorDetalhes.setTitulo(re.getMessage());
    errorDetalhes.setStatus(404);
    errorDetalhes.setTimestamp(System.currentTimeMillis());
    errorDetalhes.setDetalhesErro("http://receita-api/erros/404");

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetalhes);
  }
}