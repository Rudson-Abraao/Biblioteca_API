package com.ApiJava.Biblioteca_JAVA_API.service;

import com.ApiJava.Biblioteca_JAVA_API.models.livro.DadosCadastroLivro;
import com.ApiJava.Biblioteca_JAVA_API.models.livro.DadosLivros;
import com.ApiJava.Biblioteca_JAVA_API.models.usuario.DadosUsuarioEmail;
import com.ApiJava.Biblioteca_JAVA_API.models.alugado.Alugado;
import com.ApiJava.Biblioteca_JAVA_API.models.desejo.Desejo;
import com.ApiJava.Biblioteca_JAVA_API.models.livro.Livro;
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

    @Autowired
    EmailService emailService;

    public Page<DadosLivros> pegarTodosLivros(Pageable paginacao) {
        return repository.findAll(paginacao).map(livro -> new DadosLivros(livro));

    }

    public void cadastrarLivro(List<DadosCadastroLivro> dados) {
        var livrosParaCadastro = dados.stream().map(l -> new Livro(l.titulo(), l.autor(), l.genero(), l.sinopse())).toList();
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

        if (livro.isPresent() && usuario.isPresent()){
            var livroAlugado = livro.get();
            livroAlugado.setAlugado(true);
            System.out.println(livroAlugado.getTitulo());
            var usuarioAlugando = usuario.get();
            alugadoRepository.save(new Alugado(livroAlugado,usuarioAlugando));

            emailService.emailLivroalugado(livroAlugado);

            }

    }

    public void devolucaoLivro(Long id) {
        var aluguel = alugadoRepository.findById(id);

        if (aluguel.isPresent()) {
            var aluguelEncontrado = aluguel.get();
            var aluguelLivro = aluguel.get().getLivro();
            aluguelLivro.setAlugado(false);
            alugadoRepository.delete(aluguelEncontrado);

            emailService.emailLivroDevolvido(aluguelLivro);



        }


    }





}
