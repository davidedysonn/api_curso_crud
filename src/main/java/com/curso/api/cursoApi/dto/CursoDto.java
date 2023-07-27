package com.curso.api.cursoApi.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CursoDto {
	
	
	private Long id;
	private String nomeCurso;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private List<AlunoDto> alunosListDto = new ArrayList<>();

	public CursoDto(){

	}

	public CursoDto(Long id, String nomeCurso, LocalDate dataInicio, LocalDate dataFim, List<AlunoDto> alunosListDto) {
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.alunosListDto = alunosListDto;
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

	public List<AlunoDto> getAlunosListDto() {
		return alunosListDto;
	}

	public void setAlunosListDto(List<AlunoDto> alunosListDto) {
		this.alunosListDto = alunosListDto;
	}
}
