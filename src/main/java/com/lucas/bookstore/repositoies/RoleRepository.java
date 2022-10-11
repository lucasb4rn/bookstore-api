package com.lucas.bookstore.repositoies;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.bookstore.domain.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {

}
