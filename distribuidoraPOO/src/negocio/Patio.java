package negocio;
import java.util.ArrayList;

public class Patio {
    protected ArrayList<Caminhao> caminhoesPatioLista;
    private ArrayList<Caminhao> filaEntrada;
    private ArrayList<Caminhao> filaSaida;
    private int vagasDisponiveis;
    private int qtdVagas ;

    public Patio( int vagasDisponiveis, int qtdVagas) {
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.vagasDisponiveis = vagasDisponiveis;
        this.caminhoesPatioLista = new ArrayList<>();
        this.qtdVagas = qtdVagas;
    }
    public Patio(){
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.caminhoesPatioLista = new ArrayList<>();
    }
    public Patio(int qtdVagas){
        this.qtdVagas = qtdVagas;
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.caminhoesPatioLista = new ArrayList<>();
    }

    public ArrayList<Caminhao> getFilaEntrada() {
        return filaEntrada;
    }

    public void setFilaEntrada(ArrayList<Caminhao> filaEntrada) {
        this.filaEntrada = filaEntrada;
    }

    public ArrayList<Caminhao> getFilaSaida() {
        return filaSaida;
    }

    public void setFilaSaida(ArrayList<Caminhao> filaSaida) {
        this.filaSaida = filaSaida;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Patio{" +
                "filaEntrada=" + filaEntrada +
                ", filaSaida=" + filaSaida +
                ", vagasDisponiveis=" + vagasDisponiveis +
                '}';
    }

    public boolean adicionarCaminhao(Caminhao caminhao){
        if(caminhao == null){
            throw new IllegalArgumentException("O caminhao informado eh nulo");
        }
        vagasDisponiveis = qtdVagas;
        if(caminhoesPatioLista.size() < vagasDisponiveis){
            caminhoesPatioLista.add(caminhao);
            //System.out.println("Caminhao adicionado - " + caminhao.getPlaca());
            vagasDisponiveis--;
            return true;
        }else{
            //System.out.println("O patio esta cheio aguarde na fila.");
            filaEntrada.add(caminhao);
            return false;
        }

    }

    public boolean removerCaminhao(Caminhao caminhao){
        if(caminhao == null){
            throw new IllegalArgumentException("Caminhao informado eh nulo");
        }
        if(caminhoesPatioLista.contains(caminhao)){
            caminhoesPatioLista.remove(caminhao);
            filaSaida.add(caminhao);
            vagasDisponiveis++;
            System.out.println("Caminhao placa: " + caminhao.getPlaca() + "esta na fila de saida do patio ou saiu do patio");
            return true;
        }
        else{
            throw new IllegalArgumentException("O caminhao placa:" + caminhao.getPlaca() + "nao esta no patio");
        }
    }

    public void listarCaminhoes(){
        System.out.println("caminhoes no patio: ");
        for(Caminhao caminhao : caminhoesPatioLista){
            System.out.println("-" + caminhao);
        }

    }
    public void listarFilas(){
        if (filaEntrada == null || filaEntrada.isEmpty()){
            System.out.println("A fila de entrada do patio esta vazia.");
        }else{
            System.out.println("FILA DE ENTRADA DE CAMINHOES: ");
            for(Caminhao caminhao : filaEntrada){
                System.out.println("-" + caminhao);
            }
        }
        if(filaSaida == null || filaSaida.isEmpty()){
            System.out.println("A fila de saida do patio esta vazia.");
        }else{
            System.out.println("FILA DE SAIDA DE CAMINHOES");
            for(Caminhao caminhao : filaSaida){
                System.out.println("-" + caminhao);

            }
        }
    }

    public ArrayList<Caminhao> getCaminhoesPatioLista() {
        return caminhoesPatioLista;
    }


}