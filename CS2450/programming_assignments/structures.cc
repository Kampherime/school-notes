#include <stdio.h>
#include <string.h>
#include "structures.h"

void getOnePerson(person_t *person) {
    printf("Enter full name: ");
    scanf("%79s", person->name);
    printf("Enter ssn: ");
    scanf("%12s", person->ssn);
    printf("Enter year of birth: ");
    scanf("%d", &person->yearOfBirth);
}

void printOnePerson(person_t person) {
    printf("%s:%s:%d\n", person.name, person.ssn, person.yearOfBirth);
}

void getPeople(person_t *person, int num) {
    for (int i = 0; i < num; i++) {
        getOnePerson(&person[i]);
    }
}
void printPeople(person_t *person, int num) {
    for (int i = 0; i < num; i++) {
        printOnePerson(person[i]);
    }
}
