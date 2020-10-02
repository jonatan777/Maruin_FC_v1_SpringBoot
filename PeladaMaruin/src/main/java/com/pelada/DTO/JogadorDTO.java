package com.pelada.DTO;

import javax.validation.constraints.NotBlank; 

import com.pelada.modelo.Jogadores;


public class JogadorDTO {
	
	
	
	private Long id;
    
    @NotBlank(message = "{name.not.blank}")
    private String nome;
    
      
    @NotBlank(message = "{posicao.not.blank}")
    private String posicao;
    
    private String imagen;
    
    private int jogos;
    
    private int vitorias;
    
    private int derrotas;
    
    private int empates;
    
    private int expulsao;
    
    private int pontos;
    
    private int gols;
    
    private int gols_sofridos;
    
    
    public Jogadores transformaParaObjeto(){
        return new Jogadores(id, nome, posicao, imagen, jogos, vitorias, derrotas, empates, expulsao, pontos, gols, gols_sofridos );
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
	

}
