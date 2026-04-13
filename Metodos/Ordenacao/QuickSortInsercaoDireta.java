package Metodos.Ordenacao;

import Metodos.Infracao;

import java.util.ArrayList;

/**
 * Classe responsavel por conter metodos para manipulacao de uma ArrayList, visando a
 * aplicacao do metodo de ordenacao QuickSort em conjunto com o metodo de Insercao Direta
 */
public class QuickSortInsercaoDireta {
    private int quant;
    private ArrayList<Infracao> vetor;

    /**
     *
     * @param vetor ArrayList contendo as infracoes a serem ordenadas
     */
    public QuickSortInsercaoDireta(ArrayList<Infracao> vetor) {
        this.quant = vetor.size();
        this.vetor = vetor;
    }

    /**
     * Responsavel por realizar a chamada do metodo de ordenacao
     */
    public void QuickSortInsercaoDireta() {
        ordena(0, this.quant - 1);
    }


    /**
     * Responsavel pela ordenacao da ArrayList, simulando o metodo QuickSort para isso
     * @param esq primeiro indice do vetor
     * @param dir ultimo indice do vetor
     */
    private void ordena(int esq, int dir) {

        int i = esq;
        int j = dir;
        Infracao temp;

        //Calculo do pivo, para usar como referencia em relacao ao i e j
        //Lado esquerdo do pivo todos sao menores ou iguais
        //Lado direito do pivo todos sao maiores ou iguais

        Infracao pivo = this.vetor.get((esq + dir) / 2);

        do {

            //Compara o elemento do vetor i com o pivo
            //Se for menor do que o pivo, o i incrementa +1 e continua comparando
            // i anda para a direita

            while (this.vetor.get(i).compareTo(pivo) < 0)
                i++;

            //Compara o elemento do vetor j com o pivo
            //Se for maior do que o pivo, o j decrementa -1 e continua comparando
            // j anda para a esquerda

            while (this.vetor.get(j).compareTo(pivo) > 0)
                j--;

            //Se i estiver a esquerda ou for igual a j, ele troca de lugar

            if (i <= j) {
                temp = this.vetor.get(i);
                this.vetor.set(i, this.vetor.get(j));
                this.vetor.set(j, temp);
                i++;
                j--;
            }
        } while (i <= j);

        // Verificação antes da chamada recursiva: se a sublista tiver 20 elementos, usar Inserção Direta
        if (esq < j) {
            if (j - esq <= 20) {
                insercaoDireta(esq, j); // Chama Inserção Direta para sublistas pequenas
            } else {
                ordena(esq, j); // Chama recursivamente para a parte esquerda
            }
        }

        if (dir > i) {
            if (dir - i <= 20) {
                insercaoDireta(i, dir); // Chama Inserção Direta para sublistas pequenas
            } else {
                ordena(i, dir); // Chama recursivamente para a parte direita
            }
        }
    }

    /**
     * Agente que executa o metodo de ordenacao insercaoDireta
     * @param esq - primeiro indice do subvetor
     * @param dir - indice final do subvetor
     */
    private void insercaoDireta(int esq, int dir) {
        int i, j;
        Infracao temp;
        for (i = esq + 1; i <= dir; i++) {
            temp = vetor.get(i);
            j = i - 1;

            // Insere temp na posição correta do subvetor ordenado
            while (j >= esq && vetor.get(j).compareTo(temp) > 0) {
                vetor.set(j + 1, vetor.get(j));
                j--;
            }
            vetor.set(j + 1, temp);
        }
    }

    public ArrayList<Infracao> getVetor() {
        return vetor;
    }
}
