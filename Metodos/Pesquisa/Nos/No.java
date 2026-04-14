package Metodos.Pesquisa.Nos;

import Metodos.Infracao;

import java.util.ArrayList;


/**
 * Responsavel por representar um no generico contendo os dados e
 * metodos necessarios para sua manipulacao e implementacao em outras classes
 */
public abstract class No {
    private ArrayList<Infracao> listaInfracao;


    /**
     *
     * @param infracao Objeto da classe infracao que ira 'identificar' o no
     */
    public No(Infracao infracao) {
        this.listaInfracao = new ArrayList<>(10);
        this.listaInfracao.add(infracao);
    }

    //Metodo para caso a infracao a ser inserida ja tenha a placa repetida em um no existente

    /**
     * Responsavel por inserir uma infracao em um no ja existente, mantendo a ordem dentro
     * do vetor, sendo o primeiro elemento o mais antigo, enquanto o ultimo o mais recente
     * @param infracao Objeto da classe infracao a ser inserido no Arraylist do no
     */
    public void adicionarElemento(Infracao infracao){

        //Cria uma variavel para guardar o index onde sera inserido a infracao
        int index = 0;

        /*Percorre a ArrayList enquanto a infracao a ser inserida for mais recente que a data
         * da infracao da posicao que esta sendo acessada*/

        while(index < this.listaInfracao.size() &&
                infracao.compareTo(this.listaInfracao.get(index)) > 0){
            index += 1;
        }

        /*Insere na posicao onde todas as infracoes a sua direita sao mais recentes e todas
         * aquelas a esqueda sao mais antigas do que a infracao inserida*/

        this.listaInfracao.add(index, infracao);
    }

    public ArrayList<Infracao> getListaInfracao() {
        return listaInfracao;
    }

    public void setListaInfracao(ArrayList<Infracao> listaInfracao) {
        this.listaInfracao = listaInfracao;
    }


}
