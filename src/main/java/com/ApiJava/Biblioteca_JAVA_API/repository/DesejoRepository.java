package com.ApiJava.Biblioteca_JAVA_API.repository;

import com.ApiJava.Biblioteca_JAVA_API.models.desejo.DadosDesejo;
import com.ApiJava.Biblioteca_JAVA_API.models.desejo.Desejo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DesejoRepository extends JpaRepository<Desejo, Long> {
    @Query(value = "select * from lista_de_desejos where livro_id = :livroId",nativeQuery = true)
    List<Desejo> livroDesejado(@Param("livroId") Long id);

    @Query(value = "select * from desejos where usuario_id = :idUsuario", nativeQuery = true)
    Page<Desejo> desejosDoUsuario(@Param("idUsuario") Long idUsuario, Pageable paginacao);

    @Query(value = "select * from desejos where livro_id= :idLivro and usuario_id = :idUsuario", nativeQuery = true)
    Optional<Desejo> verificaDesejo(@Param("idLivro") Long idLivro,@Param("idUsuario") Long idUsuario);
}
