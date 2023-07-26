package com.curso.api.cursoApi.dto;

import java.time.LocalDate;
import java.util.List;

public class AlunoDto {

	private Long id;
	private String nomeAluno;
	private LocalDate dataCadastro;
	private List<CursoDto> cursoDto;
	
	public AlunoDto() {
		
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

	public List<CursoDto> getCursoDto() {
		return cursoDto;
	}

	public void setCursoDto(List<CursoDto> cursoDto) {
		this.cursoDto = cursoDto;
	}
}
