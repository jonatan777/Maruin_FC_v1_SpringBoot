package com.pelada.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pelada.modelo.Jogadores;
import com.pelada.repository.JogadorRepositoryJDBC;

@Service
@Transactional
public class JogadorServiceJDBC {

	
	@Autowired
	private JogadorRepositoryJDBC jogadorRepositoryJDBC;
	
	
	public List<Jogadores> service_lista_para_exibir_pontos() {
		return jogadorRepositoryJDBC.lista_para_exibir_pontos();
	}
	
	public List<Jogadores> service_lista_para_exibir_gols() {
		return jogadorRepositoryJDBC.lista_para_exibir_gols();
	}
	
	public List<Jogadores> service_lista_para_gerenciamento() {
		return jogadorRepositoryJDBC.lista_para_gerenciamento();
	}
	
	public List<Jogadores> gols_sofridos() {
		return jogadorRepositoryJDBC.findAll();
	}
	
}
