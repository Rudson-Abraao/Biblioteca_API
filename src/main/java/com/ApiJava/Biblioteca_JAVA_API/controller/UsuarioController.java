package com.ApiJava.Biblioteca_JAVA_API.controller;


import com.ApiJava.Biblioteca_JAVA_API.dto.Usuario.DadosUsuarioCadastro;
import com.ApiJava.Biblioteca_JAVA_API.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody DadosUsuarioCadastro dados){
        service.cadastrarUsuario(dados);

        return ResponseEntity.noContent().build();
    }
}
