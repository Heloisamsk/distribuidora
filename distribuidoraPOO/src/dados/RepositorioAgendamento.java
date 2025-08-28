package dados;

import negocio.Agendamento;
import java.util.ArrayList;

public class RepositorioAgendamento {

    private ArrayList<Agendamento> agendamentos;

    public RepositorioAgendamento() {
        this.agendamentos = new ArrayList<>();
    }

    public void cadastrar(Agendamento agendamento) {
        agendamentos.add(agendamento);
        System.out.println("Agendamento cadastrado para pedido: " + agendamento.getPedido().getNumero());
    }

    public Agendamento buscarPorPedido(int numeroPedido) {
        for (Agendamento a : agendamentos) {
            if (a.getPedido().getNumero() == numeroPedido) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Agendamento> listarTodos() {
        return new ArrayList<>(agendamentos);
    }

    public boolean atualizar(Agendamento agendamento) {
        for (int i = 0; i < agendamentos.size(); i++) {
            if (agendamentos.get(i).getPedido().getNumero() == agendamento.getPedido().getNumero()) {
                agendamentos.set(i, agendamento);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int numeroPedido) {
        Agendamento a = buscarPorPedido(numeroPedido);
        if (a != null) {
            agendamentos.remove(a);
            return true;
        }
        return false;
    }
}