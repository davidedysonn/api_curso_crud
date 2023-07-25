package com.curso.api.cursoApi.dto;

import java.time.LocalDate;

public class AlunoDto {

	private Long id;
	private String nomeAluno;
	private LocalDate dataCadastro;
	private CursoDto cursoDto;
	
	public AlunoDto() {
		
	}

	public AlunoDto(Long id, String nomeAluno, LocalDate dataCadastro, CursoDto cursoDto) {
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.dataCadastro = dataCadastro;
		this.cursoDto = cursoDto;
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

	public CursoDto getCursoDto() {
		return cursoDto;
	}

	public void setCursoDto(CursoDto cursoDto) {
		this.cursoDto = cursoDto;
	}

}
