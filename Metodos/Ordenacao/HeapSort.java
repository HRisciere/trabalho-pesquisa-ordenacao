package Metodos.Ordenacao;

import java.util.ArrayList;
import Metodos.Infracao;

/**
 * Classe responsavel por conter metodos para manipulacao de ArrayList visando a aplicacao do
 * metodo de ordenacao HeapSort
 */
public class HeapSort {
    private int quant;
    private ArrayList<Infracao> vetor;

    /**
     *
     * @param vetor - ArrayList contendo as infracoes a serem ordenadas
     */
    public HeapSort(ArrayList<Infracao> vetor) {
        this.quant = vetor.size();
        this.vetor = vetor;
    }

    /**
     * Responsavel por executar o metodo de ordenacao heapSort, manipulando a ArrayList
     * propria do objeto instanciado
     */
    public void heapSort() {
        int dir = this.quant - 1;
        int esq = (dir - 1) / 2;
        Infracao temp;

        //Realiza a primeira Heap

        while (esq >= 0) {
            refazHeap(esq, this.quant - 1);
            esq--;
        }

        while (dir > 0) {

            //Troca o primeiro elemento da heap com o ultimo visivel

            temp = this.vetor.get(0);
            this.vetor.set(0, this.vetor.get(dir));
            this.vetor.set(dir, temp);

            //Refaz a heap ate o subvetor nao ter mais elementos

            dir--;
            refazHeap(0, dir);
        }
    }

    /**
     * Responsavel por refazer a heap, garantindo que em cada 'no' permaneca a chave com
     * maior valor entre o 'no' e seus filhos
     * @param esq posicao inicial do vetor ou subvetor
     * @param dir posicao final do vetor ou subvetor
     */
    private void refazHeap(int esq, int dir) {
        int i = esq;
        int mF = 2 * i + 1; //Maior filho
        Infracao raiz = this.vetor.get(i);
        boolean heap = false;

        while ((mF <= dir) && (!heap)) {

            //Procura a folha com menor precedencia dentre os filhos da raiz

            if (mF < dir)

                if (this.vetor.get(mF).compareTo(this.vetor.get(mF + 1)) < 0)
                    mF++;

            /*Verifica se a infracao que esta na raiz tem precedencia a infracao
            da folha com menor precedencia*/

            if (raiz.compareTo(this.vetor.get(mF)) < 0) {

                //Realiza a troca entre a infracao da raiz e a da folha

                this.vetor.set(i, this.vetor.get(mF));

                /*Se posiciona na folha da infracao menor precedencia para verificar se a
                * sub-arvore dela deixou de ser heap*/

                i = mF;
                mF = 2 * i + 1;
            } else

                heap = true;
        }

        this.vetor.set(i, raiz);
    }

    public ArrayList<Infracao> getVetor() {
        return vetor;
    }

    public void setVetor(ArrayList<Infracao> vetor) {
        this.vetor = vetor;
        this.quant = vetor.size();
    }

}
