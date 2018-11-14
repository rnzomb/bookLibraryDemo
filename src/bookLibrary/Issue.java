package bookLibrary;


abstract public class Issue implements Comparable<Issue>{

    private boolean taken; //take issue
    private final long invNumber;   //inventory number
    public long getInvNumber() {
        return invNumber;
    }

    static private int number = 0;

    public Issue(long codeIssue) {
        invNumber = codeIssue;
        taken = false;
    }

    public boolean isTaken() {
        return taken;
    }     // true if somebody took issue

    public boolean isAvailable() {
        return isTaken() == false; //!isTaken
    } // true if issue is in storage

    
    public boolean takeIssue(){
        if (isAvailable()) {
        this.taken=true;  
        return true;
        }
        return false;
    }
    public void returnIssue(){   
        this.taken = false;
    }
    
      
    
    abstract String typeName();  // return object's type;

    @Override
    public String toString() {
        return String.format("%10s %10d", typeName(), invNumber);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        //if (getClass() != obj.getClass()) {
        if (!(obj instanceof Issue)) {
            return false;
        }
        Issue other = (Issue) obj;

        if (this.invNumber != other.invNumber) {
            return false;
        }
        if (this.typeName() != other.typeName()) {
            return false;
        }
        return true;
    }

    long getInvNumber(Object obj) {
        return invNumber;
    } // inventory number

   
}
