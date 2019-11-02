package com.api.favorito.services;

import com.api.favorito.model.Pontuacao;
import com.api.favorito.repository.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontuacaoService {

    @Autowired
    PontuacaoRepository pontuacaoRepository;

    public ResponseEntity<?> adicionarPontos(long usuario, long pontos){
        Pontuacao pontuacao = new Pontuacao(usuario, pontos);
        return new ResponseEntity<>(pontuacaoRepository.save(pontuacao), HttpStatus.CREATED);
    }

    public ResponseEntity<?> pontosUsuario(long usuario){
        List<Pontuacao> pontos = pontuacaoRepository.findByIdUsuario(usuario);
        if(pontos.isEmpty()){
            return new ResponseEntity<>(0, HttpStatus.NO_CONTENT);
        }else{
            long valor = 0;
            for (Pontuacao ponto : pontos){
                valor = valor + ponto.getPontos();
            }
            return new ResponseEntity<>(valor, HttpStatus.OK);
        }
    }
}
