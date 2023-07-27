package com.curso.api.cursoApi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAluno;
    private LocalDate dataCadastro;

    @JoinTable(name = "REF_ALUNOS_CURSOS",
            joinColumns = @JoinColumn(name = "alunos_id"),
            inverseJoinColumns = @JoinColumn(name = "cursos_id")

    )
    @ManyToMany
    private List<Curso> cursos = new ArrayList<>();

    public Aluno() {

    }

    public Aluno(Long id, String nomeAluno, LocalDate dataCadastro, List<Curso> cursos) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.dataCadastro = dataCadastro;
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", cursos=" + cursos +
                '}';
    }
}
