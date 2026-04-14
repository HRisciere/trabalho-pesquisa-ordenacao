import Metodos.Infracao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Responsavel por conter metodos uteis para leitura e escrita de arquivos, baseado em
 * ArrayList para guardar os registros retirados do arquivo ou inserir no arquivo
 * os registros
 */
public class Util {

    /**
     * Realiza a leitura do arquivo contendo os registros das infracoes, utilizando os dados
     * dos registros para criar objetos da classe Infracao e guardar em um ArrayList
     * @param caminho String contendo o caminho para o arquivo a ser lido
     * @param lista ArrayList no qual será guardado os objetos Infracao contendo os dados do
     *              registro
     */
    public static void preencherListaInfracao(String caminho, ArrayList<Infracao> lista) {
        try {

            //Cria um objeto da classe FileRead contendo o caminho do arquivo a ser lido

            FileReader arquivo = new FileReader(caminho);

            //Cria um objeto da classe Scanner para leitura do arquivo

            Scanner leitorArquivo = new Scanner(arquivo);

            try {

                while(leitorArquivo.hasNext()){

                    //Cria uma variavel responsavel por guardar a linha lida

                    String registro = leitorArquivo.nextLine();

                    /*Separa os elementos do registro e guarda em um vetor
                    * Formato [placa,nome,local,data(formato dd/mm/aaaa),
                    * horario(formato hh:mm:ss)]*/

                    String[] elementosRegistro = registro.split(";");

                    /*Guarda em um objeto Infracao os dados extraidos do registro atraves do
                    * metodo extrairDadosRegistro*/

                    Infracao infracao = extrairDadosRegistro(elementosRegistro);

                    //Adiciona o objeto criado na ArrayList

                    lista.add(infracao);
                }

                //Fecha as variaveis anteriormente criadas

                leitorArquivo.close();
                arquivo.close();

                //Captura e lanca uma excecao caso ocorra erro durante a leitura do arquivo

                } catch (IOException erro) {
                throw new RuntimeException("Erro na leitura do arquivo: " + erro);
            }

        //Captura e lanca uma excecao caso ocorra erro para encontrar o arquivo

        } catch (FileNotFoundException erro) {
            throw new RuntimeException("Erro ao buscar arquivo: " + erro);
        }
    }

    /**
     * Realiza a leitura do arquivo contendo as placas a serem pesquisadas e guarda em uma
     * ArrayList passada
     * @param caminho String contendo o mainho do arquivo contendo as placas
     * @param lista ArrayList no qual as placas devem ser guardadas
     */
    public static void preencherListaPlaca(String caminho, ArrayList<String> lista) {
        try {

            //Cria um objeto da classe FileRead contendo o caminho do arquivo a ser lido

            FileReader arquivo = new FileReader(caminho);

            //Cria um objeto da classe Scanner para leitura do arquivo

            Scanner leitorArquivo = new Scanner(arquivo);

            try {

                while(leitorArquivo.hasNext()){

                    //Cria uma variavel responsavel por guardar a linha lida

                    String placa = leitorArquivo.nextLine();

                    //Adiciona a placa lida na ArrayList

                    lista.add(placa);
                }

                //Fecha as variaveis anteriormente criadas

                leitorArquivo.close();
                arquivo.close();

                //Captura e lanca uma excecao caso ocorra erro durante a leitura do arquivo

            } catch (IOException erro) {
                throw new RuntimeException("Erro na leitura do arquivo: " + erro);
            }

            //Captura e lanca uma excecao caso ocorra erro para encontrar o arquivo

        } catch (FileNotFoundException erro) {
            throw new RuntimeException("Erro ao buscar arquivo: " + erro);
        }
    }

    /**
     * Realiza a extração dos dados da string, guardando em variaveis necessarias para
     * instanciar um objeto Infracao
     * @param elementosRegistro Vetor de String, no formato
     *                          [placa;nome;local;data(formato dd/mm/aaaa),
     *                          horario(formato hh:mm:ss)]
     *                          contendo os elementos do registro da infracao
     * @return Um objeto da classe Infracao
     */
    private static Infracao extrairDadosRegistro(String[] elementosRegistro) {

        /*Separa os elementos da data do vetor elementosRegistros e armazena em um vetor
        *Formato [dia,mes,ano]*/

        String[] elementosData = elementosRegistro[3].split("/");

        /*Separa os elementos do horario do vetor elementosRegistros e armazena em um vetor
         *Formato [hora,minuto]*/

        String[] elementosHorario = elementosRegistro[4].split(":");

        //Armazena as informacoes da placa, proprietario e local em variaveis proprias

        String placa = elementosRegistro[0];
        String proprietario = elementosRegistro[1];
        String local = elementosRegistro[2];

        //Guarda as informacoes de data(dia, mes e ano) em variaveis

        int dia = Integer.parseInt(elementosData[0]);
        int mes = Integer.parseInt(elementosData[1]);
        int ano = Integer.parseInt(elementosData[2]);

        //Guarda as informacoes de horario(hora e minuto) em variaveis

        int hora = Integer.parseInt(elementosHorario[0]);
        int minuto = Integer.parseInt(elementosHorario[1]);

        Calendar data_hora = Calendar.getInstance();

        //Configura as informacoes do objeto data_hora conforme os dados de data e horario

        data_hora.set(Calendar.DAY_OF_MONTH, dia);
        data_hora.set(Calendar.MONTH, mes - 1);
        data_hora.set(Calendar.YEAR, ano);
        data_hora.set(Calendar.HOUR_OF_DAY, hora);
        data_hora.set(Calendar.MINUTE, minuto);
        data_hora.set(Calendar.SECOND, 0);

        //Retorna a instanciacao de um objeto da classe Infracao

        return new Infracao(placa, proprietario, local, data_hora);
    }

    /**
     * Realiza a escrita dos registros presentes no ArrayList passado no arquivo descrito
     * no caminho
     * @param caminho String contendo o caminho do arquivo em serão escritos os registros
     * @param listaRegistros ArrayList contendo os registros a serem escritos no arquivo
     */
    public static void inserirRegistrosArquivo(String caminho, ArrayList<Infracao> listaRegistros) {
        try {

            //Cria um objeto da classe FileWrites contendo o caminho do arquivo a ser escrito

            FileWriter arquivo = new FileWriter(caminho);

            //Cria um objeto da classe PrintWrites para escrita do arquivo

            PrintWriter escritorArquivo = new PrintWriter(arquivo);

            //Percorre o Arraylist escrevendo os registros no arquivo

            for (Infracao registro : listaRegistros) {
                escritorArquivo.println(registro.toString());
            }

            //Fecha as variaveis criadas anteriormente

            escritorArquivo.close();
            arquivo.close();

        //Captura e lanca uma excecao caso ocorra erro durante a escrita do arquivo

        } catch (IOException erro) {
            throw new RuntimeException("Erro ao escrever arquivo: " + erro);
        }
    }

    /**
     * Realiza a escrita do resultado dos metodos de pesquisa em um formato padrao:<br>
     * Placa 'Placa':<br>
     * (Caso tenha multas registradas com a placa)<br>
     *      --> LOCAL 'local' DATA 'data' HORA 'hora'(Quantos registros houver)<br>
     *      --> TOTAL: 'Quantidade Multas' MULTAS<br>
     * (Caso nao tenha multas registradas com a placa)<br>
     *      --> NAO TEM MULTA
     *
     * @param caminho String contendo o caminho onde o arquivo sera escrito
     * @param listaPlacas ArrayList contendo as placas pesquisadas pelo metodo de pesquisa
     * @param listaInfracao Arraylist contendo Arraylist retornados pelo metodo de pesquisa
     */
    public static void inserirPesquisaArquivo(String caminho,
                                              ArrayList<String> listaPlacas,
                                              ArrayList<ArrayList<Infracao>> listaInfracao) {

        try {

            //Guarda em um objeto path o caminho onde devera ser inserido os registros


            //Cria um objeto da classe FileWrites contendo o caminho do arquivo a ser escrito

            FileWriter arquivo = new FileWriter(caminho);
            
            //Cria um objeto da classe PrintWrites para escrita do arquivo

            PrintWriter escritorArquivo = new PrintWriter(arquivo);

            //Cria variaveis para posteriormente construir o texto e linhas a serem escritas

            String texto;
            String linha;

            //Cria um looping para percorrer cada posicao da lista de placas e infracoes

            for (int index = 0; index < listaPlacas.size(); index++) {

                /*Constroi o texto a ser inserido no arquivo, baseado na ausência ou
                * existencia de infracoes para a placa pesquisada*/

                texto = "Placa " + listaPlacas.get(index) + ":\n";

                //Caso Nao haja infracao para a placa

                if (listaInfracao.get(index) == null){
                    linha = "Nao Tem Multa\n";
                    texto += linha;
                }

                //Caso haja infracao para a placa

                else{

                    /*Percorre a lista de infracoes da multa,
                    formatando os dados da infracao no formato desejado*/

                    for (Infracao infracao: listaInfracao.get(index)){
                         linha = String.format("LOCAL %s DATA %02d/%02d/%d HORA %02d:%02d\n",
                                 infracao.getLocal(),
                                 infracao.getDataHora().get(Calendar.DAY_OF_MONTH),
                                 infracao.getDataHora().get(Calendar.MONTH) + 1,
                                 infracao.getDataHora().get(Calendar.YEAR),
                                 infracao.getDataHora().get(Calendar.HOUR_OF_DAY),
                                 infracao.getDataHora().get(Calendar.MINUTE));
                         texto += linha;
                    }

                    linha = String.format("TOTAL: %d MULTAS\n", listaInfracao.get(index).size());
                    texto += linha;
                }

                //Escreve o texto construido no arquivo passado

                escritorArquivo.print(texto);
            }

            //Fecha as variaveis criadas anteriormente

            escritorArquivo.close();
            arquivo.close();

            //Captura e lanca uma excecao caso ocorra erro durante a escrita do arquivo

        } catch (IOException erro) {
            throw new RuntimeException("Erro ao escrever arquivo: " + erro);
        }
    }
}
