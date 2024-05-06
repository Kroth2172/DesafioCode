package com.cadastro.desafio.service;

import com.cadastro.desafio.model.Membro;
import com.cadastro.desafio.model.Pessoa;

import java.util.List;

public interface MembroService {

    List<Membro> listaMembros();

    Membro salvar(Membro pessoa) throws Exception;

}
