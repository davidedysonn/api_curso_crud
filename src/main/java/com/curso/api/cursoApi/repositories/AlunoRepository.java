package com.curso.api.cursoApi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.api.cursoApi.entities.Aluno;
import com.curso.api.cursoApi.entities.Curso;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	Optional<Aluno> findAlunoById (Long id);
	
	@Query(value = " select alu.* from aluno alu "
			+ " where alu.nome_aluno like concat('%', ?1, '%') "
			, nativeQuery=true)
	List<Aluno> findByNomeAluno(String nameAluno);
	
	@Query(value = "SELECT  alu. *  FROM ALUNO alu where curso_id = ?1", nativeQuery = true)
	List<Aluno> findAlunosbyIdCurso (Long id);
	
	

}
