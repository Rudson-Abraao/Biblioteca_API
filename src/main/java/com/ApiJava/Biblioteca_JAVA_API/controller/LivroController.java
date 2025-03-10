package com.ApiJava.Biblioteca_JAVA_API.controller;

import com.ApiJava.Biblioteca_JAVA_API.models.livro.DadosCadastroLivro;
import com.ApiJava.Biblioteca_JAVA_API.models.livro.DadosLivros;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.DadosUsuarioEmail;
import com.ApiJava.Biblioteca_JAVA_API.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    LivroService service;

    @PostMapping
    public ResponseEntity cadastrarLivros(@RequestBody @Valid List<DadosCadastroLivro> dados){
        service.cadastrarLivro(dados);
        return ResponseEntity.ok(dados);
    }



    @GetMapping
    public  ResponseEntity<Page<DadosLivros>> listarLivros(@PageableDefault(size = 5,sort = {"titulo"}) Pageable paginacao){
        var page = service.pegarTodosLivros(paginacao);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhesLivro(@PathVariable Long id){
        var dados = service.detalhesLivro(id);

        return ResponseEntity.ok(dados);
    }

    @PostMapping("/alugar/{id}")
    @Transactional
    public ResponseEntity alugarLivro(@PathVariable Long id, @RequestBody DadosUsuarioEmail dadosUsuario){
        service.alugarLivro(id,dadosUsuario);

        return ResponseEntity.noContent().build();
    }




}
