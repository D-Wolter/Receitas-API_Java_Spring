package com.example.receitaapi.repository;

import com.example.receitaapi.model.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {

}
