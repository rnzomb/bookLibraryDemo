package bookLibrary;

import java.util.Date;
import java.util.Objects;

public class Journal extends Issue {

    private String volume;
    private String number;
    private String title;
 //private Date date;
    private String date;

    public Journal(String title, String volume, String number, String date, long codeIssue) {
        super(codeIssue);
        this.volume = volume;
        this.number = number;
        this.title = title;
        this.date = date;
    }

    @Override
    public String typeName() {
        return "Journal";
    }

    public String getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        //  return String.format("%10d %10s %30s %4d", getInvNumber(), author, title, year);
        return String.format("%-15s %-10s %-6s %4s %-10s", super.toString(), this.title, this.volume, this.number, this.date);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.volume);
        hash = 97 * hash + Objects.hashCode(this.number);
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.date);
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
        final Journal other = (Journal) obj;
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
     public int compareTo(Issue t) {
        int n = this.typeName().compareTo(t.typeName());
        if (n == 0) {
            int n1 = this.title.compareTo(((Journal) t).title);
            if (n1 == 0) {
                return this.date.compareTo(((Journal) t).date)*-1;
            } else {
                return n1;
            }
        }
        return n;
    }
}
