package com.api.favorito.controller;

import com.api.favorito.model.Favorito;
import com.api.favorito.repository.FavoritoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API de favoritos")
public class FavoritoController {

    @Autowired
    FavoritoRepository favoritoRepository;

    @GetMapping(value = "/")
    public String home(){
        return "pagina inicial";
    }

    @GetMapping(value = "/favorito/listar")
    @ApiOperation(value = "retorna uma lista de favoritos")
    public ResponseEntity<List<Favorito>> listarFavoritos(){
        List<Favorito> favoritos = favoritoRepository.findAll();
        return new ResponseEntity<List<Favorito>>(favoritos, HttpStatus.OK);
    }

    @GetMapping(value = "/favorito/listarUsuario/{id}")
    @ApiOperation(value = "retorna uma lista com os favoritos de um aluno")
    public ResponseEntity<List<Favorito>> listarFavoritosIdUsuario(@PathVariable("id") long id){
        List<Favorito> favoritos = favoritoRepository.findAllById(id);
        return ResponseEntity<List<Favorito>>("Lista de alunos", HttpStatus.OK);
    }

    @GetMapping(value = "/favorito/listar/{id}")
    @ApiOperation(value = "retorna um favorito pelo id")
    public ResponseEntity<Favorito> listaFavoritoId(@PathVariable("id") long id){
        Favorito favorito = favoritoRepository.findById(id);
        return  new ResponseEntity<Favorito>(favorito, HttpStatus.OK);
    }

    @PostMapping(value = "/favorito/salvar")
    @ApiOperation(value = "Salva um favorito")
    public ResponseEntity<String> salvarFavorito(@RequestBody Favorito favorito){
        favoritoRepository.save(favorito);
        return new ResponseEntity<>("Favorito salvo com sucesso", HttpStatus.OK);

    }

    @DeleteMapping(value = "/favorito/deletar/{id}")
    @ApiOperation(value = "Deleta um favorito")
    public ResponseEntity<String> deletarFavorito(@PathVariable("id") long id){
        favoritoRepository.deleteById(id);
        return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    }

    @PutMapping(value = "/favorito/atualizar")
    @ApiOperation(value = "Atualiza um favorito")
    public ResponseEntity<String> atualizarFavorito(@RequestBody Favorito favorito){
        favoritoRepository.save(favorito);
        return new ResponseEntity<String>("Atualizado com sucesso", HttpStatus.OK);
    }

}
