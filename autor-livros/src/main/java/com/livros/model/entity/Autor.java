package com.livros.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "autor")
public class Autor implements Comparable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonIgnore
	private List<Livro> livros = new ArrayList<Livro>();

	public Autor() {

	}

	public Autor(String codigo, String nome) {

		this.codigo = codigo;
		this.nome = nome;

	}

	public Autor(long id, String codigo, String nome) {

		this.id = id;
		this.codigo = codigo;
		this.nome = nome;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int compareTo(Object o) {

		Autor obj = (Autor) o;

		if (this.getId() > obj.getId()) {
			return 1;
		}

		if (this.getId() == obj.getId()) {
			return 0;
		}

		return -1;
	}

}