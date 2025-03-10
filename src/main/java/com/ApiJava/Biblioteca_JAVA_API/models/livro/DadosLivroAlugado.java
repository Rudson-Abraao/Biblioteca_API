package com.ApiJava.Biblioteca_JAVA_API.models.livro;

import com.ApiJava.Biblioteca_JAVA_API.models.alugado.Alugado;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.Usuario;

import java.time.LocalDate;

public record DadosLivroAlugado(
        Long id,
        Livro livro,
        Usuario usuario,
        LocalDate dataDoAluguel,
        LocalDate dataDaDevolucao
) {
    public DadosLivroAlugado(Alugado livroAlugado) {
        this(livroAlugado.getId(), livroAlugado.getLivro(),livroAlugado.getUsuario(),livroAlugado.getDataDoAluguel(),livroAlugado.getDataDaDevolucao());
    }
}
