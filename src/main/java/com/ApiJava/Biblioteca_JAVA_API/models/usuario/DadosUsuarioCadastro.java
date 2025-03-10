package com.ApiJava.Biblioteca_JAVA_API.dto.Usuario;


import jakarta.validation.constraints.NotBlank;

public record DadosUsuarioCadastro(
        @NotBlank
        String nome,
        @NotBlank
        String email) {

}
