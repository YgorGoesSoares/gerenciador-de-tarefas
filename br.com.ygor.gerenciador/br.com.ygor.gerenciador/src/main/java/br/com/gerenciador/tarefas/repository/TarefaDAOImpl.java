package br.com.gerenciador.tarefas.repository;

import br.com.gerenciador.tarefas.model.Tarefa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TarefaDAOImpl implements TarefaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tarefa> buscarTodas() {
        return entityManager.createQuery("SELECT t FROM Tarefa t", Tarefa.class).getResultList();
    }

    @Override
    public List<Tarefa> buscarTarefasConcluidas() {
        return entityManager.createQuery("SELECT t FROM Tarefa t WHERE t.concluida = true", Tarefa.class).getResultList();
    }


    @Override
    public List<Tarefa> buscarTarefasNaoConcluidas() {
        return entityManager.createQuery("SELECT t FROM Tarefa t WHERE t.concluida = false", Tarefa.class).getResultList();
    }

    @Override
    public List<Tarefa> buscarTarefasExcluidas() {
        return entityManager.createQuery("SELECT t FROM Tarefa t WHERE t.excluida = true", Tarefa.class).getResultList();
    }

    @Override
    @Transactional
    public void salvar(Tarefa tarefa) {
        entityManager.persist(tarefa);
    }

    @Override
    public Tarefa buscarPorId(Long id) {
        return entityManager.find(Tarefa.class, id);
    }

    @Override
    @Transactional
    public void excluir(Tarefa tarefa) {
        entityManager.remove(entityManager.contains(tarefa) ? tarefa : entityManager.merge(tarefa));
    }


}
