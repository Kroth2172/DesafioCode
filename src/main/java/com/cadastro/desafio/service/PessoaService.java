package com.cadastro.desafio.service;

import com.cadastro.desafio.model.Pessoa;
import java.util.List;

public interface PessoaService {

    List<Pessoa> listaPessoas();
    
    List<Pessoa> listaPessoasGerente();
    
    boolean salvar(Pessoa pessoa);
    
    boolean excluirPessoa(Long id);
    
    Pessoa getPessoaFindById(Long id);

}
