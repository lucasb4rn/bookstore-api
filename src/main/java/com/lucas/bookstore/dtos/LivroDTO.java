package com.lucas.bookstore.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.lucas.bookstore.domain.Livro;

public class LivroDTO {

	private Integer id;
	@NotEmpty(message = "Campo Titulo é requerido")
	@Length(min = 3, max = 50, message = "O campo Titulo deve ter entre 3 a 50 caracteres.")
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
