package com.cadastro.desafio.service.serviceImpl;

import com.cadastro.desafio.exception.BusinessException;
import com.cadastro.desafio.model.Pessoa;
import com.cadastro.desafio.repository.PessoaRepository;
import com.cadastro.desafio.service.PessoaService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Pessoa> listaPessoas() {
        try{
            return pessoaRepository.findAll();
        } catch (final Exception e) {
            throw new BusinessException("Erro ao listar todas as pessoas.", e);
        }
    }
    
    @Override
    public List<Pessoa> listaPessoasGerente() {
        try{
            return pessoaRepository.findPessoaGerente(true);
        } catch (final Exception e) {
            throw new BusinessException("Erro ao listar todas as pessoas.", e);
        }
    }
    
	@Override
	public boolean salvar(Pessoa pessoa) {
		try {
			pessoaRepository.save(pessoa);

			if (getPessoaFindById(pessoa.getId()) != null) {
				return true;
			}

			return false;

		} catch (final Exception e) {
			throw new BusinessException("Falha ao salvar a pessoa, verifique os campos informados.", e);
		}
	}

	@Override
	public boolean excluirPessoa(Long id) {
		try {
			pessoaRepository.deleteById(id);	
		
			if (pessoaRepository.findById(id).isEmpty()) {
				return true;
			}

			return false;
		} catch (final Exception e) {
			throw new BusinessException("Falha ao tentar excluir a pessoa.", e);
		}
	}

	@Override
	public Pessoa getPessoaFindById(Long id) {
		return pessoaRepository.findById(id).get();
	}

}