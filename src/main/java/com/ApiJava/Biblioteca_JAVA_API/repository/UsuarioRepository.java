package com.ApiJava.Biblioteca_JAVA_API.repository;

import com.ApiJava.Biblioteca_JAVA_API.model.Livro;
import com.ApiJava.Biblioteca_JAVA_API.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select * from usuarios where usuarios.email = :email", nativeQuery = true)
    Optional<Usuario> buscaUsuario(@Param("email") String emailUsuario);

}
