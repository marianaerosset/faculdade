#include <stdlib.h>     
#include <stdio.h>      
#include "AVL.h"

//Cria uma árvore binária vazia
tree Definir(void) //código da ABB
{
   return NULL;
}

//Define nó raiz
tree Criar_raiz(tipo_dado elem) //código da ABB
{ 
   //tree: é um ponteiro do tipo no
   tree raiz = malloc(sizeof(no));    
   raiz->esq = NULL;
   raiz->dir = NULL;
   raiz->info = elem;
   
   //retorna ponteiro da raiz
   return raiz;
}

tree Busca(tree raiz, tipo_dado elem)  //código da ABB (busca recursiva)
{
   if (raiz == NULL)
      return NULL;

   if (elem.valor == raiz->info.valor)
      return raiz;

   if (elem.valor < raiz->info.valor)
      return Busca(raiz->esq, elem);
   else
      return Busca(raiz->dir, elem);
}

tree Busca_menor_a_direita(tree node) {   //código da ABB
   tree p = node;
   //Enquanto tanto p como p->esq sao nao nulos, anda p/ esquerda
   while ((p != NULL) && (p->esq != NULL))
      p = p->esq;  
   return p;
}

void preOrdem(tree t) {  //código adaptado da ABB
   if (t != NULL) {
      printf("%d\t", t->info.valor);
      preOrdem(t->esq);
      preOrdem(t->dir);
   }
}

//Retorna a altura (profundidade) da AB
int Altura(tree t)   //código da ABB
{	
   if (t == NULL)
      return 0;
   
   int altE = Altura(t->esq);
   int altD = Altura(t->dir);
   
	if (altE > altD){
		return (altE + 1); 
	}
	return (altD + 1); 
	//altura = max(altE, altD) + 1
}

//Função (recursiva) p/ inserir um nó na ABB, caso ele ainda não esteja lá
//Após inserção, retorna um ponteiro para a raiz da nova ABB
tree Busca_insere(tree raiz, tipo_dado elem) //código adaptado da ABB
{
   //Inserir elem. como raiz da árvore
   if (raiz == NULL) 
   { 
      raiz = malloc(sizeof(no));
      raiz->info = elem;
      raiz->esq = NULL;
      raiz->dir = NULL;
      raiz->fb = 0;
      return raiz;
   }
   
   //Verifica para qual das sub-arvore seguir
   if (elem.valor < raiz->info.valor)
      raiz->esq = Busca_insere(raiz->esq, elem);
   if (elem.valor > raiz->info.valor)
      raiz->dir = Busca_insere(raiz->dir, elem);
   if (elem.valor == raiz->info.valor)
      printf("Chave %d ja existe", elem.valor);

   //Atualiza o fator de balanceamento do nó raiz após a inserção
   raiz->fb = calculaFB(raiz);

   //Balanceia a árvore, se necessário
   raiz = balancear(raiz);
   
   return raiz;
}

//Função de remoção dado um nó p: checa todos os quatro casos.
//Caso (a) nó folha; (b) filho único direita; (c) filho único esquerda;
//Caso (d) nó c/ dois filhos ==> chama 'Busca_menor_a_esquerda' p/ encontrar menor nó
//Retorna em p o ponteiro para o nó que substituiu o nó removido
tree Remove_no(tree p)  //código da ABB
{
   tree q;
   
   //Casos (a) é nó folha, ou (b) filho único à direita 
   if (p->esq == NULL)
   {
	  //Substitui pelo filho à direita e remove nó
      q = p;
	  p = p->dir; 
	  free(q);
   }
   //Caso (c) filho único à esquerda
   else if (p->dir == NULL) 
   {
      //Substitui pelo filho à esquerda e remove nó
      q = p; 
	  p = p->esq; 
	  free(q);
   }
   //Caso (d) nó p c/ dois filhos ==> chama 'Busca_menor_a_direita' p/ p e p->dir 
   else {
      q = Busca_menor_a_direita(p->dir);
      p->info = q->info; //Copia menor para nó corrente
      p->dir = Busca_remove(p->dir, q->info); //Chama Busca_remove p/ realizar as emendas
  }

  return p;
}

//Função (recursiva) para buscar e remover um dado elemento.
//Após remoção, retorna um ponteiro para a raiz da nova ABB
tree Busca_remove(tree raiz, tipo_dado elem) //código adaptado da ABB
{
   //Árvore vazia, ou (b) x não está na árvore
   if (raiz == NULL)
      return NULL;
      
   //Encontrou o nó: ==> chamar 'Remove_no' p/ o nó a fim de checar qual caso tratar
   if (raiz->info.valor == elem.valor)
   {
	  raiz = Remove_no(raiz);
   }
   //Busca na sub-árvore esquerda
   else if (elem.valor < raiz->info.valor)
   {
      raiz->esq = Busca_remove(raiz->esq, elem);
   }
   //Busca na sub-árvore direita
   else
   {
      raiz->dir = Busca_remove(raiz->dir, elem);
   }
   
   //Se o nó removido era folha e a subárvore ficou vazia, não há o que balancear
   if (raiz == NULL) {
      return NULL;
   }
   
   //Atualiza o Fator de Balanceamento
   raiz->fb = calculaFB(raiz);
   
   //Balanceia a árvore, se necessário
   raiz = balancear(raiz);

   return raiz;
}

// --- CÓDIGOS NOVOS PARA AVL ---

//Função para calcular o fator de balanceamento de um nó
int calculaFB(tree t)
{
   if (t == NULL)
      return 0;
   
   int altE = Altura(t->esq);
   int altD = Altura(t->dir);
   
   return (altD - altE);
}

//Rotação Simples à Esquerda
tree rotacaoEsquerda(tree raiz) {
    tree novaRaiz = raiz->dir;
   //Pega a subárvore à ESQUERDA e pendura à DIREITA da nova raiz
    raiz->dir = novaRaiz->esq;
    novaRaiz->esq = raiz;

    //Atualiza o FB apenas dos nós que mudaram de posição
    raiz->fb = calculaFB(raiz);
    novaRaiz->fb = calculaFB(novaRaiz);

    return novaRaiz;
}

//Rotação Simples à Direita
tree rotacaoDireita(tree raiz) {
    tree novaRaiz = raiz->esq;
    //Pega a subárvore à DIREITA e pendura à ESQUERDA da nova raiz
    raiz->esq = novaRaiz->dir;
    novaRaiz->dir = raiz;

    //Atualiza o FB apenas dos nós que mudaram de posição
    raiz->fb = calculaFB(raiz);
    novaRaiz->fb = calculaFB(novaRaiz);

    return novaRaiz;
}

//Rotação Composta à Esquerda
tree rotacaoCompostaEsquerda(tree raiz) {
    //1. Rotaciona o filho à direita para a DIREITA
    raiz->dir = rotacaoDireita(raiz->dir);
    
    //2. Rotaciona a raiz para a ESQUERDA
    return rotacaoEsquerda(raiz);
}

//Rotação Composta à Direita
tree rotacaoCompostaDireita(tree raiz) {
    //1. Rotaciona o filho à esquerda para a ESQUERDA
    raiz->esq = rotacaoEsquerda(raiz->esq);
   
    //2. Rotaciona a raiz para a DIREITA
    return rotacaoDireita(raiz);
}

//Função de balanceamento: checa o FB do nó raiz e, se necessário, chama as rotações adequadas
tree balancear(tree raiz) {
    if (raiz == NULL) return NULL;

    //Árvore pesada para a DIREITA
    if (raiz->fb == 2) {
        if (raiz->dir != NULL && raiz->dir->fb >= 0) {
            // Sinais iguais (+2 e +1/0): Rotação Simples
            raiz = rotacaoEsquerda(raiz);
        } else {
            // Sinais opostos (+2 e -1): Rotação Composta
            raiz = rotacaoCompostaEsquerda(raiz);
        }
    } 
    //Árvore pesada para a ESQUERDA
    else if (raiz->fb == -2) {
        if (raiz->esq != NULL && raiz->esq->fb <= 0) {
            // Sinais iguais (-2 e -1/0): Rotação Simples
            raiz = rotacaoDireita(raiz);
        } else {
            // Sinais opostos (-2 e +1): Rotação Composta
            raiz = rotacaoCompostaDireita(raiz);
        }
    }

    return raiz;
}
