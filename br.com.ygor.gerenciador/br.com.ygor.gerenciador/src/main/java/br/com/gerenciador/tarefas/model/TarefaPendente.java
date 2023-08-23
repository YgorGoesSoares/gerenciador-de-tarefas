
package br.com.gerenciador.tarefas.model;

import jakarta.persistence.*;

@Entity
public class TarefaPendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Tarefa tarefa;

    private String descricao;

    public TarefaPendente() {
    }

    public TarefaPendente(Tarefa tarefa) {
        this.tarefa = tarefa;
        this.descricao = tarefa.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}