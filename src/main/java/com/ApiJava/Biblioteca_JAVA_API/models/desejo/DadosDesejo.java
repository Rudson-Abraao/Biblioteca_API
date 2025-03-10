package com.ApiJava.Biblioteca_JAVA_API.dto.Desejo;

import com.ApiJava.Biblioteca_JAVA_API.model.Livro;
import com.ApiJava.Biblioteca_JAVA_API.model.Usuario;

public record DadosDesejo(
        Usuario usuario,
        Livro livro

) {
}
