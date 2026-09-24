/* * A saída gerada por este código está documentada no PDF enviado separadamente. 
 * Observação: Este arquivo corresponde ao Exercício 8 e 
 * deve ser compilado separadamente do código do Exercício 6.
 */

#include "rb_insert.h"
#include "rb_validate.h"


int main() {
    Node *root = NIL; 
    
    int chaves[] = {10, 20, 30, 15, 25, 5, 1};
    int num_chaves = sizeof(chaves) / sizeof(chaves[0]);

    for (int i = 0; i < num_chaves; i++) {
        
        rb_insert(&root, chaves[i]);
        
        if (is_valid_rb(root)) {
            printf("Valida\n");
        } else {
            printf("Invalida\n");
        }
    }

    return 0;
}