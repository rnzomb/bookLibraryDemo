package bookLibrary;

import java.util.Objects;


public class Book extends Issue {

    private String author;
    private String title;
    private short year;

    public Book(String author, String title, short year, long codeIssue) {
        super(codeIssue);
        this.author = author;
        this.title = title;
        this.year = year;
    }

    @Override
    public String typeName() {
        return "Book";
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public short getYear() {
        return year;
    }

    @Override
    public String toString() {
        //  return String.format("%10d %10s %30s %4d", getInvNumber(), author, title, year);
        //return String.format("-15s %-10s %-30s %4d", super.toString(), author, title, year);
        //return super.toString()+" " +author+"  "+ title+"  " + year;
        return String.format("%s  %-15s   %-10s  %4d", super.toString(), author, title, year);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.author);
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + this.year;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.getInvNumber() != other.getInvNumber()) {
            return false;
        }

        return true;
    }

    public int compareTo(Issue t) {
        int n = this.typeName().compareTo(t.typeName());
        if (n == 0) {
            int n1 = this.author.compareTo(((Book) t).author);
            if (n1 == 0) {
                return this.title.compareTo(((Book) t).title);
            } else {
                return n1;
            }
        }
        return n;
    }
}
