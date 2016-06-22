package org.com.biblioteca.entity;

import java.io.Serializable;
import java.util.Calendar;

public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1672433772597374559L;

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Integer ano;
	
	private Calendar dataInsercao;
	
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Calendar getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Calendar dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
