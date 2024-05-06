package com.cadastro.desafio.service;

import com.cadastro.desafio.model.Projeto;

import java.util.List;

public interface ProjetoService {

    List<Projeto> listaProjetos();
    
    boolean salvar(Projeto projeto);
    
    boolean excluirProjeto(Long id);
        
    Projeto getProjetoFindById(Long id);

}
