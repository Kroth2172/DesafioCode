package com.cadastro.desafio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_PESSOA")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cd_pessoa")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
 
    @Column(name = "ds_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "dt_dataNascimento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column(name = "ds_cpf", length = 14, nullable = false)
    private String cpf;

    @Column(name = "ie_funcionario")
    private boolean funcionario;

    @Column(name = "ie_gerente")
    private boolean gerente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}
}
