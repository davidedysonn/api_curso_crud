package com.curso.api.cursoApi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.api.cursoApi.dto.CursoDto;
import com.curso.api.cursoApi.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	Optional<Curso> findByNomeCurso(String nomeCurso);
	Optional<Curso> findById (Long id);

	@Query(value = " select cur.* from curso cur "
			+ " where cur.nome_curso like concat('%', ?1, '%') "
			, nativeQuery=true)
	List<Curso> findByPartOfNomeCurso(String partNomeCurso);

}
