package library;

import storage.SortedLinkedList;

import java.util.Scanner;

public class BookReader
{
    private Scanner fileIn;
    private SortedLinkedList<Book> books;

    public BookReader(String filename)
    {
        fileIn = new Scanner(filename);
        books = new SortedLinkedList();
    }

    public void setFileIn(Scanner filein) {}

    public void readLines() {}

    public SortedLinkedList<Book> getBooks() {return books;}

    public void printMoreThan300() {}

    public double averagePages() {return 0.0;}

    public void removeLessThan200() {}
}
