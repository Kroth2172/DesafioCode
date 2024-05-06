package com.cadastro.desafio.service.serviceImpl;

import com.cadastro.desafio.exception.BusinessException;
import com.cadastro.desafio.model.Membro;
import com.cadastro.desafio.repository.MembroRepository;
import com.cadastro.desafio.service.MembroService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class MembroServiceImpl implements MembroService {

    @Autowired
    MembroRepository membroRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Membro> listaMembros() {
        try{
            return membroRepository.findAll();
        } catch (final Exception e) {
            throw new BusinessException("Erro ao listar todas os membros.", e);
        }
    }
    
    @Override
	public Membro salvar(Membro membro)  {
        try {
            membroRepository.save(membro);
            return membro;
        } catch (final Exception e) {
            throw new BusinessException("Erro ao salvar o membro.", e);
        }
	}

}