import Metodos.Infracao;
import Metodos.Ordenacao.HeapSort;
import Metodos.Ordenacao.QuickSort;
import Metodos.Ordenacao.QuickSortInsercaoDireta;
import Metodos.Pesquisa.ArvoreABB;
import Metodos.Pesquisa.ArvoreAVL;
import Metodos.Pesquisa.HashingEncadeado;

import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        //Instanciacao dos ArrayList que irao guardar as infracoes

        ArrayList<Infracao> lista1000 = new ArrayList<>(1000);

        ArrayList<Infracao> lista5000 = new ArrayList<>(5000);

        ArrayList<Infracao> lista10000 = new ArrayList<>(10000);

        ArrayList<Infracao> lista50000 = new ArrayList<>(50000);

        //Preenche um ArrayList com os caminhos dos arquivos contendo os registros

        ArrayList<String> listaCaminhos = new ArrayList<>(12);

        listaCaminhos.add("ArquivosTeste/multa1000inv.txt");
        listaCaminhos.add("ArquivosTeste/multa1000alea.txt");
        listaCaminhos.add("ArquivosTeste/multa1000ord.txt");

        listaCaminhos.add("ArquivosTeste/multa5000inv.txt");
        listaCaminhos.add("ArquivosTeste/multa5000alea.txt");
        listaCaminhos.add("ArquivosTeste/multa5000ord.txt");

        listaCaminhos.add("ArquivosTeste/multa10000inv.txt");
        listaCaminhos.add("ArquivosTeste/multa10000alea.txt");
        listaCaminhos.add("ArquivosTeste/multa10000ord.txt");

        listaCaminhos.add("ArquivosTeste/multa50000inv.txt");
        listaCaminhos.add("ArquivosTeste/multa50000alea.txt");
        listaCaminhos.add("ArquivosTeste/multa50000ord.txt");
        String ordenacaoArquivo = "";

        //Variaveis de Marcacao do tempo de cada operacao
        long tempoInicial;
        long tempoFinal;
        double tempoExecucao;

        //                          METODOS ORDENACAO

        //                              HEAPSORT

        //Arquivo 1000 registros

        //Marca o inicio da operacao

        for (int index = 0; index <= 2; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista1000.isEmpty()) {
                    lista1000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista1000);

                //Realiza a ordenacao dos registros

                HeapSort heapSort = new HeapSort(lista1000);
                heapSort.heapSort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 0) {
                    ordenacaoArquivo = "inv";
                } else if (index == 1) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                        "MetodosOrdenacao/HeapSort/heap1000%s.txt", ordenacaoArquivo),
                        heapSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HEAPSORT - 1000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 5000 registros

        //Marca o inicio da operacao

        for (int index = 3; index <= 5; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista5000.isEmpty()) {
                    lista5000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista5000);

                //Realiza a ordenacao dos registros

                HeapSort heapSort = new HeapSort(lista5000);
                heapSort.heapSort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 3) {
                    ordenacaoArquivo = "inv";
                } else if (index == 4) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/HeapSort/heap5000%s.txt", ordenacaoArquivo),
                        heapSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HEAPSORT - 5000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 10000 registros

        //Marca o inicio da operacao

        for (int index = 6; index <= 8; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista10000.isEmpty()) {
                    lista10000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista10000);

                //Realiza a ordenacao dos registros

                HeapSort heapSort = new HeapSort(lista10000);
                heapSort.heapSort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 6) {
                    ordenacaoArquivo = "inv";
                } else if (index == 7) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/HeapSort/heap10000%s.txt", ordenacaoArquivo),
                        heapSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HEAPSORT - 10000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 50000 registros

        //Marca o inicio da operacao

        for (int index = 9; index <= 11; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista50000.isEmpty()) {
                    lista50000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista50000);

                //Realiza a ordenacao dos registros

                HeapSort heapSort = new HeapSort(lista50000);
                heapSort.heapSort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 9) {
                    ordenacaoArquivo = "inv";
                } else if (index == 10) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/HeapSort/heap50000%s.txt", ordenacaoArquivo),
                        heapSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HEAPSORT - 50000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //                              QUICKSORT

        //Arquivo 1000 registros

        //Marca o inicio da operacao

        for (int index = 0; index <= 2; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista1000.isEmpty()) {
                    lista1000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista1000);

                //Realiza a ordenacao dos registros

                QuickSort quickSort = new QuickSort(lista1000);
                quickSort.quicksort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 0) {
                    ordenacaoArquivo = "inv";
                } else if (index == 1) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSort/quick1000%s.txt",
                                ordenacaoArquivo), quickSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT - 1000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 5000 registros

        //Marca o inicio da operacao

        for (int index = 3; index <= 5; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista5000.isEmpty()) {
                    lista5000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista5000);

                //Realiza a ordenacao dos registros

                QuickSort quickSort = new QuickSort(lista5000);
                quickSort.quicksort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 3) {
                    ordenacaoArquivo = "inv";
                } else if (index == 4) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSort/quick5000%s.txt",
                        ordenacaoArquivo), quickSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT - 5000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 10000 registros

        //Marca o inicio da operacao

        for (int index = 6; index <= 8; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista10000.isEmpty()) {
                    lista10000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista10000);

                //Realiza a ordenacao dos registros

                QuickSort quickSort = new QuickSort(lista10000);
                quickSort.quicksort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 6) {
                    ordenacaoArquivo = "inv";
                } else if (index == 7) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSort/quick10000%s.txt",
                        ordenacaoArquivo), quickSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT - 10000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 50000 registros

        //Marca o inicio da operacao

        for (int index = 9; index <= 11; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista50000.isEmpty()) {
                    lista50000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista50000);

                //Realiza a ordenacao dos registros

                QuickSort quickSort = new QuickSort(lista50000);
                quickSort.quicksort();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 9) {
                    ordenacaoArquivo = "inv";
                } else if (index == 10) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSort/quick50000%s.txt",
                        ordenacaoArquivo), quickSort.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT - 50000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //                     QUICKSORT INSERCAO DIRETA

        //Arquivo 1000 registros

        //Marca o inicio da operacao

        for (int index = 0; index <= 2; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista1000.isEmpty()) {
                    lista1000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista1000);

                //Realiza a ordenacao dos registros

                QuickSortInsercaoDireta quickSortInsercaoDireta = new QuickSortInsercaoDireta(
                        lista1000);
                quickSortInsercaoDireta.QuickSortInsercaoDireta();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 0) {
                    ordenacaoArquivo = "inv";
                } else if (index == 1) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSortInsercDir/" +
                                "quickInsercDir1000%s.txt",
                        ordenacaoArquivo), quickSortInsercaoDireta.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT INSERÇÃO DIRETA - 1000 arquivos " +
                    ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 5000 registros

        //Marca o inicio da operacao

        for (int index = 3; index <= 5; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista5000.isEmpty()) {
                    lista5000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista5000);

                //Realiza a ordenacao dos registros

                QuickSortInsercaoDireta quickSortInsercaoDireta = new QuickSortInsercaoDireta(
                        lista5000);
                quickSortInsercaoDireta.QuickSortInsercaoDireta();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 3) {
                    ordenacaoArquivo = "inv";
                } else if (index == 4) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSortInsercDir/" +
                                "quickInsercDir5000%s.txt",
                        ordenacaoArquivo), quickSortInsercaoDireta.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT INSERÇÃO DIRETA - 5000 arquivos " +
                    ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 10000 registros

        //Marca o inicio da operacao

        for (int index = 6; index <= 8; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista10000.isEmpty()) {
                    lista10000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista10000);

                //Realiza a ordenacao dos registros

                QuickSortInsercaoDireta quickSortInsercaoDireta = new QuickSortInsercaoDireta(
                        lista10000);
                quickSortInsercaoDireta.QuickSortInsercaoDireta();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 6) {
                    ordenacaoArquivo = "inv";
                } else if (index == 7) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSortInsercDir/" +
                                "quickInsercDir10000%s.txt",
                        ordenacaoArquivo), quickSortInsercaoDireta.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT INSERÇÃO DIRETA - 10000 arquivos " +
                    ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //Arquivo 50000 registros

        //Marca o inicio da operacao

        for (int index = 9; index <= 11; index++) {

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {

                //Esvazia o ArrayList das infracoes caso tenha algo

                if (!lista50000.isEmpty()) {
                    lista50000.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista50000);

                //Realiza a ordenacao dos registros

                QuickSortInsercaoDireta quickSortInsercaoDireta = new QuickSortInsercaoDireta(
                        lista50000);
                quickSortInsercaoDireta.QuickSortInsercaoDireta();

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 9) {
                    ordenacaoArquivo = "inv";
                } else if (index == 10) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve os registros ordenados em um arquivo

                Util.inserirRegistrosArquivo(String.format("ArquivosGerados/" +
                                "MetodosOrdenacao/QuickSortInsercDir/" +
                                "quickInsercDir50000%s.txt",
                        ordenacaoArquivo), quickSortInsercaoDireta.getVetor());
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("QUICKSORT INSERÇÃO DIRETA - 50000 arquivos " +
                    ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));
        }

        //                          METODOS PESQUISA

        //Instanciacao dos ArrayList para guardar as placas a serem pesquisadas e o resultado

        ArrayList<String> listaPlacas = new ArrayList<>(400);
        ArrayList<ArrayList<Infracao>> listaResultadosPesquisas = new ArrayList<>(
                400);

        //Preenchimento do ArrayList com as placas a serem pesquisadas

        Util.preencherListaPlaca("ArquivosTeste/placas.txt", listaPlacas);

        //                              ARVORE ABB

        //Arquivo 1000 registros

        for (int index = 0; index <= 2; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista1000.isEmpty()) {
                    lista1000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista1000);

                //Insere cada registro na Arvore ABB

                ArvoreABB arvoreABB = new ArvoreABB();

                for (Infracao infracao : lista1000) {
                    arvoreABB.inserir(infracao);
                }

                //Realiza o balanceamento da arvore apos insercao de todos os registros

                arvoreABB = arvoreABB.balancear();

                //Pesquisa por cada placa na Arvore ABB

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreABB.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 0) {
                    ordenacaoArquivo = "inv";
                } else if (index == 1) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }


                //Escreve o resultado da pesquisa em um arquivo
                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreABB/arvoreABB1000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE ABB - 1000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 5000 registros

        for (int index = 3; index <= 5; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista5000.isEmpty()) {
                    lista5000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista5000);

                //Insere cada registro na Arvore ABB

                ArvoreABB arvoreABB = new ArvoreABB();

                for (Infracao infracao : lista5000) {
                    arvoreABB.inserir(infracao);
                }

                //Realiza o balanceamento da arvore apos insercao de todos os registros

                arvoreABB = arvoreABB.balancear();

                //Pesquisa por cada placa na Arvore ABB

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreABB.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 3) {
                    ordenacaoArquivo = "inv";
                } else if (index == 4) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo
                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreABB/arvoreABB5000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE ABB - 5000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 10000 registros

        for (int index = 6; index <= 8; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista10000.isEmpty()) {
                    lista10000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista10000);

                //Insere cada registro na Arvore ABB

                ArvoreABB arvoreABB = new ArvoreABB();

                for (int i = 0; i < 5; i++) {
                    for (int pos = 2000 * i; pos < 2000 * (i + 1); pos++) {
                        arvoreABB.inserir(lista10000.get(pos));
                    }
                    arvoreABB = arvoreABB.balancear();
                }

                //Pesquisa por cada placa na Arvore ABB

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreABB.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 6) {
                    ordenacaoArquivo = "inv";
                } else if (index == 7) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo
                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreABB/arvoreABB10000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE ABB - 10000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 50000 registros

        //Marca o inicio da operacao

        for (int index = 9; index <= 11; index ++){
            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista50000.isEmpty()) {
                    lista50000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista50000);

                //Insere cada registro na Arvore ABB

                ArvoreABB arvoreABB = new ArvoreABB();

                for (int i = 0; i < 10; i++) {
                    for (int pos = 5000 * i; pos < 5000 * (i + 1); pos++) {
                        arvoreABB.inserir(lista50000.get(pos));
                    }
                    arvoreABB = arvoreABB.balancear();
                }

                //Pesquisa por cada placa na Arvore ABB

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreABB.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 9){
                    ordenacaoArquivo = "inv";
                } else if (index == 10) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo
                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreABB/arvoreABB50000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE ABB - 50000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //                              ARVORE AVL

        //Arquivo 1000 registros

        for (int index = 0; index <= 2; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista1000.isEmpty()) {
                    lista1000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista1000);

                //Insere cada registro na Arvore AVL

                ArvoreAVL arvoreAVL = new ArvoreAVL();

                for (Infracao infracao : lista1000) {
                    arvoreAVL.inserir(infracao);
                }

                //Pesquisa por cada placa na Arvore AVL

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreAVL.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 0) {
                    ordenacaoArquivo = "inv";
                } else if (index == 1) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreAVL/arvoreAVL1000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE AVL - 1000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 5000 registros

        for (int index = 3; index <= 5; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista5000.isEmpty()) {
                    lista5000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista5000);

                //Insere cada registro na Arvore AVL

                ArvoreAVL arvoreAVL = new ArvoreAVL();

                for (Infracao infracao : lista5000) {
                    arvoreAVL.inserir(infracao);
                }

                //Pesquisa por cada placa na Arvore AVL

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreAVL.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 3) {
                    ordenacaoArquivo = "inv";
                } else if (index == 4) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreAVL/arvoreAVL5000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE AVL - 5000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 10000 registros

        for (int index = 6; index <= 8; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista10000.isEmpty()) {
                    lista10000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista10000);

                //Insere cada registro na Arvore AVL

                ArvoreAVL arvoreAVL = new ArvoreAVL();

                for (Infracao infracao : lista10000) {
                    arvoreAVL.inserir(infracao);
                }

                //Pesquisa por cada placa na Arvore AVL

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreAVL.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 6) {
                    ordenacaoArquivo = "inv";
                } else if (index == 7) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreAVL/arvoreAVL10000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE AVL - 10000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 50000 registros

        for (int index = 9; index <= 11; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista50000.isEmpty()) {
                    lista50000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista50000);

                //Insere cada registro na Arvore AVL

                ArvoreAVL arvoreAVL = new ArvoreAVL();

                for (Infracao infracao : lista50000) {
                    arvoreAVL.inserir(infracao);
                }

                //Pesquisa por cada placa na Arvore AVL

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(arvoreAVL.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 9) {
                    ordenacaoArquivo = "inv";
                } else if (index == 10) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/ArvoreAVL/arvoreAVL50000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("ARVORE AVL - 50000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //                              HASHING ENCADEADO

        //Arquivo 1000 registros

        for (int index = 0; index <= 2; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista1000.isEmpty()) {
                    lista1000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista1000);

                //Insere cada registro no Hashing Encadeado

                HashingEncadeado hashingEncadeado = new HashingEncadeado(lista1000.size());

                for (Infracao infracao : lista1000) {
                    hashingEncadeado.inserir(infracao);
                }

                //Pesquisa por cada placa no Hashing Encadeado

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(hashingEncadeado.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 0) {
                    ordenacaoArquivo = "inv";
                } else if (index == 1) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/HashingEncadeado/" +
                                "HashingEncadeado1000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HASHING ENCADEADO - 1000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 5000 registros

        for (int index = 3; index <= 5; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista5000.isEmpty()) {
                    lista5000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista5000);

                //Insere cada registro no Hashing Encadeado

                HashingEncadeado hashingEncadeado = new HashingEncadeado(lista5000.size());

                for (Infracao infracao : lista5000) {
                    hashingEncadeado.inserir(infracao);
                }

                //Pesquisa por cada placa no Hashing Encadeado

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(hashingEncadeado.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 3) {
                    ordenacaoArquivo = "inv";
                } else if (index == 4) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/HashingEncadeado/" +
                                "HashingEncadeado5000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HASHING ENCADEADO - 5000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 10000 registros

        for (int index = 6; index <= 8; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista10000.isEmpty()) {
                    lista10000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista10000);

                //Insere cada registro no Hashing Encadeado

                HashingEncadeado hashingEncadeado = new HashingEncadeado(lista10000.size());

                for (Infracao infracao : lista10000) {
                    hashingEncadeado.inserir(infracao);
                }

                //Pesquisa por cada placa no Hashing Encadeado

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(hashingEncadeado.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 6) {
                    ordenacaoArquivo = "inv";
                } else if (index == 7) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/HashingEncadeado/" +
                                "HashingEncadeado10000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HASHING ENCADEADO - 10000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

        //Arquivo 50000 registros

        for (int index = 9; index <= 11; index++) {

            //Marca o inicio da operacao

            tempoInicial = System.currentTimeMillis();
            for (int c = 0; c < 5; c++) {
                //Esvazia o ArrayList das infracoes e de resultado de pesquisa caso tenham algo

                if (!lista50000.isEmpty()) {
                    lista50000.clear();
                    listaResultadosPesquisas.clear();
                }

                //Preenche o ArrayList com os registros do arquivo

                Util.preencherListaInfracao(listaCaminhos.get(index),
                        lista50000);

                //Insere cada registro no Hashing Encadeado

                HashingEncadeado hashingEncadeado = new HashingEncadeado(lista50000.size());

                for (Infracao infracao : lista50000) {
                    hashingEncadeado.inserir(infracao);
                }

                //Pesquisa por cada placa no Hashing Encadeado

                for (String placa : listaPlacas) {
                    listaResultadosPesquisas.add(hashingEncadeado.pesquisa(placa));
                }

                //Variavel para auxiliar a construcao do nome do arquivo dentro do looping
                //Depende da ordenacao do arquivo de onde foi retirado os registros

                if (index == 9) {
                    ordenacaoArquivo = "inv";
                } else if (index == 10) {
                    ordenacaoArquivo = "alea";
                } else {
                    ordenacaoArquivo = "ord";
                }

                //Escreve o resultado da pesquisa em um arquivo

                Util.inserirPesquisaArquivo(String.format("ArquivosGerados/" +
                                "MetodosPesquisa/HashingEncadeado/" +
                                "HashingEncadeado50000%s.txt",
                        ordenacaoArquivo), listaPlacas, listaResultadosPesquisas);
            }

            //Marca o tempo do final da operacao

            tempoFinal = System.currentTimeMillis();

            //Realiza o calculo do tempo levado para terminar a operacao, convertendo para segundos

            tempoExecucao = (tempoFinal - tempoInicial) / 5000.0;
            System.out.println("HASHING ENCADEADO - 50000 arquivos " + ordenacaoArquivo);
            System.out.println(String.format("Tempo execução: %.3f segundos\n", tempoExecucao));

        }

    }

}
