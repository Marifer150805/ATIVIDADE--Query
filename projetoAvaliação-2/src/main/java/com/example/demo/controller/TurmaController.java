package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Turma;
import com.example.demo.service.TurmaService;


@RestController
@RequestMapping("/turma")
public class TurmaController {

	private final TurmaService turmaService;
	@Autowired
	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> getTurmaById(@PathVariable Long id) {
		Turma turma = turmaService.getTurmaById(id);
		if (turma != null) {
			return ResponseEntity.ok(turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Turma>> getAllTurma() {
		List<Turma> turma = turmaService.getAllTurma();
		return ResponseEntity.ok(turma);
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Turma>> getTurmasPorNome(@PathVariable String nome){
		List<Turma> turmas = turmaService.getTurmasPorNome(nome);
		return ResponseEntity.ok(turmas);
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Turma>> getTurmasPorDescricao(@PathVariable String descricao){
		List<Turma> turmas = turmaService.getTurmasPorDescricao(descricao);
		return ResponseEntity.ok(turmas);
	}
	@GetMapping("/nome/{nome}/descricao/{descricao}")
	public ResponseEntity<List<Turma>> getTurmasPorNomeEDescricao(@PathVariable String nome, String descricao){
		List<Turma> turmas = turmaService.getTurmasPorNomeAndDescricao(nome, descricao);
		return ResponseEntity.ok(turmas);
	}

	@PostMapping("/")
	public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
		Turma criarTurma = turmaService.salvaTurma(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarTurma);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable Long id,@RequestBody Turma turma) {
		Turma updatedTurma = turmaService.updateTurma(id, turma);
		if (updatedTurma != null) {
			return ResponseEntity.ok(updatedTurma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Long id) {
		boolean deleted = turmaService.deleteTurma(id);
		if (deleted) {
			return ResponseEntity.ok().body("A Turma foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}