package com.livros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.model.entity.Autor;



public interface LivrosRepository extends JpaRepository<Autor, Long> {
  
	Autor findByCodigo(String codigo);
	  
}
