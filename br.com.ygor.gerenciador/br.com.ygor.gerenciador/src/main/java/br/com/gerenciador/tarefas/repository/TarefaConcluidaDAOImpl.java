package br.com.gerenciador.tarefas.repository;

import br.com.gerenciador.tarefas.model.TarefaConcluida;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class TarefaConcluidaDAOImpl implements TarefaConcluidaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TarefaConcluida> buscarTodasTarefasConcluidas() {
        return entityManager.createQuery("SELECT tc FROM TarefaConcluida tc", TarefaConcluida.class).getResultList();
    }

    @Override
    @Transactional
    public void salvar(TarefaConcluida tarefaConcluida) {
        entityManager.persist(tarefaConcluida);
    }
}
