package com.pelada.DTO;

import com.pelada.modelo.Jogadores;



public class JogadorRespostaDTO {
	
	
    private String nome;
    private String posicao;
    
    
    public JogadorRespostaDTO(String nome2, String posicao2) {
    	
	}


	public static JogadorRespostaDTO transformaEmDTO(Jogadores jogadores) {
        return new JogadorRespostaDTO(jogadores.getNome(),jogadores.getPosicao());
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
