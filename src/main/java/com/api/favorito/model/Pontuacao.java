package com.api.favorito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pontuacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "idUsuario")
    private long idUsuario;

    @Column(name = "pontos")
    private long pontos;

    public Pontuacao(long usuario, long pontos){
        this.idUsuario = usuario;
        this.pontos = pontos;
    }
}
