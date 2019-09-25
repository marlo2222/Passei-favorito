package com.api.favorito.services;

import com.api.favorito.model.Favorito;
import com.api.favorito.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FavoritoService {

    @Autowired
    FavoritoRepository favoritoRepository;

    public ResponseEntity<?> listar(){
        return new ResponseEntity<>(favoritoRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarIdUsuario(long id){
        return new ResponseEntity<>(favoritoRepository.findAllById(id), HttpStatus.OK);
    }
    public ResponseEntity<?> listarId(long id){
        return new ResponseEntity<>(favoritoRepository.findById(id), HttpStatus.OK);
    }
    public ResponseEntity<?> salvar(Favorito favorito){
        favoritoRepository.save(favorito);
        return new ResponseEntity<>("salvo com sucesso", HttpStatus.CREATED);
    }
    public ResponseEntity<?> deletarId(long id){
        favoritoRepository.deleteById(id);
        return new ResponseEntity<>("deletado com sucesso", HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<?> atualizar(Favorito favorito){
        favoritoRepository.save(favorito);
        return new ResponseEntity<>("atualizado com sucesso", HttpStatus.OK);
    }
}