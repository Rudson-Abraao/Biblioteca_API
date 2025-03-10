package com.ApiJava.Biblioteca_JAVA_API.models.livro;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLivro(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        @NotBlank
        String genero,
        @NotBlank
        String sinopse
) {
}
