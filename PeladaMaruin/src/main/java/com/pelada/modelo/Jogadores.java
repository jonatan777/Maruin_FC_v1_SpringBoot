package com.pelada.modelo;





import javax.persistence.Entity;     
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Jogadores {
	
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private Long id;

	private String imagen;
	
	@NotNull
	private String nome;
	@NotNull
	private String posicao;
	
	
	
	
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;	
	private int expulsao;
	private int gols;
	private int gols_sofridos;
	
	
	
	
	
	  public Jogadores() {
		
	}



	public Jogadores(Long id, String imagen, String nome, String posicao, int jogos, int vitorias, int empates, int derrotas, int pontos, int expulsao, int gols, int gols_sofridos) {
		    this.id = id;
		    this.imagen = imagen;
		    this.nome = nome;
		    this.posicao = posicao;
		    this.jogos = jogos;
		    this.vitorias = vitorias;
		    this.empates = empates;
		    this.derrotas = derrotas;
		    this.pontos = pontos;
		    this.expulsao = expulsao;
		    this.gols = gols;
		    this.gols_sofridos = gols_sofridos;
		}
	
	
	@Override
	public String toString() {
		return String.format(
				"Jogadores[id=%d, imagen='%s', nome='%s', posicao='%s', jogos='%d', vitorias='%d', empates='%d', derrotas='%d', expulsao='%d', pontos='%d', gols='%d', gols_sofridos='%d']",
				id, imagen, nome, posicao, jogos, vitorias, empates, derrotas,  expulsao, pontos, gols, gols_sofridos);
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	
	public int getJogos() {
		return jogos;
	}
	public void setJogos(int jogos) {
		this.jogos = jogos;
	}
	
	
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	
	
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	
	
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	
	
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
	
	public int getExpulsao() {
		return expulsao;
	}
	
	public void setExpulsao(int expulsao) {
		this.expulsao = expulsao;
	}
	
	
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}



	public int getGols_sofridos() {
		return gols_sofridos;
	}



	public void setGols_sofridos(int gols_sofridos) {
		this.gols_sofridos = gols_sofridos;
	}




}
