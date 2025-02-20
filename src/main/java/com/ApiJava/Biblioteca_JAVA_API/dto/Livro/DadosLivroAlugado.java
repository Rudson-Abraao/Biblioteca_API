package com.ApiJava.Biblioteca_JAVA_API.dto.Livro;

import com.ApiJava.Biblioteca_JAVA_API.model.Alugado;
import com.ApiJava.Biblioteca_JAVA_API.model.Livro;
import com.ApiJava.Biblioteca_JAVA_API.model.Usuario;

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
