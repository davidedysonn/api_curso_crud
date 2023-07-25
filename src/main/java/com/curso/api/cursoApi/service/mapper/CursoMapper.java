package com.curso.api.cursoApi.service.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.api.cursoApi.dto.CursoDto;
import com.curso.api.cursoApi.entities.Curso;

@Service
public class CursoMapper {
	
	
	public CursoDto convertCursoToDto (Curso curso) {
		
		CursoDto respostaCursoDto = new CursoDto();
		respostaCursoDto.setId(curso.getId());
		respostaCursoDto.setNomeCurso(curso.getNomeCurso());
		respostaCursoDto.setDataInicio(curso.getDataInicio());
		respostaCursoDto.setDataFim(curso.getDataFim());
		
		return respostaCursoDto;
		
	}
	
	public Curso converterCursoToEntity (CursoDto cursoDto) {
		
		Curso respostaCurso = new Curso();
		respostaCurso.setId(cursoDto.getId());
		respostaCurso.setNomeCurso(cursoDto.getNomeCurso());
		respostaCurso.setDataInicio(cursoDto.getDataInicio());
		respostaCurso.setDataFim(cursoDto.getDataFim());
		
		return respostaCurso;
	}
	
	public List<CursoDto> convertListCursoToDto(List<Curso> listCurso) {
		List<CursoDto> listCursoDto = new ArrayList<>();
		listCurso.stream().forEach(Curso -> {
			listCursoDto.add(convertCursoToDto(Curso));
		});
		return listCursoDto;

	}
	
	public List<Curso> convertListCursoDtoToEntity(List<CursoDto> listCursoDto) {
		List<Curso> listCurso = new ArrayList<>();
		listCursoDto.stream().forEach(CursoDto -> {
			listCurso.add(converterCursoToEntity(CursoDto));
		});
		return listCurso;

	}
	

	

}
