package bookLibrary;

import java.util.ArrayList;
import java.util.List;


public class BookLibrary {


    public static void main(String[] args) {
        //  Book book1= new Book("H. Shildt", "Java", (short)2017, 1000);
        //  Book book2= new Book("H. Shil", "Java", (short)2017, 1000);

        //  ArrayList<Issue> list = new <Issue>ArrayList();
        //     System.out.println(book1.takeIssue()); //true
        //    System.out.println(book2.takeIssue()); //true
        //   System.out.println(book1.equals(book2));
        Library lib;
        lib = new Library("lib.dat");

        int key;
        for (;;) {
            key = menu();
            switch (key) {
                case 1:
                    ArrayList<Issue> spisok = lib.getList();
                    if (spisok != null) {
                        printLibrary(spisok);
                    }
                    break;
                case 2:
                    System.out.println("Number of issues in catalogue: " + lib.getCountIssue());

                    break;

                case 3:
                    searchTitle(lib);
                    break;

                case 4:
                    searchTitlePart(lib);
                    break;

                case 5:
                    searchAuthor(lib);
                    break;

                case 6:
                    searchInvNumber(lib);
                    break;

                case 7:
                    checkInStorage(lib);
                    break;

                case 8:
                    takeIssue(lib);

                    break;

                case 9:
                    returnIssue(lib);
                    break;
                case 10:
                    addIssues(lib);
                    break;
              
//                case 11:
//                    deleteIssue(lib);
//
//                    break;
                case 11:
                    System.out.println("Close...");
                    System.exit(0);
            }
        }

    }// end main

    static long readInvNumber() {
        long invNumber = 0;
        do {
            System.out.println(" Inventory number : ");
            invNumber = ConsoleInput.readInt();
        } while (invNumber <= 0);
        return invNumber;
    }

    static void checkIsAvailable(Library lib) {

//        long invNumber = 0;
//        do {
//            System.out.println(" Инвентарный номер : ");
//            invNumber = ConsoleInput.readInt();
//        } while (invNumber <= 0);
        long invNumber = readInvNumber();

        Issue issue = lib.getIssue(invNumber);
        if (issue != null) {
            System.out.println(issue);
        }

        System.out.println(invNumber + " - " + lib.IsAvailable(invNumber));
    }

    static void addIssues(Library lib) {

        String[] menuItem = {
            " 1 Book",
            " 2 Magazine",
            " 3 Newspaper",
            " 4 Cancel"
        };
        int key;

        for (;;) {
            for (String str : menuItem) {
                System.out.println(str);
            }
            System.out.print(" : ");
            key = ConsoleInput.readInt();
            switch (key) {
                case 1:
                    addBook(lib);
                    return;

                case 2:
                    addJournal(lib);
                    return;

                case 3:
                    addNewspaper(lib);
                    return;
                case 4:
                    return;
            }

        }
    }

    static void addBook(Library lib) {
        boolean flag = false;
        System.out.println("Type author's name: ");
        String author = ConsoleInput.readString().trim();
        System.out.println("Type title: ");
        String title = ConsoleInput.readString().trim();
        System.out.println("Type year: ");
        Short year = ConsoleInput.readShort();
        System.out.println("Enter the number of copies: ");
        int count = ConsoleInput.readInt();
        long numb = lib.getMaxInvNumber("Book");
        for (int i = 0; i < count; i++) {
            Issue issue = new Book(author, title, year, ++numb);
            lib.list.add(issue);
        }
        System.out.println("Issues added successfully");
        flag = true;

    }

    static void addJournal(Library lib) {
        System.out.println("Type title: ");
        String title = ConsoleInput.readString().trim();
        System.out.println("Type number: ");
        String number = ConsoleInput.readString();
        System.out.println("Type volume: ");
        String volume = ConsoleInput.readString().trim();
        System.out.println("Type date: ");
        String date = ConsoleInput.readString();
        System.out.println("Enter the number of copies: ");
        int count = ConsoleInput.readInt();
        long numb = lib.getMaxInvNumber("Journal");
        for (int i = 0; i < count; i++) {
            Issue issue = new Journal(title, volume, number, date, ++numb);
            lib.list.add(issue);
        }
        System.out.println("Issues added successfully");
    }

    static void addNewspaper(Library lib) {
        System.out.println("Type title: ");
        String title = ConsoleInput.readString().trim();
        System.out.println("Type number: ");
        Short number = ConsoleInput.readShort();
        System.out.println("Type date: ");
        String date = ConsoleInput.readString();
        System.out.println("Enter the number of copies: ");
        int count = ConsoleInput.readInt();
        long numb = lib.getMaxInvNumber("Newspaper");
        for (int i = 0; i < count; i++) {
            Issue issue = new Newspaper(title, number, date, ++numb);
            lib.list.add(issue);
        }
        System.out.println("Issues added successfully");
    }



    static void searchTitle(Library lib) {

        String title = "";
        do {
            System.out.print("Title: ");
            title = ConsoleInput.readString().trim();
        } while (title.isEmpty());

        ArrayList<Issue> listTitle;
        listTitle = lib.searchTitle(title);
        if (listTitle == null) {
            System.out.println("Title \"" + title + "\" - not found");
            System.out.println("Try \"Search by title containing a fragment\"");

        } else {
            printList(listTitle);
        }

    }

    static void searchTitlePart(Library lib) {
        String titlePart = "";
        do {
            System.out.print("Title contains: ");
            titlePart = ConsoleInput.readString().trim();
        } while (titlePart.isEmpty());

        ArrayList<Issue> listTitlePart;
        listTitlePart = lib.searchTitlePart(titlePart);
        if (listTitlePart == null) {
            System.out.println("Fragment \"" + titlePart + "\" - not found");
        } else {
            printList(listTitlePart);
        }
    }

    static void searchAuthor(Library lib) {
        String author = "";
        do {
            System.out.print("Author: ");
            author = ConsoleInput.readString().trim();
        } while (author.isEmpty());

        ArrayList<Issue> listAuthor;
        listAuthor = lib.searchAuthor(author);
        if (listAuthor == null) {
            System.out.println("Author \"" + author + "\" - not found");
        } else {
            printList(listAuthor);
        }

    }

    static void searchInvNumber(Library lib) {
        long invNumber = readInvNumber();
        ArrayList<Issue> listInvNumber;
        listInvNumber = lib.searchInvNumber(invNumber);
        if (listInvNumber == null) {
            System.out.println("Inventory number \"" + invNumber + "\" - not found");
        } else {
            printList(listInvNumber);
        }

    }

    static void checkInStorage(Library lib) {
        long invNumber = readInvNumber();
        ArrayList<Issue> listStorage;
        listStorage = lib.searchInvNumber(invNumber);
        if (listStorage != null) {

            listStorage = lib.searchInStorage(invNumber);
            if (listStorage == null) {
                printList(lib.searchInvNumber(invNumber));
                System.out.println("Issue is temporarily not available (booked)");
            } else {
                printList(listStorage);
                System.out.println("Issue is available in storage");
            }
        } else {
            System.out.println("Inventory number \"" + invNumber + "\" - not found");
        }

    }

    static void takeIssue(Library lib) {
        long invNumber = readInvNumber();
        if (lib.searchInvNumber(invNumber) != null) {

            boolean flag = lib.takeIssue(invNumber);
            if (flag) {
                System.out.println("You took the issue: ");
                Issue issue = lib.getIssue(invNumber);
                System.out.println(issue);
            } else {
                System.out.println("The required issue is not available (booked)");
            }
        } else {
            System.out.println("Inventory number \"" + invNumber + "\" - not found");
        }
    }

    static void returnIssue(Library lib) {
        long invNumber = readInvNumber();
        if (lib.searchInvNumber(invNumber) != null) {
            boolean flag = lib.returnIssue(invNumber);
            if (flag) {
                System.out.println("You returned the issue: ");
                Issue issue = lib.getIssue(invNumber);
                System.out.println(issue);
            } else {
                System.out.println("Error! The issue is already in the storage");
            }
        } else {
            System.out.println("Inventory number \"" + invNumber + "\" - not found");
        }
    }

    static void printLibrary(ArrayList<Issue> spisok) {
        if (spisok == null) {
            System.out.println("List not created");
            return;
        }

        if (spisok.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        for (Issue issue : spisok) {
            System.out.println(issue);
        }
        //System.out.println();
    }

    static void printList(List<Issue> list) {
        for (Issue issue : list) {
            System.out.println(issue);
        }
        System.out.println();
    }

    static int menu() {
        int key = 0;
        String[] menuItem = {
            " 1 Display the catalogue",
            " 2 Number of issues",
            " 3 Search by title",
            " 4 Search by title, containing the fragment",
            " 5 Search by author",
            " 6 Search by inventory number",
            " 7 Issues availability in the storage (by inventory number)",
            " 8 Take the issue",
            " 9 Return the issue",
            "10 Add new issues to the storage",
//          "11 Delete (by inventory number)",
            "11 Finish"
        };
        System.out.println("");
        for (String str : menuItem) {
            System.out.println(str);
        }
        System.out.print(" : ");
        key = ConsoleInput.readInt();
        return key;
    }

}
