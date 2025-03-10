package com.ApiJava.Biblioteca_JAVA_API.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "livros_alugados")
public class Alugado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Livro livro;
    @ManyToOne
    private Usuario usuario;
    private LocalDate dataDoAluguel;
    private  LocalDate dataDaDevolucao;

    public Alugado() {
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataDoAluguel() {
        return dataDoAluguel;
    }

    public LocalDate getDataDaDevolucao() {
        return dataDaDevolucao;
    }

    public Alugado(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataDoAluguel = LocalDate.now();
        this.dataDaDevolucao = LocalDate.now().plusWeeks(1);
    }
}
