package com.ApiJava.Biblioteca_JAVA_API.models.desejo;

import com.ApiJava.Biblioteca_JAVA_API.models.livro.Livro;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.Usuario;

public record DadosDesejo(
        Usuario usuario,
        Livro livro

) {
}
