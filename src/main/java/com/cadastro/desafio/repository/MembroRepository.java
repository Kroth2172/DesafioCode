package com.cadastro.desafio.repository;

import com.cadastro.desafio.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long> {
    Membro findById(long id);
}