package com.example.receitaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingrediente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonInclude
  Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "receita_id")
  @JsonIgnore
  Receita receita;
  String nome;
  String qtd;
}