package com.livros.simulated.dashboard.form;

import java.util.ArrayList;
import java.util.List;

import com.livros.model.entity.Autor;
import com.livros.model.entity.Livro;

public class LivrosForm {

	private List<Livro> livros = new ArrayList<Livro>();

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
