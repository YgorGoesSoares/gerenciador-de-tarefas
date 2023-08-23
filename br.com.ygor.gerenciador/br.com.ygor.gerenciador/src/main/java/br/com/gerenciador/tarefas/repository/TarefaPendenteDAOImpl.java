package br.com.gerenciador.tarefas.repository;

import br.com.gerenciador.tarefas.model.Tarefa;
import br.com.gerenciador.tarefas.model.TarefaPendente;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class TarefaPendenteDAOImpl implements TarefaPendenteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TarefaPendente> buscarTodasTarefasPendentes() {
        return entityManager.createQuery("SELECT tp FROM TarefaPendente tp", TarefaPendente.class).getResultList();
    }

    @Override
    @Transactional
    public void salvar(TarefaPendente tarefaPendente) {
        entityManager.persist(tarefaPendente);
    }

    @Override
    public TarefaPendente buscarPorTarefa(Tarefa tarefa) {
        return entityManager.createQuery("SELECT tp FROM TarefaPendente tp WHERE tp.tarefa = :tarefa", TarefaPendente.class)
                .setParameter("tarefa", tarefa)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    @Transactional
    public void excluir(TarefaPendente tarefaPendente) {
        entityManager.remove(tarefaPendente);
    }
}
