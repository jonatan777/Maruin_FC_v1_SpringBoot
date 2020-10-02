package com.pelada.controllers;





import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pelada.Service.JogadorService;
import com.pelada.Service.JogadorServiceJDBC;
import com.pelada.modelo.Jogadores;

@Controller
public class JogadorControllerThymeleaf {

	
	@Autowired
	private JogadorService jogadorService;
	   
	
	@Autowired	   
	private JogadorServiceJDBC  jogadorServiceJDBC ; 
	
	
	@GetMapping("/")
    public String index() {
        return "index";
    }
	
	
	  //Busca ordenada com JDBC para Exebição dos dados 
	   @GetMapping("/pontos")
		public ModelAndView lista_exibir_pontos() {
		   ModelAndView modelAndView = new ModelAndView("dados/pontos");
		   modelAndView.addObject("jogadores", jogadorServiceJDBC.service_lista_para_exibir_pontos());
		   
			return modelAndView;
		}
	   
	
	   
		  //Busca ordenada com JDBC para Exebição dos Gols 
	   @GetMapping("/gols")
		public ModelAndView lista_exibir_gols() {
		   ModelAndView modelAndView = new ModelAndView("dados/gols");
		   modelAndView.addObject("jogadores", jogadorServiceJDBC.service_lista_para_exibir_gols());
		   
			return modelAndView;
		}
	   
	   //Busca goleiros referentes a gols sofridos 
	   @GetMapping("/goleiros")
		public ModelAndView lista_gols_sofridos() {
		   ModelAndView modelAndView = new ModelAndView("dados/goleiros");
		   modelAndView.addObject("goleiros", jogadorServiceJDBC.gols_sofridos());
		   
			return modelAndView;
		}
	   
	   
	 //Busca não ordenada com JDBC para manipulação dos dados 
	   @GetMapping("/gerenciar")
		public ModelAndView lista_gerenciar() {
		   ModelAndView modelAndView = new ModelAndView("crud/gerenciar");
		   modelAndView.addObject("jogadores", jogadorService.listAll());
		   
			return modelAndView;
		}
 
	   
	   
	 //Busca não ordenada com JDBC para manipulação da escalação 
	   @GetMapping("/escalacao")
		public ModelAndView lista_escalacao() {
		   ModelAndView modelAndView = new ModelAndView("dados/escalacao");
		   modelAndView.addObject("jogadores", jogadorServiceJDBC.service_lista_para_gerenciamento());
		   
			return modelAndView;
		}
	   
	   
	   
	   
	 //Busca O Jogador po ID e Leva-o para pagina de Edição
	   @GetMapping("/edit/{id}")
		public ModelAndView showEditPlayertPage(@PathVariable(name = "id") Long id) {
			ModelAndView mav = new ModelAndView("crud/edit_jogadores");
			Jogadores jogadores = jogadorService.get(id);
			mav.addObject("jogadores", jogadores);
			
			return mav;
		}
	   
	 //Busca O Jogador po ID e Leva-o para pagina de Detalhes
	   @GetMapping("/detalhe_jogador/{id}")
		public ModelAndView showDetailPlayerPage(@PathVariable(name = "id") Long id) {
			ModelAndView mav = new ModelAndView("dados/detalhe_jogador");
			Jogadores jogadores = jogadorService.get(id);
			mav.addObject("jogadores", jogadores);
			
			return mav;
		}

	   
	 //Salvar Jogador com JPA
	   @PostMapping("/save")
		public String saveProduct(@ModelAttribute("jogadores") Jogadores jogadores) {
		   jogadorService.salvar(jogadores);
			
			return "redirect:/gerenciar";
		}
	   
	 //metodo redireciona para um formulário de Jogador
	   @GetMapping("/new")
		public String showNewProductPage(Model model) {
			Jogadores jogadores = new Jogadores();
			model.addAttribute("jogadores", jogadores);
			
			return "crud/new_jogadores";
		}
	   
	 //DELETAR um  Jogador com JPA
	   @GetMapping("/delete/{id}")
		public String deleteProduct(@PathVariable(name = "id") Long id) {
		   jogadorService.delete(id);
			return "redirect:/";		
		}
	   

	

}
