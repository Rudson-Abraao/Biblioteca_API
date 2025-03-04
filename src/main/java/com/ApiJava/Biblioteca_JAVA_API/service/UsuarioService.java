package com.ApiJava.Biblioteca_JAVA_API.service;

import com.ApiJava.Biblioteca_JAVA_API.dto.Usuario.DadosUsuarioCadastro;
import com.ApiJava.Biblioteca_JAVA_API.model.Usuario;
import com.ApiJava.Biblioteca_JAVA_API.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;



    public void cadastrarUsuario(DadosUsuarioCadastro dados) {
        var usuarioParaCadastro = new Usuario(dados.nome(),dados.email());

        usuarioRepository.save(usuarioParaCadastro);
    }

    @Scheduled(initialDelay = 0)
    public void verificaValidadeUsuario() {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

    }
}
