package com.api.favorito.controller;

import com.api.favorito.services.PontuacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "API de pontuacao")
public class PontuacaoController {

    @Autowired
    PontuacaoService pontuacaoService;

    @GetMapping("/pontuacao/{id}")
    @ApiOperation(value = "retorna a pontuacao de um usuario")
    public ResponseEntity<?> pontosUsuario(@PathVariable("id") long idUsuario){
        return pontuacaoService.pontosUsuario(idUsuario);
    }
    @PostMapping("/pontuacao")
    @ApiOperation(value = "adiciona pontuacao")
    public ResponseEntity<?> adicionarPontos(@RequestParam("usuario") long usuario, @RequestParam("pontos") long pontos){
        return pontuacaoService.adicionarPontos(usuario, pontos);
    }


}
