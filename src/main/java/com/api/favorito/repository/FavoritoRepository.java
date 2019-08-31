package com.api.favorito.repository;

import com.api.favorito.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    Favorito findById(long id);

    List<Favorito> findAllById(long id);
}
