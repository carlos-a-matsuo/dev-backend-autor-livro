package com.livros.simulated.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.livros.model.entity.Autor;
import com.livros.service.LivrosService;
import com.livros.simulated.dashboard.form.AutorCodeForm;
import com.livros.simulated.dashboard.form.AutorForm;
import com.livros.simulated.dashboard.form.LivrosForm;
import com.livros.simulated.dashboard.form.TestForm;

import reactor.core.publisher.Flux;

import com.livros.model.entity.Livro;

@Service
public class ReactiveLivrosService {

	private TestForm testForm;

	private SimulationHelper simulation = new SimulationHelper();

	@Autowired
	private LivrosService livrosService;

	public Flux<AutorForm> autores() {

		try {

			List<Autor> autores = livrosService.obterAutores();

			for (Autor nf : autores) {
				nf.setLivros(new ArrayList<Livro>());
			}

			AutorForm aut = new AutorForm();

			if (testForm != null) {
				aut.getAutorCodes().add(new AutorCodeForm(testForm.getAutorCode()));
			}

			aut.setAutores(autores);

			List<AutorForm> list = new ArrayList<AutorForm>();
			list.add(aut);

			return Flux.fromIterable(list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		AutorForm autorForm = new AutorForm();
		List<AutorForm> list = new ArrayList<AutorForm>();
		list.add(autorForm);
		return Flux.fromIterable(list);

	}

	public Flux<LivrosForm> livros(String autorCode) {

		try {

			if (autorCode != null) {

				Autor autor = livrosService.obterLivrosByAutorCode(autorCode);

				if (autor != null) {

					List<LivrosForm> list = new ArrayList<LivrosForm>();
					
					LivrosForm form = new LivrosForm();
					form.setLivros(autor.getLivros());
					
					list.add(form);

					return Flux.fromIterable(list);
				}

			}

		} catch (Exception e) {
			// erro
			e.printStackTrace();
		}

		LivrosForm form = new LivrosForm();
		List<LivrosForm> list = new ArrayList<LivrosForm>();
		list.add(form);
		return Flux.fromIterable(list);
	}

	public TestForm getTestForm() {
		return testForm;
	}

	public void setTestForm(TestForm testForm) {
		this.testForm = testForm;
	}

	public void erpEnviarBoleto() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		Autor nfErp = null;

		for (Autor nf : simulation.getAutores()) {

		}

		if (nfErp != null) {

			HttpEntity<Autor> request = new HttpEntity<>(nfErp);
			restTemplate.postForObject("http://localhost:8080/hook_notafiscal", request, Autor.class);

		} else {
			throw new Exception("Não Há Nota Fiscal");
		}

	}

}
