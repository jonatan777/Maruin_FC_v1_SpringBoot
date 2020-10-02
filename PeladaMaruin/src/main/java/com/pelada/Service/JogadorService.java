package com.pelada.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pelada.modelo.Jogadores;
import com.pelada.repository.JogadorRepository;





@Service
@Transactional
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public List<Jogadores> listAll() {
		return jogadorRepository.findAll();
	}
	
	public Jogadores get(long id) {
		return jogadorRepository.findById(id).get();
	}
	
    public Jogadores salvar(Jogadores jogadores) {
        return jogadorRepository.save(jogadores);
    }
    
    public void delete(long id) {
    	jogadorRepository.deleteById(id);
	}

}
