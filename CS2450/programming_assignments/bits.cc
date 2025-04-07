#include <stdio.h>

int highLow(int, int);
int countPairs(int);
void printDashOct(int);

int highLow(int a, int b) { 
    int x = a & 0xFFFF0000;
    int y = b & 0x0000FFFF;
    return x | y;
}

int countPairs(int a) { 
    unsigned int b = (unsigned int) a;
    int count = 0;
    if (b % 8 == 3) {
        count++;
    }
    while(b != 0) {
        if (b % 16 == 6) {
            count++;
        }
        b >>= 1;
    }
    return count;
}

void printDashOct(int a) {
    unsigned int b = (unsigned int) a;
    int digit = 0;
    int array[12] = {}; 
    for (int i = 0; i < 11; i++) {
        digit = b & 7;
        array[i] = digit;
        b >>= 3; 
    }
    for (int i = 10; i > 0; i--) {
        printf("%d-", array[i]);
    }
    printf("%d\n", array[0]);
}
// check the things im lazy but these are the names
