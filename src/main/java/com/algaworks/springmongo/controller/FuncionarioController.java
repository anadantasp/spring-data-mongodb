package com.algaworks.springmongo.controller;

import com.algaworks.springmongo.model.Funcionario;
import com.algaworks.springmongo.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> obterTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.obterTodos());

    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Funcionario> obterPorCodigo(@PathVariable String codigo){
        return ResponseEntity.status(HttpStatus.OK).body(service.obterPorCodigo(codigo));

    }

    @PostMapping
    public ResponseEntity<Funcionario>  criar(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(funcionario));

    }

    @GetMapping("/range")
    public ResponseEntity<List<Funcionario>> obterFuncionariosPorRangeDeIdade(@RequestParam("de")Integer de, @RequestParam("ate")Integer ate){
        return ResponseEntity.status(HttpStatus.OK).body(service.obterFuncionariosPorRangeDeIdade(de, ate));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Funcionario>> obterFuncionariosPorRangeDeIdade(@RequestParam("nome")String nome){
        return ResponseEntity.status(HttpStatus.OK).body(service.obterFuncionariosPorNome(nome));
    }


}
