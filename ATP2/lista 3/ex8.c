#include <stdio.h>

int main(void) {
    int a, *b, **c, x, y, z;
    x = 10;
    a = x; 
    b = &a; 
    c = &b;
    a += 5;
    y = a;
    *b += 10;
    **c += 1;
    y++;
    z = *b + **c;
    printf("Valor: %d.\n", x + y + z);
    return 0;
}
