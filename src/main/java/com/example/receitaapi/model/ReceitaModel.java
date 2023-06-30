package com.example.receitaapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaModel {
 private Long id;
 private String nome;
 private Date dataInclusao;
 @JsonInclude(JsonInclude.Include.NON_NULL)
 private String autor;
 private List<Ingredinte> ingredientes;
 private String modoDePreparo;



  public ReceitaModel(long id, Date dataInclusao, String nomeReceita) {
    this.id = id;
    this.dataInclusao = dataInclusao;
    this.nome = nomeReceita;
  }

}
