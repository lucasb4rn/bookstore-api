package com.lucas.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.dtos.CategoriaDTO;
import com.lucas.bookstore.repositoies.CategoriaRepository;
import com.lucas.bookstore.service.exception.DataIntegrityViolationException;
import com.lucas.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada! id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);

	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados!");
		}
	}

}
