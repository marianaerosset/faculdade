#include <stdio.h>
int main(void) {
int a, b, c, *x, *y;
a = 50;
b = 15;
x = &a;		
y = &b;		
c = a+b**x**y;		
printf("Valor de c: %d.\n", c);
return 0;
}
