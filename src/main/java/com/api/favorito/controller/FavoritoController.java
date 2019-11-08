package com.api.favorito.controller;

import com.api.favorito.model.Favorito;
import com.api.favorito.services.FavoritoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Api(value = "API de favoritos")
public class FavoritoController {

    @Autowired
    FavoritoService favoritoService;

    @GetMapping(value = "/")
    public String home(){
        return "pagina inicial";
    }

    @GetMapping(value = "/favorito")
    @ApiOperation(value = "retorna uma lista de favoritos")
    public ResponseEntity<?> listarFavoritos(){
        return favoritoService.listar();
    }

    @GetMapping(value = "/favorito/usuario/{id}")
    @ApiOperation(value = "retorna uma lista com os favoritos de um aluno")
    public ResponseEntity<?> listarFavoritosIdUsuario(@PathVariable("id") long id){
        return favoritoService.listarIdUsuario(id);
    }

    @GetMapping(value = "/favorito/{id}")
    @ApiOperation(value = "retorna um favorito pelo id")
    public ResponseEntity<?> listaFavoritoId(@PathVariable("id") long id){
        return favoritoService.listarId(id);
    }

    @PostMapping(value = "/favorito/")
    @ApiOperation(value = "Salva um favorito")
    public ResponseEntity<?> salvarFavorito(@RequestParam("file") long idDocumento, @RequestParam("usuario") long idAluno, @RequestParam("donoArquivo") long donoArquivo){
        return favoritoService.salvar(idDocumento, idAluno, donoArquivo);
    }

    @DeleteMapping(value = "/favorito/{id}")
    @ApiOperation(value = "Deleta um favorito")
    public ResponseEntity<?> deletarFavorito(@PathVariable("id") long id){
        return favoritoService.deletarId(id);
    }

    @DeleteMapping("/favorito/deletar/{id}")
    @ApiOperation(value = "Deleta os favoritos baseados em um id de documento")
    public ResponseEntity<?> deletarFavoritosId(@PathVariable("id") long id){
        return favoritoService.deletar(id);
    }

    @PutMapping(value = "/favorito")
    @ApiOperation(value = "Atualiza um favorito")
    public ResponseEntity<?> atualizarFavorito(@RequestBody Favorito favorito){
        return favoritoService.atualizar(favorito);
    }

    @GetMapping("/favorito/listar/{id}")
    public ResponseEntity<?> favoritosDonoDocumento(@PathVariable("id") long idDonoDocumento){
        return favoritoService.favoritosDonoArquivo(idDonoDocumento);
    }

}
