package com.lucas.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.repositoies.LivroRepository;
import com.lucas.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaService categoriaService;
	

	public Livro findById(Integer id) {

		Livro livro = livroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! id: " + id + ", Tipo: " + Livro.class.getName()));
		return livro;
	}

	public List<Livro> findAll() {
		return livroRepository.findAll();
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

}
