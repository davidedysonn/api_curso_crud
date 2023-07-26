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
	private List<Aluno> alunosList = new ArrayList<>();

	public Curso() {

	}

	public Curso(Long id, String nomeCurso, LocalDate dataInicio, LocalDate dataFim) {
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

	public List<Aluno> getAlunosList() {
		return alunosList;
	}

	public void setAlunosList(List<Aluno> alunosList) {
		this.alunosList = alunosList;
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
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

}
