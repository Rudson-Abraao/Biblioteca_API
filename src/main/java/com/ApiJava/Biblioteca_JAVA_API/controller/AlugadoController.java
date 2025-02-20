package com.ApiJava.Biblioteca_JAVA_API.controller;


import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosLivroDevolucao;
import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosLivros;
import com.ApiJava.Biblioteca_JAVA_API.repository.AlugadoRepository;
import com.ApiJava.Biblioteca_JAVA_API.service.AlugadoService;
import com.ApiJava.Biblioteca_JAVA_API.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alugados")
public class AlugadoController {

    @Autowired
    AlugadoService service;

    @Autowired
    AlugadoRepository alugadoRepository;

    @Autowired
    EmailService emailService;

    @GetMapping
    public ResponseEntity<Page<DadosLivros>>  livrosAlugados(Pageable paginacao){
        var page = service.listarLivrosAlugados(paginacao);

        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity devolveLivro(@RequestBody DadosLivroDevolucao dadosLivroDevolucao ){
        service.devolucaoLivro(dadosLivroDevolucao.id());

        return ResponseEntity.noContent().build();
    }





}
