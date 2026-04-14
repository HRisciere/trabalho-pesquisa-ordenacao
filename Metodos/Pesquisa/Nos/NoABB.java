package Metodos.Pesquisa.Nos;

import Metodos.Infracao;

/**
 * Classe responsavel por representar um no de uma arvore ABB, contendo os atributos
 * e metodos necessarios para sua manipulacao e utilizacao na construcao da arvore ABB
 */
public class NoABB extends No{
    private NoABB esq, dir;

    /**
     * @param infracao Objeto da classe infracao que ira 'identificar' o no
     */
    public NoABB(Infracao infracao) {
        super(infracao);
        this.esq = null;
        this.dir = null;
    }

    public NoABB getEsq() {
        return esq;
    }

    public void setEsq(NoABB esq) {
        this.esq = esq;
    }

    public NoABB getDir() {
        return dir;
    }

    public void setDir(NoABB dir) {
        this.dir = dir;
    }
}
