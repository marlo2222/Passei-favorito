package com.api.favorito.repository;

import com.api.favorito.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {


    Favorito findById(long id);

    @Query("SELECT f FROM Favorito f WHERE f.idAluno = :idPassado")
    List<Favorito> findAllById(@Param("idPassado") long id);

    int countByIdDonoDocumento(long idDonoDocumento);

    List<Favorito> findAllByIdDocumento(long idDocumento);


}
