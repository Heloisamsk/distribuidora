<<<<<<< HEAD
package dados;
=======
>>>>>>> main

package dados;

import java.util.ArrayList;
import negocio.Cliente;

public class RepositorioCliente {
    private ArrayList<Cliente> clientes = new ArrayList();

<<<<<<< HEAD
    private final List<Cliente> clientes = new ArrayList<>();

    /*public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }*/

    public void adicionar(Cliente cliente) {
        /*if (cliente == null) {
            throw new IllegalArgumentException("Cliente nulo");
        }

        // opcional: impedir CPF duplicado
        if (buscarPorCpf(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Já existe um cliente com este CPF");
        }*/

        clientes.add(cliente);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes); // retorna cópia da lista
=======
    public boolean cadastrar(Cliente cliente) {
        if(this.clientes.add(cliente)) {
            return true;
        }
        return false;
>>>>>>> main
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : this.clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public void listarTodos() {
        if (this.clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }
        System.out.println("Clientes: ");
        for (Cliente c : this.clientes) {
            System.out.println(c.getNome());
        }
    }

    public boolean remover(String cpf) {
        Cliente c = this.buscarPorCpf(cpf);
        if (c != null) {
            this.clientes.remove(c);
            c.setCadastrado(false);
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizar(Cliente cliente) {
        for(int i = 0; i < this.clientes.size(); ++i) {
            if (((Cliente)this.clientes.get(i)).getCpf().equals(cliente.getCpf())) {
                this.clientes.set(i, cliente);
                return true;
            }
        }

        return false;
    }
}
