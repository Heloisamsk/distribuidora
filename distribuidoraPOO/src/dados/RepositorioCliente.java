package dados;

import negocio.Cliente;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {

    private ArrayList<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
        cliente.setCadastrado(true);
        System.out.println("Cliente cadastrado: " + cliente.getNome());
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    public boolean remover(String cpf) {
        Cliente c = buscarPorCpf(cpf);
        if (c != null) {
            clientes.remove(c);
            c.setCadastrado(false);
            return true;
        }
        return false;
    }

    public boolean atualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cliente.getCpf())) {
                clientes.set(i, cliente);
                return true;
            }
        }
        return false;
    }

    /*private final List<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente) {
        /*if (cliente == null) {
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
    }*/
}
