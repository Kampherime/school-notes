#define NAME_SIZE 80
#define SSN_SIZE 13
#define NUM_PEOPLE 10

typedef struct {
    char name[NAME_SIZE];
    char ssn[SSN_SIZE];
    int yearOfBirth;
} person_t;

void getOnePerson(person_t *person);
void printOnePerson(person_t person);
void getPeople(person_t *person, int num);
void printPeople(person_t *person, int num);

