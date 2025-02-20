package com.ApiJava.Biblioteca_JAVA_API.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administradores")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
}
