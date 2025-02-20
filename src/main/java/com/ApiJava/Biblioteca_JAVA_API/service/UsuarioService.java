package com.ApiJava.Biblioteca_JAVA_API.service;

import com.ApiJava.Biblioteca_JAVA_API.dto.Usuario.DadosUsuarioCadastro;
import com.ApiJava.Biblioteca_JAVA_API.model.Usuario;
import com.ApiJava.Biblioteca_JAVA_API.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;



    public void cadastrarUsuario(DadosUsuarioCadastro dados) {
        var usuarioParaCadastro = new Usuario(dados.nome(),dados.email());

        repository.save(usuarioParaCadastro);
    }
}
