package com.ApiJava.Biblioteca_JAVA_API.repository;

import com.ApiJava.Biblioteca_JAVA_API.model.Alugado;
import com.ApiJava.Biblioteca_JAVA_API.model.Desejo;
import com.ApiJava.Biblioteca_JAVA_API.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DesejoRepository extends JpaRepository<Desejo, Long> {
    @Query(value = "select * from lista_de_desejos where livro_id = :livroId",nativeQuery = true)
    List<Desejo> livroDesejado(@Param("livroId") Long id);
}
