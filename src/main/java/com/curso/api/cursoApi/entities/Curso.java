package com.curso.api.cursoApi.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Curso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCurso;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	@ManyToMany(mappedBy = "cursos")
	private List<Aluno> alunos = new ArrayList<>();

	public Curso() {

	}

	public Curso(Long id, String nomeCurso, LocalDate dataInicio, LocalDate dataFim, List<Aluno> alunos) {
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.alunos = alunos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Curso curso = (Curso) o;
		return Objects.equals(id, curso.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Curso{" +
				"id=" + id +
				", nomeCurso='" + nomeCurso + '\'' +
				", dataInicio=" + dataInicio +
				", dataFim=" + dataFim +
				", alunos=" + alunos +
				'}';
	}
}
