package com.ApiJava.Biblioteca_JAVA_API.repository;

import com.ApiJava.Biblioteca_JAVA_API.models.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {



}
