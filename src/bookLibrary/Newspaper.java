package bookLibrary;

import java.util.Date;
import java.util.Objects;


public class Newspaper extends Issue {

   private String title;
   private short number; 
   private String date;

    public Newspaper(String title, short number, String date, long codeIssue) {
        super(codeIssue);
        this.title = title;
        this.number = number;
        this.date = date;
    }
    
   
     @Override
    public String typeName() {
        return "Newspaper";
    }

    public String getTitle() {
        return title;
    }

    public short getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }
   
    @Override
    public String toString() {
        //  return String.format("%10d %10s %30s %4d", getInvNumber(), author, title, year);
        return String.format("%-10s %-30s %4d", super.toString(), title, number, date);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + this.number;
        hash = 37 * hash + Objects.hashCode(this.date);
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
        final Newspaper other = (Newspaper) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

  public int compareTo(Issue t) {
        int n = this.typeName().compareTo(t.typeName());

        return n;
    }
    
    
}
