package com.cadastro.desafio.repository;

import com.cadastro.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
	Pessoa findById(long id);
   
	@Query("select l from Pessoa l where l.gerente = ?1")
	List<Pessoa> findPessoaGerente(boolean gerente);
    
}