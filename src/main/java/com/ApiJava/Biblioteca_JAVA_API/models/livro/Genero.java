package com.ApiJava.Biblioteca_JAVA_API.models.livro;

public enum Genero {
    FICCAO_CIENTIFICA("Ficção Científica"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    FANTASIA("Fantasia"),
    SUSPENSE("Suspense"),
    DRAMA("Drama"),
    AVENTURA("Aventura"),
    NOVELA("Novela"),
    MISTERIO("Mistério"),
    DISTOPIA("Distopia"),
    CONTOS("Contos");


    private String generoTexto;

    Genero(String genero) {
        this.generoTexto = genero;
    }

    public static Genero fromString(String text){
        for (Genero genero : Genero.values()) {
            if (genero.generoTexto.equalsIgnoreCase(text)) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Nenhum genero encontrado para a string fornecida: " + text);
    }
}
