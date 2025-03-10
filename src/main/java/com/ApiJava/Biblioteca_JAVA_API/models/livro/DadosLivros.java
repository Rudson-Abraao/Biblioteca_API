package com.ApiJava.Biblioteca_JAVA_API.dto.Livro;

import com.ApiJava.Biblioteca_JAVA_API.model.Genero;
import com.ApiJava.Biblioteca_JAVA_API.model.Livro;

public record DadosLivros(
        Long id,
        String titulo,
        String autor,
        Genero genero,
        String sinopse,
        Boolean alugado
) {
    public DadosLivros(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(),livro.getGenero(),livro.getSinopse(),livro.getAlugado());
    }
}
