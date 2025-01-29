package com.livros;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.livros.model.entity.Autor;
import com.livros.repository.LivrosRepository;
import com.livros.simulated.dashboard.service.SimulationHelper;

@SpringBootApplication
public class LivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LivrosRepository livrosRepository) {
		return (args) -> {

			SimulationHelper sim = new SimulationHelper();

			List<Autor> autores = sim.getAutores();

			for (Autor nf : autores) {
				livrosRepository.save(nf);
			}

		};
	}

}
