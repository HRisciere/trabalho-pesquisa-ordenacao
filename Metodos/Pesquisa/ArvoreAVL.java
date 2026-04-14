package Metodos.Pesquisa;

import Metodos.Infracao;
import Metodos.Pesquisa.Nos.NoAvl;


import java.util.ArrayList;

/**
 * Responsavel por representar uma arvore AVL, contendo os atributos e metodos necessarios
 * para sua manipulacao, tal como a insercao de nos e reordenacao dinamica a cada insercao
 */
public class ArvoreAVL {
    private NoAvl raiz;
    private boolean h;

    public ArvoreAVL() {
        this.raiz = null;
    }

    //Metodo publico para insercao de infracoes na Arvore AVL

    /**
     * Responsavel por chamar o metodo que realiza a insercao da infracao, garantindo que
     * inicie o percusso na arvore AVL atraves da raiz
     * @param infracao objeto da classe Infracao a ser adicionado na arvore AVL
     */
    public void inserir( Infracao infracao){
        this.raiz =
                this.inserir (infracao,
                        this.raiz);
    }

    /*Metodo privado para insercao de infracoes na Arvore AVL, garantindo o
    funciomaneto da logica da classe
    */

    /**
     * Responsavel por inserir um novo objeto da classe Infracao na arvore AVL
     * @param infracao Objeto da classe Infracao a ser adicionado na arvore AVL
     * @param noAvl NoAVL do qual sera iniciado o trajeto para poder inserir a nova
     *              infracao na arvore AVL
     * @return Um novo NoAVL, caso a placa da infracao ja nao tenha sido inserida, ou
     * um noAVL existente
     */
    private NoAvl inserir (Infracao infracao, NoAvl noAvl){

        //Caso nao haja um no filho na direcao acessada ou a arvore esteja vazia

        if (noAvl == null){

            //cria-se um novo noAVL a partir da infracao inserida

            NoAvl novo = new NoAvl(infracao);

            //Flag informando a necessidade de realizar as operacoes de balanceamento

            this.h = true;

            //Retorna o no para ser o filho do no anteriormente acessado ou a raiz da arvore

            return novo;
        } else {

            //Caso a placa da nova infracao ja tenha sido cadastrada

            if (noAvl.getListaInfracao().getFirst().getPlaca().equalsIgnoreCase(infracao.getPlaca())){

                //Insere a infracao na ArrayList do noAVL, mantendo a ordenacao na ArratList

                noAvl.adicionarElemento(infracao);

                //Flag indicando que nao ha necessidade de realizar operacao de balanceamento

                this.h = false;

                //Retorna o no ja existente

                return noAvl;
            } else {

                //Caso a placa da infracao a ser inserida tenha precedencia a placa do no visitado

                if (infracao.compareTo(noAvl.getListaInfracao().getFirst()) < 0) {

                    //Caminha para esquerda do no visitado, mantendo a ligacao entre os nos

                    noAvl.setEsq(this.inserir(infracao, noAvl.getEsq()));

                    //Realiza as operecoes de balanceamento necessarias no no

                    noAvl = this.balancearEsq(noAvl);

                    //Retorna o no existente

                    return noAvl;

                //Caso a placa do no visitado tenha precedencia alfabetica ao no da infracao

                } else {

                    //Caminha para a direito do no visitado, mantendo a ligacao entre os nos

                    noAvl.setDir(this.inserir(infracao, noAvl.getDir()));

                    //Realiza as operecoes de balanceamento necessarias no no

                    noAvl = this.balancearDir(noAvl);

                    //Retorno o no existente

                    return noAvl;
                }
            }
        }
    }

    //Metodo para baleancear o no quando for inserido um novo item na sua sub-arvore esquerda

    /**
     * Reponsavel por balancear o no quando tiver um novo no inserido na
     * sua sub-arvore esquerda
     * @param no noAVL a ser balanceado
     * @return noAVL apos o processo de balanceamento e, caso necessario, rotacao
     */
    private NoAvl balancearEsq(NoAvl no) {

        //Caso a flag informando a necessidade de balanceamento esteja definida como true

        if (this.h) {
            switch (no.getFatorBalanceamento()){

                //Subtrai 1 do fator de balanceamento do no por ter insercao a sua esquerda

                case 1 : no.setFatorBalanceamento(0);

                    //Flag informando a falta de necessidade de balanceamento para os nos pais

                    this.h = false;
                    break;
                case 0 : no.setFatorBalanceamento(-1); break;

                //Caso a diferenca entre as alturas das sub-arvores do no seja maior do que 1

                case -1: no = this.rotacaoDireita (no);
            }
        }

        //Retorna o no apos processo de balanceamento e, se necessario, rotacao

        return no;
    }

    //Metodo para baleancear o no quando for inserido um novo item na sua sub-arvore direita

    /**
     * Reponsavel por balancear o no quando tiver um novo no inserido na
     * sua sub-arvore direita
     * @param no noAVL a ser balanceado
     * @return noAVL apos o processo de balanceamento e, caso necessario, rotacao
     */
    private NoAvl balancearDir(NoAvl no) {

        //Caso a flag informando a necessidade de balanceamento esteja definida como true

        if (this.h) {
            switch (no.getFatorBalanceamento()){

                //Adiciona 1 do fator de balanceamento do no por ter insercao a sua direita

                case -1: no.setFatorBalanceamento(0);

                    //Flag informando a falta de necessidade de balanceamento para os nos pais

                    this.h = false;
                    break;
                case 0: no.setFatorBalanceamento(1); break;

                //Caso a diferenca entre as alturas das sub-arvores do no seja maior do que 1

                case 1: no = this.rotacaoEsquerda (no);
            }
        }

        //Retorna o no apos processo de balanceamento e, se necessario, rotacao

        return no;
    }

    //Metodo para fazer a organizacao dinamica da arvore quando inserido na subarvore direita

    /**
     * Responsavel por fazer a rotacao a esquerda de um no, garantindo que todos os filhos
     * dos nos envolvidos nao se percam e continuem conectado a arvore
     * @param no NoAVL que deve sofrer o processo de rotacao para manter o fator de
     *           balanceamento dentro dos limites
     * @return Um noAVL apos o processo de rotacao
     */
    private NoAvl rotacaoEsquerda(NoAvl no) {
        NoAvl temp1, temp2;
        temp1 = no.getDir();

        //Rotacao simples a esquerda

        if (temp1.getFatorBalanceamento() == 1){

            //Conecta a sub-arvore esquerda do no filho a sub-arvore diteita do no pai

            no.setDir(temp1.getEsq());
            temp1.setEsq(no);

            //Muda balanceamento do no pai e muda ele para o no filho

            no.setFatorBalanceamento(0);
            no = temp1;
        }

        //Rotacao dupla a esquerda

        else{
            temp2 = temp1.getEsq();

            //Conecta a sub-arvore direita do no neto a sub-arvore esquerda do no filho

            temp1.setEsq(temp2.getDir());
            temp2.setDir(temp1);

            //Conencta a sub-arvore esquerta do no neto a sub-arvore direita do no pai

            no.setDir(temp2.getEsq());
            temp2.setEsq(no);

            //Muda o fator dos no pai e filho dependendo do fator de balancemaneoto do no neto

            if (temp2.getFatorBalanceamento() == 1){
                no.setFatorBalanceamento(-1);
            } else{
                no.setFatorBalanceamento(0);
            }

            if (temp2.getFatorBalanceamento() == -1){
                temp1.setFatorBalanceamento(1);
            } else{
                temp1.setFatorBalanceamento(0);
            }

            //Muda o no pai para o no neto

            no = temp2;
        }

        //Muda balanceamento do no para 0

        no.setFatorBalanceamento(0);

        //Muda a flag H indicando que nao necessidade de fazer balanceamento com os nos anteriores

        this.h = false;

        //Retorna o no apos o processo de rotacao

        return no;
    }

    //Metodo para fazer a organizacao dinamica da arvore quando inserido na subarvore esquerda

    /**
     * Responsavel por fazer a rotacao a direita de um no, garantindo que todos os filhos
     * dos nos envolvidos nao se percam e continuem conectado a arvore
     * @param no NoAVL que deve sofrer o processo de rotacao para manter o fator de
     *           balanceamento dentro dos limites
     * @return Um noAVL apos o processo de rotacao
     */
    private NoAvl rotacaoDireita(NoAvl no) {
        NoAvl temp1, temp2;
        temp1 = no.getEsq();

        //Rotação Simples

        if (temp1.getFatorBalanceamento() == -1){

            //Conecta a sub-arvore direita do no filho a sub-arvore esquerda do no pai

            no.setEsq(temp1.getDir());
            temp1.setDir(no);

            //Muda balanceamento do no pai e muda ele para o no filho

            no.setFatorBalanceamento(0);
            no = temp1;
        }

        //Rotacao Dupla

        else {

            temp2 = temp1.getDir();

            //Conecta a sub-arvore esquerda do no neto a sub-arvore direita do no filho

            temp1.setDir(temp2.getEsq());
            temp2.setEsq(temp1);

            //Conecta a sub-arvore direita do no neto a sub-arvore esquerda do no pai

            no.setEsq(temp2.getDir());
            temp2.setDir(no);

            //Muda o fator dos no pai e filho dependendo do fator de balancemaneoto do no neto

            if (temp2.getFatorBalanceamento() == -1)
                no.setFatorBalanceamento(1);
            else
                no.setFatorBalanceamento(0);

            if (temp2.getFatorBalanceamento() == 1)
                temp1.setFatorBalanceamento(-1);
            else
                temp1.setFatorBalanceamento(0);

            //Muda o no pai para o no neto

            no = temp2;
        }

        //Muda balanceamento do no para 0

        no.setFatorBalanceamento(0);

        //Muda a flag H indicando que nao necessidade de fazer balanceamento com os nos anteriores

        this.h = false;

        //Retorna o no apos o processo de rotacao

        return no;
    }

    //Metodo publico que realiza o chamado do metodo de pesquisa, garantindo a logica do programa

    /**
     * Responsavel por chamar o metodo que realiza a pesquisa, garantindo que se inicie na
     * rai da arvore
     * @param placa String contendo a placa a ser pesquisada
     * @return ArrayList contendo as infracoes com aquela placa ou null caso nao exista
     */
    public ArrayList<Infracao> pesquisa(String placa){
        return pesquisa(placa, this.raiz);
    }

    //Metodo que realiza a pesquisa da placa na arvore AVL

    /**
     * Responsavel por realizar a pesquisa na arvore AVL, percorrendo a mesma em busca da
     * placa passada
     * @param placa String contendo a placa a ser pesquisada
     * @param noAvl noAVL em que sera iniciado a pesquisa
     * @return ArrayList contendo as infracoes com aquela placa ou null caso nao exista
     */
    private ArrayList<Infracao> pesquisa(String placa, NoAvl noAvl){

        //Caso a placa passada nao esteja presente em nenhuma infracao da Arvore AVL

        if (noAvl == null){
            return null;
        } else{

            //Caso a placa passada esteja presente no ArrayList de infracao do no

            if (noAvl.getListaInfracao().getFirst().getPlaca().equalsIgnoreCase(placa)){
                return noAvl.getListaInfracao();
            }

            /*Caso a placa passada tenha precedencia alfabetica comparada a placa
            das infracoes do no*/

            if (noAvl.getListaInfracao().getFirst().getPlaca().compareToIgnoreCase(placa) > 0)
                return pesquisa(placa, noAvl.getEsq());

            /*Caso a placa das infracoes do no tenha precedencia alfabetica comparada a
            placa passada*/

            else{
                return pesquisa(placa, noAvl.getDir());
            }
        }
    }
}
