package com.cadastro.desafio.repository;

import com.cadastro.desafio.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    Projeto findById(long id);
}