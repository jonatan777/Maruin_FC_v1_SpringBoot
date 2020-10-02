package com.pelada.repository;



import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;

import com.pelada.modelo.Jogadores;

@Repository
public interface JogadorRepository extends JpaRepository<Jogadores, Long>{

}


