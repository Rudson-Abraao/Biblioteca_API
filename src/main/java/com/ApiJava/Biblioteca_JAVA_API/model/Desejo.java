package com.ApiJava.Biblioteca_JAVA_API.model;


import com.ApiJava.Biblioteca_JAVA_API.repository.UsuarioRepository;
import jakarta.persistence.*;

@Entity
@Table(name = "lista_de_desejos")
public class Desejo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Livro livro;
    @ManyToOne
    private Usuario usuario;

    public Desejo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public Desejo() {
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
}
