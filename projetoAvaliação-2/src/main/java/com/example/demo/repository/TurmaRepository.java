package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	List<Turma> findByNome(String nome);
	List<Turma> findByDescricao(String descricao);
	List<Aluno> findByNomeAndDescricao(String nome, double descricao);
}

