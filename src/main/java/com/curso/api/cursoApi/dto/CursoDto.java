package com.curso.api.cursoApi.dto;

import com.curso.api.cursoApi.entities.Aluno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CursoDto {
	
	
	private Long id;
	private String nomeCurso;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private List<AlunoDto> alunosList = new ArrayList<>();

	public CursoDto(){

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

	public List<AlunoDto> getAlunosList() {
		return alunosList;
	}

	public void setAlunosList(List<AlunoDto> alunosList) {
		this.alunosList = alunosList;
	}
}
