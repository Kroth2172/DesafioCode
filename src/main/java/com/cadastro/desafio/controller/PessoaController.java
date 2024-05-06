package com.cadastro.desafio.controller;

import com.cadastro.desafio.model.Pessoa;
import com.cadastro.desafio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PessoaController {

    @Autowired
    PessoaService pessoaService;
    
	@GetMapping({ "/pessoa/listarPessoas", "listarPessoas" })
	public String ListarPEssoas(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", pessoaService.listaPessoas());
		model.addAttribute("message", message);

		return "pessoa/ListarPessoas";
	}

	@GetMapping("/pessoa/novaPessoa")
	public String adicionaNovaPessoa(Model model) {		
		model.addAttribute("todo", new Pessoa());

		return "pessoa/NovaPessoa";
	}

	@PostMapping("/pessoa/salvarPessoa")
	public String salvarPessoa(Pessoa pessoa, RedirectAttributes redirectAttributes) throws Exception {
		if (pessoaService.salvar(pessoa)) {
			redirectAttributes.addFlashAttribute("message", "Salvo com Sucesso!");
			return "redirect:/pessoa/listarPessoas";
		}

		redirectAttributes.addFlashAttribute("message", "Falha ao Salvar!");
		return "redirect:/pessoa/novaPessoa";
	}


	@GetMapping("/pessoa/editarPessoa/{id}")
	public String editarPessoa(@PathVariable Long id, Model model) {
		model.addAttribute("listaGerente", pessoaService.listaPessoasGerente());
		model.addAttribute("todo", pessoaService.getPessoaFindById(id));

		return "pessoa/EditarPessoa";
	}

	@PostMapping("/pessoa/salvarEditarPessoa")
	public String salvarEdicaoPessoa(Pessoa pessoa, RedirectAttributes redirectAttributes) throws Exception {
		if (pessoaService.salvar(pessoa)) {
			redirectAttributes.addFlashAttribute("message", "Editado com Sucesso!");
			return "redirect:/pessoa/listarPessoas";
		}

		redirectAttributes.addFlashAttribute("message", "Falha ao Editar!");
		return "redirect:/pessoa/editarPessoa/" + pessoa.getId();
	}
		
	@GetMapping("/pessoa/excluirPessoa/{id}")
	public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (pessoaService.excluirPessoa(id)) {
			redirectAttributes.addFlashAttribute("message", "Excluido com sucesso!");
			return "redirect:/pessoa/listarPessoas";
		}
		
		redirectAttributes.addFlashAttribute("message", "Falha ao excluir!");
		return "redirect:/pessoa/listarPessoas";
	}
}
