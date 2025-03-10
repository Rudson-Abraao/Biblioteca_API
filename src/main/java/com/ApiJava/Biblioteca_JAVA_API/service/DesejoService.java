package com.ApiJava.Biblioteca_JAVA_API.service;


import com.ApiJava.Biblioteca_JAVA_API.models.desejo.DadosDesejo;
import com.ApiJava.Biblioteca_JAVA_API.models.desejo.Desejo;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.DadosUsuarioEmail;
import com.ApiJava.Biblioteca_JAVA_API.repository.DesejoRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.LivroRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DesejoService {
    @Autowired
    DesejoRepository desejoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LivroRepository livroRepository;

    public Page<DadosDesejo> listarDesejos(Pageable paginacao) {
        return desejoRepository.findAll(paginacao).map(desejo -> new DadosDesejo(desejo.getUsuario(),desejo.getLivro()));
    }




    public void adicionarDesejo(Long idUsuario, Long idLivro) {
        var livro = livroRepository.findById(idLivro);
        var usuario = usuarioRepository.findById(idUsuario);

        if (livro.isPresent() && usuario.isPresent()){
            var livroDesejado = livro.get();
            var usuarioDesejando = usuario.get();

            Desejo desejo = new Desejo(livroDesejado,usuarioDesejando);
            usuarioDesejando.setDesejos(List.of(desejo));


        }
    }
}
