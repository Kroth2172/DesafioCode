package com.cadastro.desafio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_PROJETO")
@NoArgsConstructor
@AllArgsConstructor
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cd_projeto")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "ds_nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "dt_dataInicio", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;

    @Column(name = "dt_dataPrevisaoFim", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPrevisaoFim;

    @Column(name = "dt_dataFim", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFim;

    @Column(name = "ds_descricao", length = 5000, nullable = false)
    private String descricao;

    @Column(name = "ds_status", length = 45, nullable = false)
    private String status;

    @Column(name = "nr_orcamento", nullable = false)
    private float orcamento;

    @Column(name = "ds_risco", length = 45, nullable = false)
    private String risco;

    @OneToOne
    @JoinColumn(name = "fk_gerente", referencedColumnName = "cd_pessoa", nullable = false, insertable = true)
    private Pessoa gerente;

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataPrevisaoFim() {
		return dataPrevisaoFim;
	}

	public void setDataPrevisaoFim(Date dataPrevisaoFim) {
		this.dataPrevisaoFim = dataPrevisaoFim;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public Pessoa getGerente() {
		return gerente;
	}

	public void setGerente(Pessoa gerente) {
		this.gerente = gerente;
	}
   
}
