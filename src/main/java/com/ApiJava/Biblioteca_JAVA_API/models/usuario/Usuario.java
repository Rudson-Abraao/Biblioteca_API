package com.ApiJava.Biblioteca_JAVA_API.models.usuario;

import com.ApiJava.Biblioteca_JAVA_API.models.desejo.Desejo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate validade;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Desejo> desejos;

    public Usuario() {
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.validade = LocalDate.now().plusYears(1);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Desejo> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Desejo> desejos) {
        this.desejos = desejos;
    }
}
