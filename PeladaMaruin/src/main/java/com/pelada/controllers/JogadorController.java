package com.pelada.controllers;

import java.util.List;       

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelada.DTO.JogadorDTO;
import com.pelada.DTO.JogadorRespostaDTO;
import com.pelada.Service.JogadorService;
import com.pelada.modelo.Jogadores;
import com.pelada.repository.JogadorRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping({"/jogadores"})
public class JogadorController {
	
	   
	   
	   
private JogadorRepository repository;	   
	  


@Autowired
private  JogadorService jogadorService;	    
	    
	    
JogadorController(JogadorRepository jogadorRepository) {
    this.repository = jogadorRepository;
  }   
	    
	    
	    
	    

	    
	   
	   
	   
	   
	   
	   
	   //Um simples Teste do Controller
	   @ApiOperation(value = "Exemplo tutorial para o Swagger2. esse metodo retorna uma string.")
	   @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
			    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	  })
	   @GetMapping(value = "/hello",  produces="application/json", consumes="application/json")
	   public String hello() {
	       return "Hello Test";
	   }
	   
	   //buscar todos registros no banco (pelada) e Tabela (jogadores)
	   @GetMapping
	   public List<Jogadores> findAll(){
	      return repository.findAll();
	   }
	   
	   
	   //busca um Registro por id na Tabela (jogadores)
	   @GetMapping(path = {"/{id}"})
	   public ResponseEntity<?> findById(@PathVariable long id){
		   
	      return repository.findById(id)
	              .map(record -> ResponseEntity.ok().body(record))
	              .orElse(ResponseEntity.notFound().build());
	   }
	   
	   
       //salvar registro no banco Atravez do DTO
       @PostMapping
       public ResponseEntity<JogadorRespostaDTO> salvar(@RequestBody @Valid JogadorDTO dto) {
       Jogadores jogadores = jogadorService.salvar(dto.transformaParaObjeto());
       return new ResponseEntity<>(JogadorRespostaDTO.transformaEmDTO(jogadores), HttpStatus.CREATED);
        }
       
       
       
       //atualizar um registro da tabela(jogadores)
       @PutMapping(value="/{id}")
       public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Jogadores jogadores) {
	   
       return repository.findById(id)
           .map(record -> {
               record.setNome(jogadores.getNome());
               record.setPosicao(jogadores.getPosicao());
                  
               Jogadores updated = repository.save(record);
               return ResponseEntity.ok().body(updated);
           }).orElse(ResponseEntity.notFound().build());
        }
       
       
       //deletando registro da tabela(jogadores) 
       @DeleteMapping(path ={"/{id}"})
       public ResponseEntity<?> delete(@PathVariable long id) {
          return repository.findById(id)
              .map(record -> {
                 repository.deleteById(id);
                 return ResponseEntity.ok().build();
              }).orElse(ResponseEntity.notFound().build());
       }
   
   
   
	

}
