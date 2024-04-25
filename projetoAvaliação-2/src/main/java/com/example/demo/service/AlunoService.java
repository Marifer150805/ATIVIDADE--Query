package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Aluno;
import com.example.demo.repository.AlunoRepository;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;
	
	//@query
	public List<Aluno> findByNome(String nome) {
		return alunoRepository.findByNome(nome);
	}
	
	//@query 
	public List<Aluno> findByNomeCompletoLike(String nomeCompleto) {
		return alunoRepository.findByNomeLike(nomeCompleto);
	}

	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	//Query Method
	public List<Aluno> buscarAlunosPorCidade(String cidade){
		return alunoRepository.findByCidade(cidade);
	}
	public List<Aluno> buscarAlunosPorRenda(String renda){
		return alunoRepository.findByRenda(renda);
	}
	public List<Aluno> buscarCidadeERenda(String cidade, double renda){
		return alunoRepository.findByCidadeAndRenda(cidade, renda);
	}
	public List<Aluno> buscaTodosAlunos(){
		return alunoRepository.findAll();
	}
	public Aluno buscaAlunoId(Long id) {
		Optional <Aluno> Aluno = alunoRepository.findById(id);
		return Aluno.orElse(null);
	}
	public Aluno salvaAluno (Aluno Aluno) {
		return alunoRepository.save(Aluno);
	}
	public Aluno alterarAluno(Long id, Aluno alterarC) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		
		if (existeAluno.isPresent()) {
			alterarC.setId(id);
			return alunoRepository.save(alterarC);
		}

		return null;
	}
	public boolean apagarAluno(Long id) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		
		if (existeAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}