package com.curso.api.cursoApi.service;

import java.util.List;

import com.curso.api.cursoApi.dto.AlunoDto;
import com.curso.api.cursoApi.dto.CursoDto;

public interface AlunoService {
	
	
	
	AlunoDto salvarAluno (AlunoDto alunoDto);
	AlunoDto atualizarAlunoId (Long id);
	void deletarAlunoId(Long id);
	
	List<AlunoDto> buscarNomeAluno (String nomeAluno);
	AlunoDto buscarAlunoId (Long id);
	
	List<AlunoDto> buscarAlunobyIdList(Long id);
	

}
