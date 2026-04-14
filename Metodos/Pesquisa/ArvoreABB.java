package Metodos.Pesquisa;

import Metodos.Infracao;
import Metodos.Pesquisa.Nos.NoABB;

import java.util.ArrayList;

/**
 * Classe responsavel por representar uma arvore binaria de busca (ABB),
 * com os metodos para inserir e buscar elementos.
 */
public class ArvoreABB {
    private NoABB raiz;
    private int quant;

    // Construtor da arvore
    public ArvoreABB() {
        this.raiz = null;
        this.quant = 0;
    }

    public int getQuant() {
        return quant;
    }

    /**
     * Metodo publico para inserir uma infracao na arvore.
     * @param infracao A infracao a ser inserida.
     */
    public void inserir(Infracao infracao) {
        this.raiz = inserir(infracao, this.raiz);
    }

    /**
     * Metodo privado para inserir uma infracao em um no da árvore.
     * @param infracao A infracao a ser inserida.
     * @param no O nó onde a inserção será realizada.
     * @return O nó atualizado após a inserção.
     */
    private NoABB inserir(Infracao infracao, NoABB no) {

        // Se o nó atual for nulo, criamos um novo nó com a infracao

        if (no == null) {
            this.quant += 1;
            return new NoABB(infracao);
        }

        //Verifica se a placa da infracao e a placa das infracoes do no sao iguais
        //Se sao iguais, insere a infracao na lista de infracoes do no

        if (infracao.getPlaca().equalsIgnoreCase(no.getListaInfracao().get(0).getPlaca())){
            this.quant += 1;
            no.adicionarElemento(infracao);
        }
        else{
            // Comparar a placa da infracao com a do no atual

            int comparacao = infracao.compareTo(no.getListaInfracao().get(0));

            // Se a placa da infracao for menor, vai para a subarvore esquerda

            if (comparacao < 0) {
                no.setEsq(inserir(infracao, no.getEsq()));
            }
            // Se a placa da infracao for maior, vai para a subarvore direita

            else{
                no.setDir(inserir(infracao, no.getDir()));
            }
        }
        return no;
    }

    /**
     * Realiza a chamada do metodo responsavel por realizar o caminhamento central na
     * arvore ABB
     * @return Uma Arraylist de Infracao contendo o resultado do caminhamento central
     */
    public ArrayList<Infracao> CamCentral () {
        ArrayList<Infracao> listaInfracoes = new ArrayList<>(quant);
        return (fazCamCentral(this.raiz, listaInfracoes));
    }

    /**
     * Realiza o caminhamento central na arvore, guardando cada infracao do no acessado em
     * um vetor
     * @param no No sera iniciado o caminhamento central na arvore
     * @param listaInfracoes Arraylist onde as infracoes dos nos acessados serao guardados
     * @return Arraylist de Infracao contendo as infracoes dos nos acessados
     */
    private ArrayList<Infracao> fazCamCentral (NoABB no,
                                               ArrayList<Infracao> listaInfracoes) {
        if (no != null) {
            listaInfracoes = this.fazCamCentral((NoABB) no.getEsq(), listaInfracoes);
            listaInfracoes.addAll(no.getListaInfracao());
            listaInfracoes = this.fazCamCentral((NoABB) no.getDir(), listaInfracoes);
        }
        return listaInfracoes;
    }

    /**
     * Realiza a chamada do metodo responsavel pelo balanceamento da arvore
     * @return A arvore ABB resultante do processo de balanceamento
     */
    public ArvoreABB balancear () {
        ArvoreABB arvoreBalanceada = new ArvoreABB();
        ArrayList<Infracao> listaInfracoes = CamCentral();
        balancear (listaInfracoes, arvoreBalanceada, 0, quant-1);
        return arvoreBalanceada;
    }

    /**
     * Realiza o processo de balanceamento a partir da ArrayList resultante do
     * caminhamento central da ArvoreABB
     * @param listaInfracoes ArrayList contendo o resultado do caminhamento central
     * @param arvoreBalanceada Nova ArvoreABB que guardara o resultado do balanceamento
     * @param inicio Index do vetor onde sera considerado o inicio do balanceamento da
     *               chamada
     * @param fim Index do vetor onde sera considerado o fim do balanceamento da chamada
     */
    private void balancear (ArrayList<Infracao> listaInfracoes, ArvoreABB arvoreBalanceada,
                            int inicio, int fim) {
        int meio;
        if (inicio <= fim) {

            //Calcula o elemento do meio do vetor e insere na arvore

            meio = (inicio+fim)/2;
            arvoreBalanceada.inserir(listaInfracoes.get(meio));

            //Realiza o processo de balanceamento no subvetor a esquerda

            balancear (listaInfracoes, arvoreBalanceada, inicio, meio-1);

            //Realiza o processo de balanceamento no subvetor a direita

            balancear(listaInfracoes, arvoreBalanceada, meio+1, fim);
        }
    }
    /**
     * Metodo para buscar infracoes na arvore com base na placa.
     * @param placa A placa a ser pesquisada.
     * @return A lista de infracoes associadas a essa placa, ou null se não encontrado.
     */
    public ArrayList<Infracao> pesquisa(String placa) {
        return pesquisa(placa, this.raiz);
    }

    /**
     * Metodo recursivo para buscar infracoes na arvore com base na placa.
     * @param placa A placa a ser pesquisada.
     * @param no O no onde a pesquisa sera realizada.
     * @return A lista de infracoes associadas a essa placa, ou null se nao encontrado.
     */
    private ArrayList<Infracao> pesquisa(String placa, NoABB no) {

        // Se o no for nulo, a placa nao esta em nenhuma infracao da arvore

        if (no == null) {
            return null;
        }

        // Se a placa for igual a do no, retorna a lista de infracoes

        if (no.getListaInfracao().get(0).getPlaca().equalsIgnoreCase(placa)) {
            return no.getListaInfracao();
        }

        // Se a placa for menor, vai para a subárvore esquerda

        if (placa.compareToIgnoreCase(no.getListaInfracao().get(0).getPlaca()) < 0) {
            return pesquisa(placa, no.getEsq());
        }

        // Se a placa for maior, vai para a subárvore direita

        else {
            return pesquisa(placa, no.getDir());
        }
    }
}