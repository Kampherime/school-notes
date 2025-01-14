package library;

public class Book implements Comparable<Book>
{
    private String author;
    private String title;
    private int numPages;

    public Book(String author, String title, int numPages) 
    {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getNumPages()
    {
        return this.numPages;
    }

    public boolean equals(Book other)
    {
        if (author != other.author || title != other.title) {
            return false;
        }
        return true;
    }

    public int compareTo(Book book)
    {
        int res1 = book.author.compareTo(this.author);
        if (res1 != 0)
        {
            return res1;
        }
        int res2 = book.title.compareTo(this.title);
        if (res2 != 0) {
            return res2;
        }
        return 0;
    }

    public String toString()
    {
        return String.format("%s, %s, %s", author, title, numPages);        
    }
}
