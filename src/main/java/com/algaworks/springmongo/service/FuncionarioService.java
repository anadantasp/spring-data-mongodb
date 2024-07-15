package com.algaworks.springmongo.service;

import com.algaworks.springmongo.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();
    public Funcionario obterPorCodigo(String codigo);
    public Funcionario criar(Funcionario funcionario);

    public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate);

    public List<Funcionario> obterFuncionariosPorNome(String nome);
}
