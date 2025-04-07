#include <stdio.h>

int countCharRange(char*, char, char);
char *findStringEnd(char*);
void doubleString(char*);
void palindrome(char*); 

int countCharRange(char *str, char c1, char c2) {
    int count = 0;
    while (*str) {
        if (c1 <= c2) {
            if (*str - c1 >= 0 && *str - c2 <= 0) {
                count++;
            }
        }
        else {
            if (*str - c1 <= 0 && *str - c2 >= 0) {
                count++;
            }
        }
        str++;
    }
    return count;
}


char *findStringEnd(char* str) {
    char* ptr = str;
    while(*str) {
        str++;
        ptr = str;
    }
    return ptr;
}

void doubleString(char* str) {
    char* endptr = findStringEnd(str);
    char* beginningptr = str;
    char* incptr = endptr;
    while (beginningptr < endptr) {
        *incptr = *beginningptr;
        beginningptr++;
        incptr++;
    }
    *incptr = '\0';
}

void palindrome(char* str) {
    char* endptr = findStringEnd(str);
    char* beginningptr = endptr -1;
    char* incptr = endptr;
    while (beginningptr >= str) {
        *incptr = *beginningptr;
        beginningptr--;
        incptr++;
    }
    *incptr = '\0';
}
