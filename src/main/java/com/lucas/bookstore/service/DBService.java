package com.lucas.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.domain.RoleModel;
import com.lucas.bookstore.domain.UserModel;
import com.lucas.bookstore.enums.RoleName;
import com.lucas.bookstore.repositoies.CategoriaRepository;
import com.lucas.bookstore.repositoies.LivroRepository;
import com.lucas.bookstore.repositoies.RoleRepository;
import com.lucas.bookstore.repositoies.UserRepository;

@Service
public class DBService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	public void instaciaBaseDeDados() {

		RoleModel roleAdmin = new RoleModel(RoleName.ROLE_ADMIN);
		RoleModel roleUser = new RoleModel(RoleName.ROLE_USER);
		
		this.roleRepository.saveAll(Arrays.asList(roleAdmin, roleUser));
		
		UserModel user = new UserModel("maria", new BCryptPasswordEncoder().encode("maria123"), Arrays.asList(roleAdmin));
		UserModel user1 = new UserModel("joao", new BCryptPasswordEncoder().encode("joao123"), Arrays.asList(roleUser));

		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Briografia");

		Livro livro1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro livro2 = new Livro(null, "Engenharia de Software", "Louis", "Lorem ipsum", cat2);
		Livro livro3 = new Livro(null, "The Time Machine", "H.G", "Lorem ipsum", cat2);
		Livro livro4 = new Livro(null, "The war of the worlds", "H.G wells", "Lorem ipsum", cat2);
		Livro livro5 = new Livro(null, "I, Robot", "H.G Wells", "Lorem ipsum", cat3);

		cat1.getLivros().addAll(Arrays.asList(livro1, livro2));
		cat2.getLivros().addAll(Arrays.asList(livro3, livro4, livro5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
		this.userRepository.saveAll(Arrays.asList(user, user1));
		

	}

}
