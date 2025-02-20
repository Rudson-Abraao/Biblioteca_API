package com.ApiJava.Biblioteca_JAVA_API.repository;

import com.ApiJava.Biblioteca_JAVA_API.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivroRepository extends JpaRepository<Livro, Long> {



}
