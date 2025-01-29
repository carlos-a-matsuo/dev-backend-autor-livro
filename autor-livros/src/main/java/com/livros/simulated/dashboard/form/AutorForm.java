package com.livros.simulated.dashboard.form;

import java.util.ArrayList;
import java.util.List;

import com.livros.model.entity.Autor;

public class AutorForm {

	private List<AutorCodeForm> autorCodes = new ArrayList<AutorCodeForm>();

	private List<Autor> autores  = new ArrayList<Autor>();

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<AutorCodeForm> getAutorCodes() {
		return autorCodes;
	}

	public void setAutorCodes(List<AutorCodeForm> autorCodes) {
		this.autorCodes = autorCodes;
	}

}
