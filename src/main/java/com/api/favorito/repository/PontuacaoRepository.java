package com.api.favorito.repository;

import com.api.favorito.model.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {

    List<Pontuacao> findByIdUsuario(long idUsuario);
}
