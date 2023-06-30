package com.example.receitaapi.controller;

import com.example.receitaapi.model.ReceitaModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

  @GetMapping
  public List<ReceitaModel> listarReceitas() {
    ReceitaModel receita1 = new ReceitaModel(1L, new Date(), "Bolo de Fuba");
    ReceitaModel receita2 = new ReceitaModel(2L, new Date(), "Bolo de Chocolate");

    receita1.setAutor("Dwolter");
    receita2.setModoDePreparo("3 horas de forno");

    List<ReceitaModel> listaGeral = new ArrayList<>();
    listaGeral.add(receita1);
    listaGeral.add(receita2);

    return listaGeral;
  }


}
