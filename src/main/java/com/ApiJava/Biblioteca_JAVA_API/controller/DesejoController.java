package com.ApiJava.Biblioteca_JAVA_API.controller;


import com.ApiJava.Biblioteca_JAVA_API.dto.Desejo.DadosDesejo;
import com.ApiJava.Biblioteca_JAVA_API.service.DesejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("desejos")
public class DesejoController {

    @Autowired
    DesejoService desejoService;

//    @GetMapping
//    public ResponseEntity<Page<DadosLivros>> listarDesejos(){
//        desejoService.listarDesejos();
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping
//    public  ResponseEntity<Page<DadosDesejo>> listarDesejos ( Pageable paginacao){
//        var page = desejoService.listarDesejos(paginacao);
//
//        return ResponseEntity.ok(page);
//    }

    @GetMapping
    public ResponseEntity<Page<DadosDesejo>> listarDesejos (Pageable paginacao) {
        var page = desejoService.listarDesejos(paginacao);
        return ResponseEntity.ok(page);
    }
}
