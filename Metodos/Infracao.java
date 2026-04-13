package Metodos;

import java.util.*;

/**
 * Classe responsavel por armazenar os dados dos registros de infracao,
 * disponibilizando metodos para a manipulacao desses dados, alem da comporacao com
 * outros registros
 */
public class Infracao implements Comparable<Infracao> {
    private String placa;
    private String proprietarioVeiculo;
    private String local;
    private Calendar dataHora;

    //Metodo construtor da classe Infracao

    /**
     *
     * @param placa String contendo a placa do veiculo da infracao
     * @param proprietarioVeiculo String contendo o nome do proprietario do veiculo
     * @param local String contendo o endereco do local onde ocorreu a infracao
     * @param dataHora Instancia da classe Calendar configurada com os elementos de
     *                 data(Dia, mes e ano) e horario(Hora, minuto, segundos) da infracao
     */
    public Infracao(String placa, String proprietarioVeiculo,
                    String local, Calendar dataHora) {
        this.placa = placa;
        this.proprietarioVeiculo = proprietarioVeiculo;
        this.local = local;
        this.dataHora = dataHora;
    }

    //Metodos getters e setters dos atributos da classe Infracao

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getProprietarioVeiculo() {
        return proprietarioVeiculo;
    }

    public void setProprietarioVeiculo(String proprietarioVeiculo) {
        this.proprietarioVeiculo = proprietarioVeiculo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    //Metodo toString para escrita em arquivos

    /**
     *
     * @return Retorna String contendo as informacoes do objeto no formato:
     * 'placa;nome;local;data(formato dd/mm/aaaa);horario(formato hh:mm:ss)'
     */
    @Override
    public String toString() {
        return String.format("%s;%s;%s;%02d/%02d/%d;%02d:%02d", this.getPlaca(),
                this.getProprietarioVeiculo(), this.getLocal(),
                this.getDataHora().get(Calendar.DAY_OF_MONTH),
                this.getDataHora().get(Calendar.MONTH) + 1,
                this.getDataHora().get(Calendar.YEAR),
                this.getDataHora().get(Calendar.HOUR_OF_DAY),
                this.getDataHora().get(Calendar.MINUTE));
    }

    /*Sobrescrita do metodo comparteTo da interface Comparable para facilitar a ordenacao
    * e comparacao entre objetos*/

    /**
     *
     * @param infracao Outro objeto da classe infracao para ser comparado.
     * @return Retorna um valor menor ou igual a -1 caso o objeto que realiza a chamada
     * do metodo tenha precedencia ao objeto comparado, caso contrario retorna 1 ou maior
     */
    @Override
    public int compareTo(Infracao infracao) {

        /*Verifica se o atributo placa de ambos os objetos são iguais, caso seja, faz a
        * comparacao de precedencia entre a data e o horario do atributo dataHora,
        * do contrario compara a precedencia entre os atributos placas*/

        if (this.getPlaca().equalsIgnoreCase(infracao.getPlaca())){

            /*Realiza inversao do valor retornado do compareTo entre os atributos
            dataHora dos objetos, para garantir que a data mais
            recente tenha prioridade de precedencia, e retorna o valor*/

            return this.getDataHora().compareTo(infracao.getDataHora());
        }
        else {

            //Retorna o valor do compareTo entre os atributos placa dos objetos

            return this.getPlaca().compareToIgnoreCase(infracao.getPlaca());
        }
    }

}


