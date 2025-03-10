package com.ApiJava.Biblioteca_JAVA_API.models.desejo;


import com.ApiJava.Biblioteca_JAVA_API.models.livro.Livro;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "desejos")
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
