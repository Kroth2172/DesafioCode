package com.cadastro.desafio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="TB_MEMBRO")
@NoArgsConstructor
@AllArgsConstructor
public class Membro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pk_membros_projeto")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    
    @Column(name = "ds_cargo", length = 100, nullable = false)
    private String cargo;
    
    @OneToOne
    @JoinColumn(name = "fk_pessoa", referencedColumnName = "cd_pessoa", nullable = false, insertable = true)
    private Pessoa pessoa;
    
    @OneToOne
    @JoinColumn(name = "fk_projeto", referencedColumnName = "cd_projeto", nullable = false, insertable = true)
    private Projeto projeto;
}