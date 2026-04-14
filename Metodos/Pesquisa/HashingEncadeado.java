package Metodos.Pesquisa;

import Metodos.Infracao;
import Metodos.Pesquisa.Nos.NoInfracao;

import java.util.ArrayList;

/**
 * Responsavel por representar um hashing de vetor encadeado, com metodos e atributos que
 * permitem a sua manipulacao
 */
public class HashingEncadeado {
	private ArrayList<NoInfracao> listaNoInfracao;

	/**
	 * @param quantidadeRegistros - Quantidade de registros que serao inseridos no vetor
	 */
	public HashingEncadeado(int quantidadeRegistros) {

		//Cria uma lista com o tamanho proporcional a quantidade de registros a ser inserido

		int tamanho = calcularTamanho(quantidadeRegistros);
		listaNoInfracao = new ArrayList<>(tamanho);

		// Adiciona null para cada posição

		for (int i = 0; i < tamanho; i++) {
			listaNoInfracao.add(null);
		}
	}

	/**
	 * Realiza o calculo do tamanho ideal para o vetor, considerando a quantidade de
	 * registros a serem inseridos, visando um valor que seja um numero primo e
	 * aproximadamente 10% maior que a quantidade de registros
	 *
	 * @param quantidadeRegistros Quantidade de registros a serem inseridos no vetor
	 * @return O tamanho ideal para o vetor
	 */
	private int calcularTamanho(int quantidadeRegistros) {

		//Aumenta 10% da quantidade de registros e usa como valor minimo para o tamanho do vetor

		int tamanho_vetor = quantidadeRegistros + (quantidadeRegistros / 10);
		boolean flag;

		//Caso o numero seja par, soma 1 para garantir que so seja analisado numeros impares

		if (tamanho_vetor % 2 == 0)
			tamanho_vetor += 1;

		//Busca pelo primeiro numero primo maior que o valor definido anteriormente

		do {
			flag = true;
			for (int c = 3; c < tamanho_vetor / 2; c += 2) {
				if (tamanho_vetor % c == 0) {
					flag = false;
					tamanho_vetor += 2;
					break;
				}
			}
		} while (!flag);

		return tamanho_vetor;
	}

	/**
	 * Realiza o calculo da posicao onde a infracao sera inserida no vetor baseado na
	 * sua placa
	 *
	 * @param chave   String, representando a placa da infracao, que sera usada para calcular
	 *                a posicao do elemento no vetor
	 * @param tamanho Tamanho do vetor
	 * @return A posicao onde sera inserida a infracao
	 */
	public int hashing(String chave, int tamanho) {
		char carac;
		int i;
		int soma = 0;

		//Converte cada caractere da placa para um valor numerico

		for (i = 0; i < chave.length(); i++) {
			carac = chave.charAt(i);
			soma += Character.getNumericValue(carac);
		}

		//Retorna a posicao da infracao gerada a partir do resto da divisao

		return soma % tamanho;
	}

	/**
	 * Realiza o processo de insercao da infracao no vetor encadeado
	 *
	 * @param infracao Infracao a ser inserida no vetor
	 */
	public void inserir(Infracao infracao) {

		// Calcula o indice da tabela hash usando a placa da infracao

		int indice = hashing(infracao.getPlaca(), listaNoInfracao.size());

		// Verifica se a posição ja contem um no

		if (listaNoInfracao.get(indice) == null) {

			// Cria um novo no e insere no indice

			listaNoInfracao.set(indice, new NoInfracao(infracao));
		}

		//Caso a posicao ja contenha algum no

		else {

			//Percorre a lista encadeada atraves de uma variavel auxiliar
			//Caso nao tenha outro no com a mesma placa da infracao a ser inserida, insere no final
			//Caso contrario, insere no ArrayList do no que compartilha a mesma placa

			NoInfracao atual = listaNoInfracao.get(indice);

			//Flag utilizada para saber se a infracao sera inserida em um no existente

			boolean inserirExistente = true;

			//Percorre a lista ate chegar no final ou encontrar no existente de mesma placa

			while (!atual.getListaInfracao().get(0).getPlaca().equalsIgnoreCase(
					infracao.getPlaca())) {

				//Caso chege no final, sai do looping

				if (atual.getProx() == null) {
					inserirExistente = false;
					break;
				}

				atual = atual.getProx();
			}

			//Cria um no e adiciona no final da lista
			//Somente se a infracao nao tiver  que serr inserida em outro no ja existente

			if (!inserirExistente) {
				NoInfracao novo = new NoInfracao(infracao);
				atual.setProx(novo);
			}

			//Insere em um no existente
			else{
				atual.adicionarElemento(infracao);
			}

		}
	}


	/**
	 * Realiza a pesquisa pela placa passada no vetor encadeado
	 *
	 * @param placa Placa a ser pesquisada
	 * @return null caso nao encontre a placa ou um ArrayList com as infracoes que
	 * correspondam a placa, mantendo a ordenacao
	 */
	public ArrayList<Infracao> pesquisa(String placa) {

		// Calcula o indice da tabela hash usando a placa

		int indice = hashing(placa, listaNoInfracao.size());

		// Obtem o no do indice correspondente

		NoInfracao atual = listaNoInfracao.get(indice);

		// Percorre a lista encadeada para encontrar todas as infrações com a mesma placa

		while (atual != null) {

			// Retorna o ArrayList de infracos do no caso tenham a placa procurada

			if (atual.getListaInfracao().get(0).getPlaca().equals(placa)) {

				return atual.getListaInfracao();

			}

			// Move para o próximo no

			atual = atual.getProx();
		}

		//Caso nao tenha nenhuma infracao com a placa passada

		return null;

	}
}


