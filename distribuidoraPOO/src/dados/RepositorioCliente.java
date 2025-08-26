package dados;

import negocio.Cliente;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {

    private final List<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    public void adicionar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente nulo");
        }

        // opcional: impedir CPF duplicado
        if (buscarPorCpf(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Já existe um cliente com este CPF");
        }

        clientes.add(cliente);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes); // retorna cópia da lista
    }

    public Cliente buscarPorCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }

        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }
}
