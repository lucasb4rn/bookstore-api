package com.lucas.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.repositoies.CategoriaRepository;
import com.lucas.bookstore.repositoies.LivroRepository;

@AutoConfiguration
@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Livro livro1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(livro1));

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(livro1));

	}

}
