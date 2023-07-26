package com.curso.api.cursoApi.service.serviciesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.curso.api.cursoApi.entities.Aluno;
import com.curso.api.cursoApi.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import com.curso.api.cursoApi.dto.CursoDto;
import com.curso.api.cursoApi.entities.Curso;
import com.curso.api.cursoApi.repositories.CursoRepository;
import com.curso.api.cursoApi.service.CursoService;
import com.curso.api.cursoApi.service.mapper.CursoMapper;

@Service
public class CursoServiceImpl implements CursoService {

	private CursoRepository cursoRepository;

	private CursoMapper cursoMapper;

	private AlunoRepository alunoRepository;

	public CursoServiceImpl(CursoRepository cursoRepository, CursoMapper cursoMapper, AlunoRepository alunoRepository) {
		this.cursoRepository = cursoRepository;
		this.cursoMapper = cursoMapper;
		this.alunoRepository = alunoRepository;
	}

	@Override
	public CursoDto salvarCursoDto(CursoDto cursoDto) {
		Curso respostaCurso = cursoMapper.converterCursoToEntity(cursoDto);
		Curso salvarRespostaCurso = cursoRepository.save(respostaCurso);
		CursoDto salvarCursoDto = cursoMapper.convertCursoToDto(salvarRespostaCurso);

		return salvarCursoDto;
	}

	@Override
	public CursoDto buscarCursoByName(String nomeCurso) {
		Optional<Curso> buscarCurso = cursoRepository.findByNomeCurso(nomeCurso);

		CursoDto respostaBuscaCursoByName = cursoMapper.convertCursoToDto(buscarCurso.get());
		return respostaBuscaCursoByName;

	}

	@Override
	public void deletarCursoById(Long id) {
		Optional<Curso> respostaCurso = cursoRepository.findById(id);
		if(respostaCurso.isPresent()){
			if(!respostaCurso.get().getAlunosList().isEmpty()){
				respostaCurso
						.get()
						.getAlunosList()
						.stream()
						.forEach(aluno-> alunoRepository.deleteById(aluno.getId()));
				cursoRepository.deleteById(id);
			} else {
				cursoRepository.deleteById(
						id
				);
			}

		}

	}

	@Override
	public CursoDto atualizarCursoByName(Long id, String nomeCurso) {
		Optional<Curso> atualizarNomeCurso = cursoRepository.findById(id);
		if (!atualizarNomeCurso.isEmpty()) {
			atualizarNomeCurso.get().setNomeCurso(nomeCurso);
			Curso atualizaCurso = cursoRepository.save(atualizarNomeCurso.get());
			CursoDto respondeAtualizarNomeCurso = cursoMapper.convertCursoToDto(atualizaCurso);
			return respondeAtualizarNomeCurso;

		} else {
			return null;
		}
	}

	@Override
	public CursoDto encontrarCursoById(Long id) {
		Optional<Curso> encontrarCursoById = cursoRepository.findById(id);
		if (!encontrarCursoById.isEmpty()) {
			// encontrarCursoById.get();
			CursoDto cursoDto = cursoMapper.convertCursoToDto(encontrarCursoById.get());
			return cursoDto;
//
		} else {
			return null;
		}

	}

	@Override
	public List<CursoDto> buscarCursoPartNome(String partNomeCurso) {
		List<Curso> cursoList = cursoRepository.findByPartOfNomeCurso(partNomeCurso);
		List<CursoDto>cursoDtoList = cursoMapper.convertListCursoToDto(cursoList);
		return cursoDtoList;
	}

}
