package com.ApiJava.Biblioteca_JAVA_API.service;


import com.ApiJava.Biblioteca_JAVA_API.dto.Desejo.DadosDesejo;
import com.ApiJava.Biblioteca_JAVA_API.repository.DesejoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesejoService {
    @Autowired
    DesejoRepository desejoRepository;

    public Page<DadosDesejo> listarDesejos(Pageable paginacao) {
        return desejoRepository.findAll(paginacao).map(desejo -> new DadosDesejo(desejo.getUsuario(),desejo.getLivro()));
    }


//    public Page<DadosDesejo> listarDesejos(Pageable paginacao) {
////        List<DadosDesejo> desejos = desejoRepository.findAll(paginacao).map(desejo -> new DadosDesejo(desejo.getUsuario(),desejo.getLivro())).toList();
////        System.out.println(desejos);
//        return desejoRepository.findAll(paginacao).map
//    }
}
