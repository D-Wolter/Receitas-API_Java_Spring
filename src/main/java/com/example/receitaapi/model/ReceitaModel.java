package com.example.receitaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

  @Column(name = "name", length = 100, nullable = false)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String nome;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Temporal(TemporalType.DATE)
  private Date dataInclusao;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Column(name = "autor", length = 100, nullable = false)
  private String autor;

  @Transient
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<Ingredinte> ingredientes;
  
  @Lob
  @Column(name = "modo_de_preparo", nullable = false)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String modoDePreparo;

  @Column(name = "descricao", length = 250, nullable = false)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String descricao;


  public ReceitaModel(long id, String descricao, String nomeReceita) {
    this.id = id;
    this.descricao = descricao;
    this.nome = nomeReceita;
  }
}

