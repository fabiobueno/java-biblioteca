package br.biblioteca.livros.controllers;

import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/list")
    public ModelAndView list() {

        Iterable<Livro> livros = livroRepository.findAll();

        for (Livro livro : livros) {
            System.out.println(livro.getNome());
        }

        return new ModelAndView( "/livros/list" , "listaLivros" , livros );
    }

    @GetMapping("/novo")
    public ModelAndView newBook() {
        return new ModelAndView("/livros/form");
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(Livro livro) {
        return new ModelAndView("redirect:/livros/list");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView update() {
        return new ModelAndView("redirect:/livros/list");
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView delete() {
        return new ModelAndView("redirect:/livros/list");
    }

}
