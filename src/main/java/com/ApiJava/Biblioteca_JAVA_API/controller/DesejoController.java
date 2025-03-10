package com.ApiJava.Biblioteca_JAVA_API.controller;


import com.ApiJava.Biblioteca_JAVA_API.models.desejo.DadosDesejo;
import com.ApiJava.Biblioteca_JAVA_API.models.desejo.DadosTodosDesejos;
import com.ApiJava.Biblioteca_JAVA_API.service.DesejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desejos")
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

    // ADMIN
    @GetMapping
    public ResponseEntity<Page<DadosTodosDesejos>> listarDesejos (Pageable paginacao) {
        var page = desejoService.listarTodosDesejos(paginacao);
        return ResponseEntity.ok(page);
    }


    // USUARIO
    @PostMapping("/{idUsuario}/{idLivro}/desejo")
    @Transactional
    public ResponseEntity adicionarDesejo(@PathVariable Long idUsuario,@PathVariable Long idLivro){
        desejoService.adicionarDesejo(idUsuario, idLivro);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{idUsuario}")
    public ResponseEntity<Page<DadosDesejo>> listarLivrosDesejados(@PathVariable Long idUsuario, Pageable paginacao) {
        var page =  desejoService.listarDesejosUsuario(idUsuario,paginacao);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{idDesejo}")
    @Transactional
    public ResponseEntity excluirDesejo (@PathVariable Long idDesejo) {
        desejoService.excluirDesejo(idDesejo);

        return ResponseEntity.noContent().build();
    }
}
