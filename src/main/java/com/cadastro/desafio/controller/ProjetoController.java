package com.cadastro.desafio.controller;

import com.cadastro.desafio.model.Projeto;
import com.cadastro.desafio.service.PessoaService;
import com.cadastro.desafio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
public class ProjetoController {

	@Autowired
	ProjetoService projetoService;
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping({ "/", "home" })
	public String home(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", projetoService.listaProjetos());
		model.addAttribute("message", message);

		return "home/Home";
	}

	@GetMapping({ "/projeto/listarProjetos", "listarProjetos" })
	public String ListarProjetos(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", projetoService.listaProjetos());
		model.addAttribute("message", message);

		return "projeto/ListarProjetos";
	}

	@GetMapping("/projeto/novoProjeto")
	public String adicionaNovoProjeto(Model model) {
		model.addAttribute("listaGerente", pessoaService.listaPessoasGerente());
		model.addAttribute("todo", new Projeto());

		return "projeto/NovoProjeto";
	}

	@PostMapping("/projeto/salvarProjeto")
	public String salvarProjeto(Projeto projeto, RedirectAttributes redirectAttributes) throws Exception {
		if (projetoService.salvar(projeto)) {
			redirectAttributes.addFlashAttribute("message", "Salvo com Sucesso!");
			return "redirect:/projeto/listarProjetos";
		}

		redirectAttributes.addFlashAttribute("message", "Falha ao Salvar!");
		return "redirect:/projeto/novoProjeto";
	}

	@GetMapping("/projeto/editarProjeto/{id}")
	public String editarProjeto(@PathVariable Long id, Model model) {
		model.addAttribute("listaGerente", pessoaService.listaPessoasGerente());
		model.addAttribute("todo", projetoService.getProjetoFindById(id));

		return "projeto/EditarProjeto";
	}

	@PostMapping("/projeto/salvarEditarProjeto")
	public String salvarEdicaoProjeto(Projeto projeto, RedirectAttributes redirectAttributes) throws Exception {
		if (projetoService.salvar(projeto)) {
			redirectAttributes.addFlashAttribute("message", "Editado com Sucesso!");
			return "redirect:/projeto/listarProjetos";
		}

		redirectAttributes.addFlashAttribute("message", "Falha ao Editar!");
		return "redirect:/projeto/editarProjeto/" + projeto.getId();
	}
		
	@GetMapping("/projeto/excluirProjeto/{id}")
	public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (projetoService.excluirProjeto(id)) {
			redirectAttributes.addFlashAttribute("message", "Excluido com sucesso!");
			return "redirect:/projeto/listarProjetos";
		}
		
		redirectAttributes.addFlashAttribute("message", "Falha ao excluir!");
		return "redirect:/projeto/listarProjetos";
	}
	
}