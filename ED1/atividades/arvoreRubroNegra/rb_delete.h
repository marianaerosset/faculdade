#ifndef RB_DELETE_H
#define RB_DELETE_H

#include "tad_rb.h"

Node* rb_minimum(Node *x);

void rb_transplant(Node **root, Node *u, Node *v);

void delete_fixup(Node **root, Node *x);

void rb_delete(Node **root, Node *z);

#endif