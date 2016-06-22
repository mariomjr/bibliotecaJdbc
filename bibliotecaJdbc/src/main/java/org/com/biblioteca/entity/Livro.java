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
	
	private Calendar dataInclusao;
	
	private Double valor;
	

	public Livro() {
		super();
	}

	public Livro(String nome, String descricao, Integer ano, Calendar dataInclusao, Double valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.ano = ano;
		this.dataInclusao = dataInclusao;
		this.valor = valor;
	}
	

	public Livro(Long id, String nome, String descricao, Integer ano, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ano = ano;
		this.valor = valor;
	}

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

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
