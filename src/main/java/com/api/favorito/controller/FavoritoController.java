package com.api.favorito.controller;

import com.api.favorito.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FavoritoController {

    @Autowired
    FavoritoRepository favoritoRepository;

    @GetMapping(value = "/")
    public String home(){
        return "pagina inicial";
    }

}
