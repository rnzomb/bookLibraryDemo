package bookLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {

    ArrayList<Issue> list;
    String fileName;

    public Library(String fileName) {
        list = new <Issue>ArrayList();
        this.fileName = fileName;
        readFromFile();

    }

    public int getCountIssue() {
        return list.size();
    }

    public int getCountIssue(String type) {
        int b = 0;
        for (Issue st : list) {
            //     st.typeName() ==type ? b++ : b;
            if (st.typeName() == type) {
                b++;
            }
        }
        return b;
    }

    public ArrayList<Issue> getList() {
        return list;
    }

    public ArrayList<Issue> searchAuthor(String author) {

        ArrayList<Issue> spisok = null;
        for (Issue issue : list) {
            if (issue instanceof Book) {
                if (((Book) issue).getAuthor().toUpperCase().contains(author.toUpperCase())) {
                    //  System.out.println(issue);
                    if (spisok == null) {
                        spisok = new ArrayList<Issue>();
                    }
                    spisok.add(issue);
                }
            }
        }
        if (spisok != null) {
            Collections.sort(spisok);
        }
        return spisok;
    }

    public ArrayList<Issue> searchTitle(String title) {

        ArrayList<Issue> spisok = null;
        for (Issue issue : list) {
            if (issue instanceof Book) {
                if (((Book) issue).getTitle().equalsIgnoreCase(title)) {
                    if (spisok == null) {
                        spisok = new ArrayList<Issue>();
                    }
                    spisok.add(issue);
                }
            }
        }
        if (spisok != null) {
            Collections.sort(spisok);
        }
        return spisok;
    }

    public ArrayList<Issue> searchTitlePart(String titlePart) {

        ArrayList<Issue> listPart = null;
        for (Issue issue : list) {
            if (issue instanceof Book) {
                if (((Book) issue).getTitle().toUpperCase().contains(titlePart.toUpperCase())) {
                    if (listPart == null) {
                        listPart = new ArrayList<Issue>();
                    }
                    listPart.add(issue);
                }
            }
//            } else if (((Journal) issue).getTitle().toUpperCase().contains(titlePart.toUpperCase())) {
//                if (listPart == null) {
//                    listPart = new ArrayList<Issue>();
//                }
//                listPart.add(issue);
//            } 
        }
        if (listPart != null) {
            Collections.sort(listPart);
        }
        return listPart;
    }

    public long getMaxInvNumber(String type) {
        int count;
        ArrayList<Issue> tempList = null;
        for (Issue issue : list) {
            if (issue.typeName() == type) {
                if (tempList == null) {
                    tempList = new ArrayList<Issue>();
                }
                tempList.add(issue);
            }
        }
        //         Collections.sort(tempList);
        if (tempList == null) {
            return 0;
        }
        count = tempList.size() - 1;
        Issue temp = tempList.get(count);
        return temp.getInvNumber();
    }

    public ArrayList<Issue> searchInvNumber(long invNumber) {

        ArrayList<Issue> spisok = null;
        for (Issue issue : list) {

            if ((issue).getInvNumber() == invNumber) {
                if (spisok == null) {
                    spisok = new ArrayList<Issue>();
                }
                spisok.add(issue);
            }

        }
        if (spisok != null) {
            Collections.sort(spisok);
        }
        return spisok;
    }

//    public boolean deleteIssue(long invNumber) {
//        for (Issue issue : list) {
//            if ((issue).getInvNumber() == invNumber) {
//            return   (list.remove(issue));
//            }
//        }return false;
//    }

    public ArrayList<Issue> searchInStorage(long invNumber) {

        ArrayList<Issue> spisok = null;
        for (Issue issue : list) {

            if (((issue).getInvNumber() == invNumber) && (issue.isAvailable())) {
                if (spisok == null) {
                    spisok = new ArrayList<Issue>();
                }
                spisok.add(issue);

            }

        }
        if (spisok != null) {
            Collections.sort(spisok);
        }
        return spisok;
    }

    public boolean IsAvailable(long invNumber) {
        for (Issue issue : list) {
            if (issue.getInvNumber() == invNumber) {
                return issue.isAvailable();
            }
        }
        return false;
    }

    public boolean takeIssue(long invNumber) {
        for (Issue issue : list) {
            if (issue.getInvNumber() == invNumber) {
                return issue.takeIssue();
            }
        }

        return false;
    }

    public boolean returnIssue(long invNumber) {
        for (Issue issue : list) {
            if (issue.getInvNumber() == invNumber) {
                if (issue.isTaken()) {
                    issue.returnIssue();
                    return true;
                }
            }
        }

        return false;
    }

    public Issue getIssue(long invNumber) {
        for (Issue issue : list) {
            if (issue.getInvNumber() == invNumber) {
                return issue;
            }
        }
        return null;
    }

    public void countByTypes() {
        int countBooks = 0;
        int countJournals = 0;
        int countNewspaper = 0;
        for (Issue is : list) {
            switch (is.typeName()) {
                case "Book":
                    countBooks++;
                    break;
                case "Journal":
                    countJournals++;
                    break;
                case "Newspaper":
                    countNewspaper++;
                    break;
            }
        }
        System.out.println("Library contains: ");

        System.out.println(" Books          : " + countBooks + "\n"
                + " Magazines      : " + countJournals + "\n"
                + " Newspapers     : " + countNewspaper);
        System.out.println();

    }

    public void sort() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
        String str = "";
        for (Issue issue : list) {
            str += issue.toString() + "\r\n";
        }

        return str;
    }

//    public void printLibrary() {
//        System.out.println(this);
//
//    }
    private void readFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                //  System.out.println(line);
                String[] arrTemp = line.split(";");
                if (arrTemp.length > 1) {
                    addIssueToList(arrTemp);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            try {
                br.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            //  e.printStackTrace();
        }
    }

    private void addIssueToList(String[] temp) {
        String type = temp[0].trim();
        Issue issue = null;

        try {
            switch (type) {
                case "Book":
                    issue = new Book(
                            temp[2].trim(), temp[3].trim(),
                            Short.parseShort(temp[4].trim()),
                            Long.parseLong(temp[1].trim()));
                    break;

                case "Journal":
                    issue = new Journal(
                            temp[2].trim(), temp[3].trim(),
                            temp[4].trim(), temp[5], Long.parseLong(temp[1].trim()));
                    break;
                case "Newspaper":

                    break;

                default:
                    System.out.println("Unknown type: " + type);
                    break;
            }
        } catch (Exception exc) {
            System.out.println(temp);
            System.out.println(exc.getMessage());
        }

        if (issue != null) {
            list.add(issue);
        }

    }

}
