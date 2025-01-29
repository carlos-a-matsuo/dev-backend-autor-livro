package com.livros.simulated.dashboard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.livros.model.entity.Livro;
import com.livros.model.entity.Autor;

public class SimulationHelper {

	private Integer index;

	private List<Autor> autores = new ArrayList<Autor>();

	public SimulationHelper() {

		index = 0;

		Autor autor = null;

		autor = new Autor(1, "123", "Alberto");
		autor.getLivros().add(new Livro(autor, "t1", "d1", "c1"));
		autor.getLivros().add(new Livro(autor, "t2", "d2", "c2"));
		autores.add(autor);

		autor = new Autor(2, "456", "Eduardo");
		autor.getLivros().add(new Livro(autor, "t3", "d3", "c3"));
		autor.getLivros().add(new Livro(autor, "t4", "d4", "c4"));
		autores.add(autor);

		autor = new Autor(3, "789", "Flavia");
		autor.getLivros().add(new Livro(autor, "t5", "d5", "c5"));
		autor.getLivros().add(new Livro(autor, "t6", "d6", "c6"));
		autores.add(autor);

		Collections.sort(autores);

	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setNotas(List<Autor> autores) {
		this.autores = autores;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void incrementIndex() {
		index = index + 1;
	}
}
