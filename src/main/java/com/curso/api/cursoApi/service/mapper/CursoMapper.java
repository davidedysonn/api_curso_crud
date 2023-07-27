package com.curso.api.cursoApi.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.curso.api.cursoApi.dto.AlunoDto;
import com.curso.api.cursoApi.entities.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.api.cursoApi.dto.CursoDto;
import com.curso.api.cursoApi.entities.Curso;

@Service
public class CursoMapper {
	@Autowired
	private AlunoDto alunoDto;
	@Autowired
	private Aluno alunos;
	public CursoDto convertCursoToDto (Curso curso) {
		
		CursoDto respostaCursoDto = new CursoDto();
		respostaCursoDto.setId(curso.getId());
		respostaCursoDto.setNomeCurso(curso.getNomeCurso());
		respostaCursoDto.setDataInicio(curso.getDataInicio());
		respostaCursoDto.setDataFim(curso.getDataFim());
		respostaCursoDto.setAlunosListDto(curso.getAlunos());
		
		return respostaCursoDto;
		
	}
	
	public Curso converterCursoToEntity (CursoDto cursoDto) {
		
		Curso respostaCurso = new Curso();
		respostaCurso.setId(cursoDto.getId());
		respostaCurso.setNomeCurso(cursoDto.getNomeCurso());
		respostaCurso.setDataInicio(cursoDto.getDataInicio());
		respostaCurso.setDataFim(cursoDto.getDataFim());
		respostaCurso.setAlunos(cursoDto.getAlunosListDto());
		
		return respostaCurso;
	}
	
	public List<CursoDto> convertListCursoToDto(List<Curso> listCurso) {
		List<CursoDto> listCursoDto = new ArrayList<>();
		listCurso.stream().forEach(curso -> {
			listCursoDto.add(convertCursoToDto(curso));
		});
		return listCursoDto;

	}
	
	public List<Curso> convertListCursoDtoToEntity(List<CursoDto> listCursoDto) {
		List<Curso> listCurso = new ArrayList<>();
		listCursoDto.stream().forEach(cursoDto -> {
			listCurso.add(converterCursoToEntity(cursoDto));
		});
		return listCurso;

	}
	

	

}
