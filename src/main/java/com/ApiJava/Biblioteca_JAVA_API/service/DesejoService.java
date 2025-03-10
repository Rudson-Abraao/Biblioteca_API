package com.ApiJava.Biblioteca_JAVA_API.service;


import com.ApiJava.Biblioteca_JAVA_API.models.desejo.DadosDesejo;
import com.ApiJava.Biblioteca_JAVA_API.models.desejo.DadosTodosDesejos;
import com.ApiJava.Biblioteca_JAVA_API.models.desejo.Desejo;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.Usuario;
import com.ApiJava.Biblioteca_JAVA_API.repository.DesejoRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.LivroRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesejoService {
    @Autowired
    DesejoRepository desejoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LivroRepository livroRepository;

//    public Page<DadosDesejo> listarDesejos(Pageable paginacao) {
//        return desejoRepository.findAll(paginacao).map(desejo -> new DadosDesejo(desejo.getUsuario(),desejo.getLivro()));
//    }




    public void adicionarDesejo(Long idUsuario, Long idLivro) {
        var livro = livroRepository.findById(idLivro);
        var usuario = usuarioRepository.findById(idUsuario);

        if (livro.isPresent() && usuario.isPresent()){
            var livroDesejado = livro.get();
            var usuarioDesejando = usuario.get();

            Desejo desejo = new Desejo(livroDesejado,usuarioDesejando);

            var desejoJáExiste = desejoRepository.verificaDesejo(livroDesejado.getId(),usuarioDesejando.getId());
            if(desejoJáExiste.isPresent()){
                throw new RuntimeException("Esse desejo já existe");
            } else {
                usuarioDesejando.setDesejos(List.of(desejo));
            }



        }
    }

    public Page<DadosDesejo> listarDesejosUsuario(Long idUsuario, Pageable paginacao) {
        return desejoRepository.desejosDoUsuario(idUsuario,paginacao).map(d -> new DadosDesejo(d.getId(),d.getLivro().getId(),d.getLivro().getTitulo()));
    }

    public void excluirDesejo(Long id) {
        Desejo desejo = desejoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("usuario não encontrado"));

        Usuario usuario = desejo.getUsuario();
        if (usuario != null) {
            usuario.getDesejos().remove(desejo);
            usuarioRepository.save(usuario);
        }

        desejoRepository.deleteById(id);
    }

    public Page<DadosTodosDesejos> listarTodosDesejos(Pageable paginacao) {
        return desejoRepository.findAll(paginacao).map(desejo -> new DadosTodosDesejos(desejo));
    }
}
