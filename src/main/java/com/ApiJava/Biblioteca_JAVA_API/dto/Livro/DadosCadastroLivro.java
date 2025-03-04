package com.ApiJava.Biblioteca_JAVA_API.dto.Livro;

import com.ApiJava.Biblioteca_JAVA_API.model.Genero;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.cactoos.scalar.Not;

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
