## Como Rodar o Programa

Tendo em vista o problema do Stack OverFlow na realização do metodo de Pesquisa Arvore ABB e seu Balanceamento, a solução encontrada para evitar a situação foi a seguinte:

- Navegue até o diretorio onde está colocado o projeto(Utilizando o prompt de comando) ou utilize o terminal da IDE utilizada para rodar o programa
- Acesse a pasta src do projeto
- Digite o seguinte comando para compilar as classes:
``` shell
javac Principal.java
```
- Digite o próximo comando para rodar o programa sem dar problemas na montagem da Arvore ABB
``` shell
java -Xss8m Principal
```
A adicao de `-Xss8m` na hora da execucao da classe principal serve para aumentar a quantidade de memoria reservada para a pilha, nesse caso sendo 8 megas
(Tanto o numero quanto a medida de memoria pode ser mudada)

Em testes individuais, somente da Arvore ABB, 4 megas bastaram, porem como o Principal executa todos os metodos, além da ABB, aumenta-se o espaço de memoria reservado para 8 mb por garantia
