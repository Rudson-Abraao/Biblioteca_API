package com.ApiJava.Biblioteca_JAVA_API.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private Boolean alugado = false;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public Boolean getAlugado() {
        return alugado;
    }

    public Livro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = Genero.fromString(genero);
    }

    public Livro() {}

    public void setAlugado(Boolean alugado) {
        this.alugado = alugado;
    }


}
