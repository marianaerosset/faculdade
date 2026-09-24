#include <stdio.h>
#include <stdlib.h>
#include "AVL.h"

int main() {
    //Inicializa a árvore
    tree avl = Definir();
    tipo_dado d;

    printf("--- INSERCOES NA AVL ---\n");
    
    //Teste 1: Inserção forçando Rotação à Esquerda (Caso LL -> 10, 20, 30)
    d.valor = 10; avl = Busca_insere(avl, d);
    d.valor = 20; avl = Busca_insere(avl, d);
    d.valor = 30; avl = Busca_insere(avl, d); // Rotação

    //Teste 2: Inserção forçando Rotação à Direita (Caso RR -> 5, 3)
    d.valor = 5; avl = Busca_insere(avl, d);
    d.valor = 3; avl = Busca_insere(avl, d); // Rotação

    //Teste 3: Rotação Composta
    d.valor = 25; avl = Busca_insere(avl, d);
    d.valor = 27; avl = Busca_insere(avl, d);

    printf("Arvore apos insercoes (Pre-Ordem):\n");
    preOrdem(avl);
    printf("\n");

    //2. Testando a Busca
    printf("\n--- BUSCA ---\n");
    tipo_dado elem;
    elem.valor = 30;
    tree resultado_busca = Busca(avl, elem);
    if (resultado_busca != NULL) {
        printf("SUCESSO: Valor %d encontrado na arvore!\n", resultado_busca->info.valor);
    } else {
        printf("FALHA: Valor %d nao encontrado.\n", elem.valor);
    }

    //3. Testando a Remoção
    printf("\n--- REMOCAO ---\n");
    //Removendo nós para causar rebalanceamento
    d.valor = 27; 
    printf("Removendo o valor %d...", d.valor);
    avl = Busca_remove(avl, d);
    printf("\nArvore apos a remocao (Pre-Ordem):\n");
    preOrdem(avl);
    printf("\n");

    d.valor = 25; 
    printf("\nRemovendo o valor %d...", d.valor);
    avl = Busca_remove(avl, d);
    printf("\nArvore apos a remocao (Pre-Ordem):\n");
    preOrdem(avl);
    printf("\n");

    d.valor = 30; 
    printf("\nRemovendo o valor %d...", d.valor);
    avl = Busca_remove(avl, d);
    printf("\nArvore apos a remocao (Pre-Ordem):\n");
    preOrdem(avl);

    return 0;
}