package com.ApiJava.Biblioteca_JAVA_API.models.livro;

import jakarta.validation.constraints.NotNull;

public record DadosLivroDevolucao(
        @NotNull
        Long id
) {
}
