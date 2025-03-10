package com.ApiJava.Biblioteca_JAVA_API.service;


import com.ApiJava.Biblioteca_JAVA_API.models.livro.Livro;
import com.ApiJava.Biblioteca_JAVA_API.repository.DesejoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("spring.mail.username")
    private String email;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    DesejoRepository desejoRepository;

    public void enviarEmail(String para, String assunto, String texto){
        System.out.println(email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo(para);
        message.setSubject(assunto);
        message.setText(texto);
        javaMailSender.send(message);

        System.out.println("email enviado|");

    }

    @Async
    public void emailLivroalugado(Livro livroAlugado) {
        var livroDesejado = desejoRepository.livroDesejado(livroAlugado.getId());
        livroDesejado.stream().forEach(desejo -> enviarEmail(
                desejo.getUsuario().getEmail(),
                "Livro Indisponível",
                "Olá, " + desejo.getUsuario().getNome() + ", o livro " + desejo.getLivro().getTitulo() + " da sua lista de desejo, está indisponível no momento."));
    }

    @Async
    public void emailLivroDevolvido(Livro aluguelLivro) {
        var livroDesejado = desejoRepository.livroDesejado(aluguelLivro.getId());
        livroDesejado.stream().forEach(desejo -> enviarEmail(
                desejo.getUsuario().getEmail(),
                "Livro disponivel!",
                "Olá, " + desejo.getUsuario().getNome() + ", o livro " + desejo.getLivro().getTitulo() + " está disponivel para aluguel."));
    }

}
