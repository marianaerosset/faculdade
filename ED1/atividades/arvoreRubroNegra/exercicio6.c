/* * A saída gerada por este código está documentada no PDF enviado separadamente. 
 * Observação: Este arquivo corresponde ao Exercício 6 e 
 * deve ser compilado separadamente do código do Exercício 8.
 */

#include "tad_rb.h"
#include "rb_delete.h"
#include "rb_insert.h"
#include "rb_search.h"
#include "rb_validate.h"

int main() {
    Node *root = NIL; 
    
    int values[] = {5, 3, 7, 1, 4, 6, 8};
    int num_inserir = sizeof(values) / sizeof(values[0]);

    for (int i = 0; i < num_inserir; i++) {
        rb_insert(&root, values[i]);
        printf(" %d \t| %s\n", values[i], is_valid_rb(root) ? "Valida" : "Invalida");
    }

    printf("\n remoeção das chaves 3 e 7\n");
    int values_remove[] = {3, 7};
    for (int i = 0; i < 2; i++) {
        // encontrar o ponteiro do no para remover
        Node *z = rb_search(root, values_remove[i]);
        
        if (z != NIL) {
            rb_delete(&root, z);
            printf(" %d \t| %s\n", values_remove[i], is_valid_rb(root) ? "Valida" : "Invalida");
        } else {
            printf("Chave %d nao encontrada\n", values_remove[i]);
        }
    }

    return 0;
}