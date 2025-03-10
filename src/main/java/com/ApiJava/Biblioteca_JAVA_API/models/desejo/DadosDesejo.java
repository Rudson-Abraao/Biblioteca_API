package com.ApiJava.Biblioteca_JAVA_API.models.desejo;

import com.ApiJava.Biblioteca_JAVA_API.models.livro.Livro;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.Usuario;

public record DadosDesejo(
        Long idDesejo,
        Long idLivro,
        String tituloLivro

) {
}
