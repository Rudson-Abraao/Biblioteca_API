package com.ApiJava.Biblioteca_JAVA_API.dto.Livro;

import jakarta.validation.constraints.NotNull;

public record DadosLivroDevolucao(
        @NotNull
        Long id
) {
}
