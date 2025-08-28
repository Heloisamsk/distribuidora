package negocio;

import dados.RepositorioProduto;

public class Estoque {

    private RepositorioProduto repositorio;

    public Estoque(RepositorioProduto repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrarProduto(Produto produto) {
        repositorio.cadastrarProduto(produto);
        System.out.println("Produto cadastrado: " + produto.getNome());
    }

    public Produto consultarProduto(String codigo) {
        return repositorio.buscarPorCodigo(codigo);
    }

    public void listarProdutos() {
        System.out.println(">>> Estoque Atual <<<");
        for (Produto p : repositorio.listarTodos()) {
            System.out.println(p.getNome() + " | Código: " + p.getCodigo() + " | Quantidade: " + p.getQuantidade());
        }
    }

    public void atualizarProduto(Produto produto) {
        repositorio.atualizar(produto);
    }

    public void removerProduto(String codigo) {
        repositorio.remover(codigo);
    }
}