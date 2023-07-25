package com.curso.api.cursoApi.serviciesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.api.cursoApi.dto.AlunoDto;
import com.curso.api.cursoApi.entities.Aluno;
import com.curso.api.cursoApi.repositories.AlunoRepository;
import com.curso.api.cursoApi.repositories.CursoRepository;
import com.curso.api.cursoApi.serviciesImpl.service.AlunoService;
import com.curso.api.cursoApi.serviciesImpl.service.CursoService;
import com.curso.api.cursoApi.serviciesImpl.service.mapper.AlunoMapper;
import com.curso.api.cursoApi.serviciesImpl.service.mapper.CursoMapper;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoMapper alunoMapper;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private CursoMapper cursoMapper;

	@Override
	public AlunoDto salvarAluno(AlunoDto alunoDto) {
		Aluno respostaAlunoDto = alunoMapper.converterAlunoEmEntidade(alunoDto);
		Aluno respostaSalvarAluno = alunoRepository.save(respostaAlunoDto);
		AlunoDto devolverAlunoDto = alunoMapper.converteAlunoEmDto(respostaSalvarAluno);

		return devolverAlunoDto;
	}

	@Override
	public AlunoDto atualizarAlunoId(Long id) {
		Optional<Aluno> respostaAluno = alunoRepository.findById(id);
		AlunoDto alunoDto = alunoMapper.converteAlunoEmDto(respostaAluno.get());
		if (!respostaAluno.isEmpty()) {
			return alunoDto;
		} else {
			return null;
		}

	}

	@Override
	public void deletarAlunoId(Long id) {
		Optional<Aluno> respostaDeletarAlunoPorId = alunoRepository.findById(id);
		if (!respostaDeletarAlunoPorId.isEmpty()) {
			alunoRepository.deleteById(id);
		} else {
			// seria interessante por uma informação
			// dizendo que nao foi possivel encontrar
			// o Aluno para ser deletado.
		}

	}

	@Override
	public AlunoDto buscarAlunoId(Long id) {
		Optional<Aluno> respostaBuscarAlunoPorId = alunoRepository.findAlunoById(id);
		AlunoDto respostaAlunoDto = alunoMapper.converteAlunoEmDto(respostaBuscarAlunoPorId.get());
		if (!respostaBuscarAlunoPorId.isEmpty()) {
			return respostaAlunoDto;
		} else {
			return null;
		}

	}

	public List<AlunoDto> buscarNomeAluno(String nomeAluno) {

		List<Aluno> respostaAlunoList = alunoRepository.findByNomeAluno(nomeAluno);
		List<AlunoDto> alunoDtoList = alunoMapper.convertListAlunoEmDto(respostaAlunoList);
		if (!respostaAlunoList.isEmpty()) {
			return alunoDtoList;
		} else {
			return null;
		}

	}

	@Override
	public List<AlunoDto> buscarAlunobyIdList(Long id) {
		List<Aluno> respostaAlunoList = alunoRepository.findAlunosbyIdCurso(id);
		List<AlunoDto> respostaAlunoDtoList = alunoMapper.convertListAlunoEmDto(respostaAlunoList);
		if(!respostaAlunoList.isEmpty()) {
			return respostaAlunoDtoList;
		}
		else {
			return null;

		}
		
	}

}
