#include <stdio.h>

int main (void) {
    int a = 0xFFFFFF16;
    printf("%b\n", a);
    printf("%d\n", a % 16);
    printf("%b\n", a % 16);
    printf("%b\n", a / 16);
    printf("%b\n", a & 7);
    return 0;
}
