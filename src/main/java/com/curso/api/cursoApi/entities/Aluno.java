package com.curso.api.cursoApi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Aluno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeAluno;
	private LocalDate dataCadastro;

	@Autowired
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	public Aluno() {

	}

	public Aluno(Long id, String nomeAluno, LocalDate dataCadastro, Curso curso) {
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.dataCadastro = dataCadastro;
		this.curso = curso;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nomeAluno=" + nomeAluno + ", dataCadastro=" + dataCadastro + ", curso=" + curso
				+ ", getId()=" + getId() + ", getNomeAluno()=" + getNomeAluno() + ", getDataCadastro()="
				+ getDataCadastro() + ", getCurso()=" + getCurso() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

	
	
	
	

}
