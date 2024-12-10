package com.thiago.barroso.vendasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.barroso.vendasapi.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
