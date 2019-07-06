package br.biblioteca.livros.controllers;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/list")
    public ModelAndView list() {
        Iterable<Autor> autores = autorRepository.findAll();

        return new ModelAndView( "/autores/list" , "listaAutores" , autores );
    }

    @GetMapping("/novo")
    public ModelAndView newAuthor() {
        return new ModelAndView( "/autores/form");
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(Autor autor) {
        autorRepository.save(autor);
        return new ModelAndView("redirect:/autores/list");
    }


}
