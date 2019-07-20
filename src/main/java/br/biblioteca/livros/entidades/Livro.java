package br.biblioteca.livros.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.biblioteca.livros.entidades.Autor;

@Entity
public class Livro {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Integer quantidadePaginas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
