package com.algaworks.springmongo.service.impl;

import com.algaworks.springmongo.model.Funcionario;
import com.algaworks.springmongo.repository.FuncionarioRepository;
import com.algaworks.springmongo.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioServiceImpl(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Funcionario> obterTodos() {
        return repository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return repository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Funcionario não existe"));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        var chefe = repository.findById(funcionario.getChefe().getCodigo()).orElseThrow(() -> new IllegalArgumentException("Chefe inexistente"));

        funcionario.setChefe(chefe);

        return repository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate) {
        return repository.obterFuncionariosPorRangeDeIdade(de, ate);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorNome(String nome) {
        return repository.findByNome(nome);
    }
}
