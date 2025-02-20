package com.ApiJava.Biblioteca_JAVA_API.service;

import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosLivroAlugado;
import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosLivroDevolucao;
import com.ApiJava.Biblioteca_JAVA_API.repository.AlugadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlugadoService {

    @Autowired
    AlugadoRepository alugadoRepository;

    public Page listarLivrosAlugados(Pageable paginacao) {
        return alugadoRepository.findAll(paginacao).map(livroAlugado -> new DadosLivroAlugado(livroAlugado));
    }

    public void devolucaoLivro(Long id) {
        var livroAlugado = alugadoRepository.findById(id);
        if (livroAlugado.isPresent()) {
            var livroEncontrado = livroAlugado.get();
            livroEncontrado.getLivro().setAlugado(false);
            alugadoRepository.delete(livroEncontrado);
        }

    }
}
