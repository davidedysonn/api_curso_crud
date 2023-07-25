package com.curso.api.cursoApi.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.api.cursoApi.dto.AlunoDto;
import com.curso.api.cursoApi.entities.Aluno;

@Service
public class AlunoMapper {

	
	private CursoMapper cursoMapper;
	
	
	public AlunoMapper(CursoMapper cursoMapper) {
		this.cursoMapper = cursoMapper;
	}

	public AlunoDto converteAlunoEmDto(Aluno aluno)  {
		
		AlunoDto alunoDto = new AlunoDto();
		alunoDto.setId(aluno.getId());
	
		alunoDto.setCursoDto(cursoMapper.convertCursoToDto(aluno.getCurso()));
		
		alunoDto.setNomeAluno(aluno.getNomeAluno());
		alunoDto.setDataCadastro(aluno.getDataCadastro());

		return alunoDto;
		
	}
	
	public List<AlunoDto> convertListAlunoEmDto(List<Aluno> listAluno) {
		List<AlunoDto> listAlunoDto = new ArrayList<>();
		listAluno.stream().forEach(aluno -> {
			listAlunoDto.add(converteAlunoEmDto(aluno));
		});
		return listAlunoDto;

	}
	
	public List<Aluno> convertListAlunoDtoEmEntidade(List<AlunoDto> listAlunoDto) {
		List<Aluno> listAluno = new ArrayList<>();
		listAlunoDto.stream().forEach(alunoDto -> {
			listAluno.add(converterAlunoEmEntidade(alunoDto));
		});
		return listAluno;

	}
	

	public Aluno converterAlunoEmEntidade(AlunoDto alunoDto) {

		Aluno respostaConverterAlunoEmEntidade = new Aluno();
		respostaConverterAlunoEmEntidade.setId(alunoDto.getId());
		
		respostaConverterAlunoEmEntidade.setCurso(
				cursoMapper.converterCursoToEntity(alunoDto.getCursoDto())
				);
		
		respostaConverterAlunoEmEntidade.setNomeAluno(alunoDto.getNomeAluno());
		respostaConverterAlunoEmEntidade.setDataCadastro(alunoDto.getDataCadastro());
		return respostaConverterAlunoEmEntidade;
	}

}
