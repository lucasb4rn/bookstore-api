package com.lucas.bookstore.dtos;

import com.lucas.bookstore.domain.Livro;

public class LivroDTO {

	private Integer id;
	private String titulo;

	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public LivroDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
