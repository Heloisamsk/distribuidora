/*package dados;

import negocio.Agendamento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepositorioAgendamento {

    private final List<Agendamento> agendamentos;

    public RepositorioAgendamento() {
        this.agendamentos = new ArrayList<>();
    }

    public void adicionar(Agendamento agendamento) {
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento nulo");
        }

        if (buscarPorPedidoEData(agendamento.getPedido(), agendamento.getDataHoraPrevista()) != null) {
            throw new IllegalArgumentException("Já existe um agendamento para esse pedido na mesma data");
        }

        agendamentos.add(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return new ArrayList<>(agendamentos); // retorna cópia da lista
    }

    public Agendamento buscarPorPedidoEData(negocio.Pedido pedido, Date dataHora) {
        return agendamentos.stream()
                .filter(a -> a.getPedido().equals(pedido) && a.getDataHoraPrevista().equals(dataHora))
                .findFirst()
                .orElse(null);
    }

    public void remover(Agendamento agendamento) {
        agendamentos.remove(agendamento);
    }
}

 */