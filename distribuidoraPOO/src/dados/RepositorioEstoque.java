//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dados;

import java.util.ArrayList;

import negocio.Cliente;
import negocio.Produto;
import negocio.Estoque;

public class RepositorioEstoque {
    private ArrayList<Produto> produtos = new ArrayList();

    public boolean cadastrarProduto(Produto produto, Estoque estoque) {
        if(this.produtos.add(produto)){
            estoque.cadastrarProduto(produto);
            return true;
        }
        return false;
    }

    public Produto buscarPorCodigo(String codigo) {
        for(Produto p : this.produtos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }

        return null;
    }

    public void listarTodos() {
       if(this.produtos.isEmpty()){
           System.out.println("sem produtos");
           return;
       }
        System.out.println("Produtos: ");
       for(Produto p : this.produtos){
           System.out.println(p.getNome());

       }
    }

    public boolean remover(String codigo) {
        Produto p = this.buscarPorCodigo(codigo);
        if (p != null) {
            this.produtos.remove(p);
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizar(Produto produto) {
        for(int i = 0; i < this.produtos.size(); ++i) {
            if (((Produto)this.produtos.get(i)).getCodigo().equals(produto.getCodigo())) {
                this.produtos.set(i, produto);
                return true;
            }
        }

        return false;
    }
}
