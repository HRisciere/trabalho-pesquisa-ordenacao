package Metodos.Pesquisa.Nos;

import Metodos.Infracao;

/**
 * Classe responsavel por representar um no de uma arvore AVL, contendo os atributos
 * e metodos necessarios para sua manipulacao e utilizacao na construcao da arvore AVL
 */
public class NoAvl extends No{
    private int fatorBalanceamento;
    private NoAvl esq, dir;

    /**
     *
     * @param infracao Objeto da classe infracao que ira 'identificar' o no
     */
    public NoAvl (Infracao infracao) {
        super(infracao);
        this.fatorBalanceamento = 0;
        this.esq = null;
        this.dir = null;
    }

    public int getFatorBalanceamento() {
        return fatorBalanceamento;
    }

    public void setFatorBalanceamento(int fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public NoAvl getEsq() {
        return esq;
    }

    public void setEsq(NoAvl esq) {
        this.esq = esq;
    }

    public NoAvl getDir() {
        return dir;
    }

    public void setDir(NoAvl dir) {
        this.dir = dir;
    }
}
