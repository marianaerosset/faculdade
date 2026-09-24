#ifndef RB_INSERT_H
#define RB_INSERT_H 

#include "tad_rb.h"

void left_rotate(Node **root, Node *x);

void right_rotate(Node **root, Node *y);

void insert_fixup(Node **root, Node *z);

void rb_insert(Node **root, int key);

#endif

