package com.cadastro.desafio.service.serviceImpl;

import com.cadastro.desafio.exception.BusinessException;
import com.cadastro.desafio.model.Projeto;
import com.cadastro.desafio.repository.ProjetoRepository;
import com.cadastro.desafio.service.ProjetoService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<Projeto> listaProjetos() {
		try {
			ArrayList<Projeto> lista = new ArrayList<>();
			projetoRepository.findAll().forEach(todo -> lista.add(todo));

			return lista;
		} catch (final Exception e) {
			throw new BusinessException("Erro ao listar todas os projetos.", e);
		}
	}

	@Override
	public boolean salvar(Projeto projeto) {
		try {
			// Validações dos campos
			Assert.notNull(projeto.getNome(), "Nome é um campo obrigatório.");
			Assert.notNull(projeto.getGerente(), "Gerente é um campo obrigatório.");

			projetoRepository.save(projeto);

			if (getProjetoFindById(projeto.getId()) != null) {
				return true;
			}

			return false;

		} catch (final Exception e) {
			throw new BusinessException("Falha ao salvar o projeto, verifique os campos informados.", e);
		}
	}

	@Override
	public boolean excluirProjeto(Long id) {
		try {
			String status = projetoRepository.findById(id).get().getStatus();
			
			if (status.equalsIgnoreCase("iniciado") 
					||status.equalsIgnoreCase("em andamento")
							||status.equalsIgnoreCase("encerrado")) {
				throw new BusinessException("Projeto não pode ser excluido com o status de '"+ status+"'");				
			} else {
				projetoRepository.deleteById(id);	
			}			

			if (projetoRepository.findById(id).isEmpty()) {
				return true;
			}

			return false;
		} catch (final Exception e) {
			throw new BusinessException("Falha ao tentar excluir o projeto.", e);
		}
	}

	@Override
	public Projeto getProjetoFindById(Long id) {
		return projetoRepository.findById(id).get();
	}

}