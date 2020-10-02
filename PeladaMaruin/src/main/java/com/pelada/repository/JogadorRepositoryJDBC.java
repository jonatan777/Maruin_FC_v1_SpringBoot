package com.pelada.repository;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pelada.modelo.Jogadores;

@Repository
public  class JogadorRepositoryJDBC{
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
		
	
  //busca ordenada de  goleiro  tipo 2
  public List<Jogadores> lista_para_exibir_pontos(){
	  
	  return jdbcTemplate.query("select * from jogadores WHERE pontos !=0 ORDER BY pontos DESC",
			  (rs, rowNum) -> new Jogadores(rs.getLong("id"),
					                        rs.getString("imagen"),
					                        rs.getString("nome"),
					                        rs.getString("posicao"),
					                        rs.getInt("jogos"),
					                        rs.getInt("vitorias"),
					                        rs.getInt("derrotas"),
					                        rs.getInt("empates"),
					                        rs.getInt("expulsao"),
					                        rs.getInt("pontos"),
					                        rs.getInt("gols"),
					                        rs.getInt("gols_sofridos")));
  }
  
  
  public List<Jogadores> lista_para_exibir_goleiros(){
	  
	  return jdbcTemplate.query("select * from jogadores WHERE posicao = \"goleiro\" ORDER BY gols_sofridos DESC",
			  (rs, rowNum) -> new Jogadores(rs.getLong("id"),
					                        rs.getString("imagen"),
					                        rs.getString("nome"),
					                        rs.getString("posicao"),
					                        rs.getInt("jogos"),
					                        rs.getInt("vitorias"),
					                        rs.getInt("derrotas"),
					                        rs.getInt("empates"),
					                        rs.getInt("expulsao"),
					                        rs.getInt("pontos"),
					                        rs.getInt("gols"),
					                        rs.getInt("gols_sofridos")));
					                        
  }
  
  
  
  
  
 public List<Jogadores> lista_para_exibir_gols(){
	  
	  return jdbcTemplate.query("select * from jogadores WHERE gols !=0 ORDER BY gols DESC",
			  (rs, rowNum) -> new Jogadores(rs.getLong("id"),
					                        rs.getString("imagen"),
					                        rs.getString("nome"),
					                        rs.getString("posicao"),
					                        rs.getInt("jogos"),
					                        rs.getInt("vitorias"),
					                        rs.getInt("derrotas"),
					                        rs.getInt("empates"),
					                        rs.getInt("expulsao"),
					                        rs.getInt("pontos"),
					                        rs.getInt("gols"),
					                        rs.getInt("gols_sofridos")));
  }
  
  

  public List<Jogadores> lista_para_gerenciamento(){
	  
	  return jdbcTemplate.query("select * from jogadores",
			  (rs, rowNum) -> new Jogadores(rs.getLong("id"),
					                        rs.getString("imagen"),
					                        rs.getString("nome"),
					                        rs.getString("posicao"),
					                        rs.getInt("jogos"),
					                        rs.getInt("vitorias"),
					                        rs.getInt("derrotas"),
					                        rs.getInt("empates"),
					                        rs.getInt("expulsao"),
					                        rs.getInt("pontos"),
					                        rs.getInt("gols"),
					                        rs.getInt("gols_sofridos")));
  }
  
  
  
  
  
	
	//busca ordenada de  goleiro tipo 1
  public List<Jogadores> findAll() {

      var sql = "select * from jogadores WHERE posicao = \"goleiro\" ORDER BY gols_sofridos DESC";

      return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Jogadores.class));
  }
  
  
  
  @SuppressWarnings("deprecation")
public Jogadores findJogadoresByName(String nome) {

      var sql = "select * from jogadores WHERE name = ?";
      Object[] param = new Object[] {nome};

      return jdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Jogadores.class));
  }

	
}
