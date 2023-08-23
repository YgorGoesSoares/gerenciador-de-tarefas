package br.com.gerenciador.tarefas.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private boolean concluida;
    private boolean excluida;

    private LocalDate dataConclusao;

    public Tarefa() {
    }

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida() {
        this.concluida = true;
    }

    public boolean isExcluida() {
        return excluida;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public boolean podeSerExcluida() {
        return !concluida && !excluida;
    }

    public void naoConcluida() {
        this.concluida = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
