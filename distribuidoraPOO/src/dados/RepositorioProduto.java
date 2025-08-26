/*package dados;

import negocio.Produto;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class RepositorioProduto implements IRepositorioProduto {
    private static final String ARQUIVO = "produtos.csv";

    @Override
    public void cadastrarProduto(Produto produto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            bw.write(produto.getCodigo() + "," +
                    produto.getNome() + "," +
                    produto.getDescricao() + "," +
                    produto.getPreco() + "," +
                    produto.getQuantidade());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Produto> listarTodos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");

                String codigo = partes[0];
                String nome = partes[1];
                String descricao = partes[2];
                double preco = Double.parseDouble(partes[3]);
                int quantidade = Integer.parseInt(partes[4]);

                produtos.add(new Produto(codigo, nome, descricao, preco, quantidade));
            }
        } catch (IOException e) {
        }
        return produtos;
    }
    @Override
    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : listarTodos()) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
    @Override
    public void remover(String codigo) {
        List<Produto> produtos = listarTodos();
        produtos.removeIf(p -> p.getCodigo().equalsIgnoreCase(codigo));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Produto p : produtos) {
                bw.write(p.getCodigo() + "," +
                        p.getNome() + "," +
                        p.getDescricao() + "," +
                        p.getPreco() + "," +
                        p.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void atualizar(Produto produtoAtualizado) {
        List<Produto> produtos = listarTodos();

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equalsIgnoreCase(produtoAtualizado.getCodigo())) {
                produtos.set(i, produtoAtualizado);
                break;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Produto p : produtos) {
                bw.write(p.getCodigo() + "," +
                        p.getNome() + "," +
                        p.getDescricao() + "," +
                        p.getPreco() + "," +
                        p.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 */