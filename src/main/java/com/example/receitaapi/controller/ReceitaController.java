package com.example.receitaapi.controller;

import com.example.receitaapi.model.ReceitaModel;
import com.example.receitaapi.repository.ReceitaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @GetMapping(value = "/{id}")
  public ResponseEntity<?> buscaReceitas(@PathVariable("id") Long id) {
    Optional<ReceitaModel> receitaModel = receitaRepository.findById(id);
    if (receitaModel.isPresent()) {
      return ResponseEntity.ok().body(receitaModel);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Receita com id: " + id + " não encontrado na base de dados");
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

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> excluirReceita(@PathVariable("id") Long id) {
    try {
      receitaRepository.deleteById(id);
      return ResponseEntity.ok().body("Receita ecluida com sucesso!");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registro inexistente");
    }
  }

}
