package com.example.receitaapi.service;

import com.example.receitaapi.error.handler.ReceitaNotFoundException;
import com.example.receitaapi.model.Receita;
import com.example.receitaapi.repository.ReceitaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

  @Autowired
  ReceitaRepository receitaRepository;

  public List<Receita> listar() {
    return receitaRepository.findAll();
  }

  public Optional<Receita> buscarPorId(Long id) {
    Optional<Receita> receitaModel = receitaRepository.findById(id);
    if (receitaModel.isPresent()) {
      return receitaModel;
    }
    throw new ReceitaNotFoundException("Receita com o id: " + id + " não foi encontrada.");
  }

  public Receita salvar(Receita receita) {
    receita.setId(null);
    receita.setDataInclusao(new Date());
    return receitaRepository.save(receita);
  }

  public void atualizar(Long id, Receita receita) {
    if (receitaRepository.findById(id).isEmpty()) {
      throw new ReceitaNotFoundException("Receita com o id: " + id + " não foi encontrada.");
    }
    receita.setId(id);
    receitaRepository.save(receita);
  }

  public void excluir(Long id) {
    if (receitaRepository.findById(id).isEmpty()) {
      throw new ReceitaNotFoundException("Receita com o id: " + id + " não foi encontrada.");
    }
    receitaRepository.deleteById(id);
  }
}