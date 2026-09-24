#include "rb_search.h"

Node* rb_search(Node *root, int key) {
    Node *current = root;
    while (current != NIL && key != current->key) {
        if (key < current->key)
            current = current->left;
        else
            current = current->right;
    }
    return current;
}

