package br.com.gerenciador.tarefas.controller;

import br.com.gerenciador.tarefas.model.Tarefa;
import br.com.gerenciador.tarefas.model.TarefaConcluida;
import br.com.gerenciador.tarefas.model.TarefaPendente;
import br.com.gerenciador.tarefas.repository.TarefaConcluidaDAOImpl;
import br.com.gerenciador.tarefas.repository.TarefaDAOImpl;
import br.com.gerenciador.tarefas.repository.TarefaPendenteDAO;
import br.com.gerenciador.tarefas.repository.TarefaPendenteDAOImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TarefaController {
    private final TarefaDAOImpl tarefaDAO;
    private final TarefaConcluidaDAOImpl tarefaConcluidaDAO;
    private final TarefaPendenteDAOImpl tarefaPendenteDAO;

    public TarefaController(TarefaDAOImpl tarefaDAO, TarefaConcluidaDAOImpl tarefaConcluidaDAO, TarefaPendenteDAOImpl tarefaPendenteDAO) {
        this.tarefaDAO = tarefaDAO;
        this.tarefaConcluidaDAO = tarefaConcluidaDAO;
        this.tarefaPendenteDAO = tarefaPendenteDAO;
    }

    @GetMapping("/")
    public String listarTarefas(Model model) {
        List<TarefaPendente> tarefasPendentes = tarefaPendenteDAO.buscarTodasTarefasPendentes();
        model.addAttribute("tarefas", tarefasPendentes);
        return "index";
    }

    @PostMapping("/adicionar")
    public String adicionarTarefa(@RequestParam String descricao) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(descricao);
        tarefaDAO.salvar(tarefa);

        TarefaPendente tarefaPendente = new TarefaPendente();
        tarefaPendente.setTarefa(tarefa);
        tarefaPendenteDAO.salvar(tarefaPendente);

        return "redirect:/";
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping("/concluir")
    public String concluirTarefa(@RequestParam Long id, HttpServletRequest request) {
        Tarefa tarefa = tarefaDAO.buscarPorId(id);

        if (tarefa != null) {
            LocalDate dataAgora = LocalDate.now();

            TarefaConcluida tarefaConcluida = new TarefaConcluida();
            tarefaConcluida.setTarefa(tarefa);
            tarefaConcluidaDAO.salvar(tarefaConcluida);

            TarefaPendente tarefaPendente = tarefaPendenteDAO.buscarPorTarefa(tarefa);
            if (tarefaPendente != null) {
                entityManager.remove(tarefaPendente);
            }

            tarefa.setConcluida();
            tarefa.setDataConclusao(dataAgora);
            tarefaDAO.salvar(tarefa);

            return "redirect:" + request.getHeader("Referer");
        }

        return "redirect:" + request.getHeader("Referer");
    }

    @Transactional
    @PostMapping("/excluir")
    public String excluirTarefa(@RequestParam Long id, HttpServletRequest request) {
        Tarefa tarefa = tarefaDAO.buscarPorId(id);

        if (tarefa != null) {
            TarefaPendente tarefaPendente = tarefaPendenteDAO.buscarPorTarefa(tarefa);
            if (tarefaPendente != null) {
                entityManager.remove(tarefaPendente);
            }

            tarefaDAO.excluir(tarefa);

            return "redirect:" + request.getHeader("Referer");
        }

        return "redirect:" + request.getHeader("Referer");
    }


    @GetMapping("/concluidas")
    public String listarTarefasConcluidas(Model model) {
        List<TarefaConcluida> tarefasConcluidas = tarefaConcluidaDAO.buscarTodasTarefasConcluidas();
        model.addAttribute("tarefasConcluidas", tarefasConcluidas);
        return "concluidas";
    }

    @GetMapping("/excluidas")
    public String listarTarefasExcluidas(Model model) {
        List<Tarefa> tarefasExcluidas = tarefaDAO.buscarTarefasExcluidas();
        model.addAttribute("tarefasExcluidas", tarefasExcluidas);
        return "excluidas";
    }
}
