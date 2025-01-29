package com.livros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livros.model.entity.Autor;
import com.livros.repository.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;

	public void gravarNotaFical(Autor autor) throws Exception {

		try {

			Autor nf = new Autor(autor.getCodigo(), autor.getNome());

			livrosRepository.save(nf);

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public List<Autor> obterAutores() throws Exception {

		try {

			return livrosRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public Autor obterLivrosByAutorCode(String autorCode) throws Exception {

		try {

			Autor autor = livrosRepository.findByCodigo(autorCode);

			return autor;

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

}
