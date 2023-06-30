package com.example.receitaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReceitaModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Long id;
  private String nome;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Date dataInclusao;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String autor;
  @Transient
  private List<Ingredinte> ingredientes;
  private String modoDePreparo;
  private String descricao;


  public ReceitaModel(long id, String descricao, String nomeReceita) {
    this.id = id;
    this.descricao = descricao;
    this.nome = nomeReceita;
  }
}

