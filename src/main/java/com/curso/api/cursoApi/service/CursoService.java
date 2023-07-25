package com.curso.api.cursoApi.service;

import java.util.List;

import com.curso.api.cursoApi.dto.CursoDto;

public interface CursoService {
	
	CursoDto salvarCursoDto (CursoDto cursoDto);
    CursoDto buscarCursoByName (String nomeCurso);
    CursoDto atualizarCursoByName (Long id, String nomeCurso);
    CursoDto encontrarCursoById (Long id);
    void deletarCursoById(Long id);
    List<CursoDto> buscarCursoPartNome(String partNomeCurso);

}
