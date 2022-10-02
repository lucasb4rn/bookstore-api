package com.lucas.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.repositoies.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		return categoriaRepository.findById(id).orElse(null);
	}

}
