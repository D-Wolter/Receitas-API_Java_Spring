package com.example.receitaapi.controller;

import com.example.receitaapi.model.ReceitaModel;
import com.example.receitaapi.repository.ReceitaRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

  @Autowired
  ReceitaRepository receitaRepository;

  @GetMapping
  public List<ReceitaModel> listarReceitas() {
    return receitaRepository.findAll();
  }

  @PostMapping
  public ReceitaModel salvarReceita(@RequestBody ReceitaModel receitaModel) {
    receitaModel.setDataInclusao(new Date());
    return receitaRepository.save(receitaModel);
  }

  @PutMapping(value = "/{id}")
  public ReceitaModel atualizarReceita(@PathVariable("id") Long id,
      @RequestBody ReceitaModel receitaModel) {
    receitaModel.setId(id);
    return receitaRepository.save(receitaModel);
  }

}
