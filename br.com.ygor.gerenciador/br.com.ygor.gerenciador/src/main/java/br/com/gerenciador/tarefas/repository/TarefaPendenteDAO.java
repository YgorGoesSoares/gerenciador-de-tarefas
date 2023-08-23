package br.com.gerenciador.tarefas.repository;

import br.com.gerenciador.tarefas.model.Tarefa;
import br.com.gerenciador.tarefas.model.TarefaPendente;

import java.util.List;

public interface TarefaPendenteDAO {
    List<TarefaPendente> buscarTodasTarefasPendentes();

    void salvar(TarefaPendente tarefaPendente);

    TarefaPendente buscarPorTarefa(Tarefa tarefa);

    void excluir(TarefaPendente tarefaPendente);
}
