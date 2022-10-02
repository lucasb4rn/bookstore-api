package com.lucas.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.repositoies.CategoriaRepository;
import com.lucas.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public <Optional>Categoria findById(Integer id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
