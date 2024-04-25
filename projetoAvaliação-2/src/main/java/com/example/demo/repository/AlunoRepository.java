package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByRenda(String renda);
	List<Aluno> findByRa(String ra);
	List<Aluno> findByCidadeAndRenda(String cidade, double renda);

    @Query("SELECT a FROM Aluno a WHERE a.nome = :nome")
    List<Aluno> findByNome(@Param("nome") String nome);
    
    //Buscar Nome Completo
    @Query("SELECT a FROM Aluno a WHERE a.nomeCompleto LIKE :nomeCompleto")
    List<Aluno> findByNomeLike(@Param("nomeCompleto") String nomeCompleto);
    
    //Buscar todos os alunos de uma determinada turma:
    @Query("SELECT a FROM Aluno a JOIN a.turma t WHERE t.id = turmaId")
    List<Aluno> findByTurmaId(@Param("turmaId") Long turmaId);
}