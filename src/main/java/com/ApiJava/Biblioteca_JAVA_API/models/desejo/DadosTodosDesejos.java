package com.ApiJava.Biblioteca_JAVA_API.models.desejo;

import com.ApiJava.Biblioteca_JAVA_API.models.livro.Livro;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.Usuario;

public record DadosTodosDesejos(
        Long id,
        Long idLivro,
        String tituloLivro,
        Long idUsuario,
        String nomeUsuario,
        String emailUsuario

) {
    public DadosTodosDesejos(Desejo desejo) {
        this(
                desejo.getId(),
                desejo.getLivro().getId(),
                desejo.getLivro().getTitulo(),
                desejo.getUsuario().getId(),
                desejo.getUsuario().getNome(),
                desejo.getUsuario().getEmail()
        );
    }
}
