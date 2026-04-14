package Metodos.Pesquisa.Nos;

import Metodos.Infracao;

/**
 * Responsavel por representar um no do hashing Encadeado, contendo um ArrayList de
 * objetos da classe Infracao e um ponteiro para o proximo no, permitindo a criacao
 * de uma lista encadeada
 */
public class NoInfracao extends No {
	private NoInfracao prox;

	/**
	 *
	 * @param infracao Infracao que o no ira armazenar
	 */
	public NoInfracao(Infracao infracao) {
        super(infracao);
        this.prox = null;
	}

	//Getters e setters

	public NoInfracao getProx() {
		return prox;
	}

	public void setProx(NoInfracao prox) {
		this.prox = prox;
	}
}
