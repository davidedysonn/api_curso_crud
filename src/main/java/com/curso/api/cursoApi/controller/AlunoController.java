package com.curso.api.cursoApi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.cursoApi.dto.AlunoDto;
import com.curso.api.cursoApi.repositories.AlunoRepository;
import com.curso.api.cursoApi.serviciesImpl.service.AlunoService;
import com.curso.api.cursoApi.serviciesImpl.service.CursoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@PostMapping("/adc-aluno")
	public ResponseEntity<AlunoDto> adcAluno(@RequestBody AlunoDto alunoDto) throws URISyntaxException{
		AlunoDto respostaAlunoDto = alunoService.salvarAluno(alunoDto);
		return ResponseEntity.created(new URI("/apiCurso/adcAluno/")).body(respostaAlunoDto);
		
	}
	
	@PutMapping("/atualizar-aluno/{id}")
	public ResponseEntity<AlunoDto> atualizarAluno(@PathVariable Long id){
		AlunoDto respostaAlunoDto = alunoService.atualizarAlunoId(id);
		return ResponseEntity.ok().body(respostaAlunoDto);
	}
	
	@DeleteMapping("/deletar-aluno/{id}")
	public ResponseEntity<Void> deletarAlunoPorId(@PathVariable Long id){
		alunoService.deletarAlunoId(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/buscar-aluno-id/{id}")
	public ResponseEntity<AlunoDto> buscarAlunoPorId(@PathVariable Long id){
		AlunoDto respostaAlunoDto = alunoService.buscarAlunoId(id);
		return ResponseEntity.ok().body(respostaAlunoDto);
	}
	
	@GetMapping("/buscar-aluno-nome")
	public ResponseEntity<List<AlunoDto>> buscarNomeAluno(@RequestParam String nomeAluno){
		List<AlunoDto> respondeAlunoDtoList = alunoService.buscarNomeAluno(nomeAluno);
		
		return ResponseEntity.ok().body(respondeAlunoDtoList);
		
	}
	
	@GetMapping("/lista-aluno-idcurso/{id}")
	public ResponseEntity<List<AlunoDto>> buscarListIdCurso (@PathVariable Long id){
		List<AlunoDto> respostaAlunoDtoList = alunoService.buscarAlunobyIdList(id);
		return ResponseEntity.ok().body(respostaAlunoDtoList);
	}
	
	
	
	
	
	
	
	
	
}
