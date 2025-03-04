package com.ApiJava.Biblioteca_JAVA_API.service;

import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosLivroAlugado;
import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosLivroDevolucao;
import com.ApiJava.Biblioteca_JAVA_API.repository.AlugadoRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.DesejoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlugadoService {

    @Autowired
    AlugadoRepository alugadoRepository;

    @Autowired
    DesejoRepository desejoRepository;

    @Autowired
    EmailService emailService;

    public Page listarLivrosAlugados(Pageable paginacao) {
        return alugadoRepository.findAll(paginacao).map(livroAlugado -> new DadosLivroAlugado(livroAlugado));
    }

//    public void devolucaoLivro(Long id) {
//        var livroAlugado = alugadoRepository.findById(id);
//
//        if (livroAlugado.isPresent()) {
//            var livroEncontrado = livroAlugado.get();
//            livroEncontrado.getLivro().setAlugado(false);
//            alugadoRepository.delete(livroEncontrado);
//
//            var livroDesejado = desejoRepository.livroDesejado(livroEncontrado.getLivro().getId());
//            livroDesejado.stream().forEach(desejo -> emailService.enviarEmail(desejo.getUsuario().getEmail(),"Livro disponivel!","Olá, " + desejo.getUsuario().getNome() + ", o livro " + desejo.getLivro().getTitulo() + " está disponivel para aluguel."));
//
//
//
//        }
//
//
//    }
}
