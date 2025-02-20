package com.ApiJava.Biblioteca_JAVA_API.service;

import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosCadastroLivro;
import com.ApiJava.Biblioteca_JAVA_API.dto.Livro.DadosLivros;
import com.ApiJava.Biblioteca_JAVA_API.dto.Usuario.DadosUsuarioEmail;
import com.ApiJava.Biblioteca_JAVA_API.model.Alugado;
import com.ApiJava.Biblioteca_JAVA_API.model.Desejo;
import com.ApiJava.Biblioteca_JAVA_API.model.Livro;
import com.ApiJava.Biblioteca_JAVA_API.repository.AlugadoRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.DesejoRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.LivroRepository;
import com.ApiJava.Biblioteca_JAVA_API.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AlugadoRepository alugadoRepository;

    @Autowired
    DesejoRepository desejoRepository;

    public Page<DadosLivros> pegarTodosLivros(Pageable paginacao) {
        return repository.findAll(paginacao).map(livro -> new DadosLivros(livro));

    }

    public void cadastrarLivro(List<DadosCadastroLivro> dados) {
        var livrosParaCadastro = dados.stream().map(l -> new Livro(l.titulo(), l.autor(), l.genero())).toList();
        repository.saveAll(livrosParaCadastro);
    }

    public DadosLivros detalhesLivro(Long id) {
        var livro = repository.findById(id);
        if (livro.isPresent()){
            var livroEncontrado = livro.get();
            return new DadosLivros(livroEncontrado);
        }
        return null;
    }

    public void alugarLivro(Long id, DadosUsuarioEmail dadosUsuario) {
        var livro = repository.findById(id);
        var usuario = usuarioRepository.buscaUsuario(dadosUsuario.emailUsuario());

        System.out.println(livro);
        System.out.println(usuario);

        if (livro.isPresent() && usuario.isPresent()){
            var livroAlugado = livro.get();
            livroAlugado.setAlugado(true);
            System.out.println(livroAlugado.getTitulo());
            var usuarioAlugando = usuario.get();

            alugadoRepository.save(new Alugado(livroAlugado,usuarioAlugando));

        }

    }

    public void listarComoDesejo(Long id, DadosUsuarioEmail dadosUsuario) {
        var livro = repository.findById(id);
        var usuario = usuarioRepository.buscaUsuario(dadosUsuario.emailUsuario());

        if (livro.isPresent() && usuario.isPresent()){
            var livroDesejado = livro.get();
            var usuarioDesejando = usuario.get();

            desejoRepository.save(new Desejo(livroDesejado, usuarioDesejando));

        }
    }
}
