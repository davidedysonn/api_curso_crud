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

import com.curso.api.cursoApi.dto.CursoDto;
import com.curso.api.cursoApi.service.AlunoService;
import com.curso.api.cursoApi.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private AlunoService alunoService;

	@PostMapping("/adc-curso")
	public ResponseEntity<CursoDto> adcCurso(@RequestBody CursoDto cursoDto) throws URISyntaxException {
		CursoDto respostaCursoDto = cursoService.salvarCursoDto(cursoDto);

		return ResponseEntity.created(new URI("/apiCurso/adcCurso/")).body(respostaCursoDto);
		// return ResponseEntity.ok().body(respostaCursoDto);
	}

	@PutMapping("/atualizarCursoPeloId/{id}")
	public ResponseEntity<CursoDto> atualizarNomeCursoById(@PathVariable Long id, @RequestBody String nomeCurso) {
		CursoDto respostaAtualizarNomeCurso = cursoService.atualizarCursoByName(id, nomeCurso);
		return ResponseEntity.ok().body(respostaAtualizarNomeCurso);
	}

	@DeleteMapping("/deteltarCursoPeloId/{id}")
	public ResponseEntity<String> deteltarPeloId(@PathVariable Long id) {
		cursoService.deletarCursoById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscarCursoPorNome")
	public ResponseEntity<CursoDto> buscarCursoPorNome(@RequestParam String nomeCurso) {
		CursoDto respostaBuscarCursoPorNome = cursoService.buscarCursoByName(nomeCurso);
		return ResponseEntity.ok().body(respostaBuscarCursoPorNome);

	}

	@GetMapping("/buscarCursoPeloId/{id}")
	public ResponseEntity<CursoDto> buscarCursoPeloId(@PathVariable Long id) {
		CursoDto respostaEncontrarCursoById = cursoService.encontrarCursoById(id);
		return ResponseEntity.ok().body(respostaEncontrarCursoById);
	}
	
	@GetMapping("/buscarCursoPartNome")
	public ResponseEntity<List<CursoDto>> buscarCursoPartNome(@RequestParam String partNomeCurso) {
		List<CursoDto> cursoDtoList = cursoService.buscarCursoPartNome(partNomeCurso);
		return ResponseEntity.ok(cursoDtoList);
	}

}
