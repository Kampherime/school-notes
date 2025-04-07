#include <stdio.h>

void printTriangleWhile(int);
void printTriangleFor(int);
//this code is ugly as FUCK

void printTriangleWhile(int rows) {
    if (rows <= 0) 
        return;
    if (rows == 1) {
        printf("+\n");
        return;
    }
    int i = 0;
    int j = rows - 1;
    int spaces = 1;
    while (i < rows) {
        printf("+");
        i++;
    }
    printf("\n");
    int dash_count = rows - 3;
    while (j > 1) { 
        i = 0;
        while(i < spaces) {
            printf(" ");
            i++;
        }
        spaces++;
        printf("+");
        i = 0;
        while(i < dash_count) {
            printf("-");
            i++;
        }
        dash_count--;
        printf("+\n");
        j--;
    }
    while(spaces > 0) {
        printf(" ");
        spaces--;
    }
    printf("+\n");
}

void printTriangleFor(int rows) {
    if (rows <= 0)
        return;
    if (rows == 1) {
        printf("+\n");
        return;
    }
    int spaces = rows - 2;
    int dashes = 1;
    for (int i = 0; i < spaces + 1; i++) {
        printf(" ");
    }
    printf("+");
    printf("\n");
    for (int i = 0; i < rows - 2; i++) {
    for (int i = 0; i < spaces; i++) {
        printf(" ");
    }
        printf("+");
        for (int i = 0; i < dashes; i++) {
            printf("-");
        }
        printf("+");
        spaces--;
        dashes += 2;
        printf("\n");
    }
    for (int i = 0; i < 2*rows - 1; i++) {
        printf("+");
    }
    printf("\n");
}
