package br.com.gerenciador.tarefas.repository;

import br.com.gerenciador.tarefas.model.Tarefa;

import java.util.List;

public interface TarefaDAO {
    List<Tarefa> buscarTodas();
    List<Tarefa> buscarTarefasConcluidas();

    List<Tarefa> buscarTarefasNaoConcluidas();
    List<Tarefa> buscarTarefasExcluidas();
    void salvar(Tarefa tarefa);
    Tarefa buscarPorId(Long id);
    void excluir(Tarefa tarefa);
}
