package com.api.favorito.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="favorito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorito_id")
    private long id;

    @Column(name = "id_aluno", nullable = false)
    private long idAluno;

    @Column(name = "id_doc", nullable = false)
    private long idDocumento;
}
