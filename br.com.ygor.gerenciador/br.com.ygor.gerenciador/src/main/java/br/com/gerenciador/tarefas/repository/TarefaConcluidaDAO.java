package br.com.gerenciador.tarefas.repository;

import br.com.gerenciador.tarefas.model.TarefaConcluida;

import java.util.List;

public interface TarefaConcluidaDAO {
    List<TarefaConcluida> buscarTodasTarefasConcluidas();
    void salvar(TarefaConcluida tarefaConcluida);
}
