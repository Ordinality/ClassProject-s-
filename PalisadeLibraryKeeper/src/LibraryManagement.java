import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * the LibraryManagement class is in charge of establishing the library as a List
 */
public class LibraryManagement {
    public static List<Book> library = new ArrayList<>();
    public static void main(String[] args) {
        User loggedInUser = User.login();
        if (loggedInUser != null) {
            System.out.println("Login successful");
            HomeScreen.displayDashboard(loggedInUser);
        } else {
            System.out.println("Invalid credentials. Try again.");
    }
    }
    /**
     * getter method for the library List
     * 
     * @return
     */
    public static List<Book> getLibrary() {
        return library;
    }
    /**
     * allows for the adding of new book entries
     * 
     * @param loggedInUser
     */
    public static void addBook(User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Book");
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Year of Publication: ");
        int yearPublished = scanner.nextInt();
        Book newBook = new Book(title, author, yearPublished);
        library.add(newBook);
        System.out.println("Book added successfully. Returning to Home Page?");
        loggedInUser.handleReturnToHomePage();
    }
    /**
     * method enables user to edit either the title, author, or year of publishing
     * applies to an existing book entry only
     * @param loggedInUser
     */
    public static void editBookData(User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit Book Data");
        viewLibrary(loggedInUser);
        System.out.print("Select which book to edit by entering their number in: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();
        if (bookNumber >= 1 && bookNumber <= LibraryManagement.getLibrary().size()) {
            Book bookEdit = LibraryManagement.getLibrary().get(bookNumber - 1);
            System.out.println("Choose from these options:");
            System.out.println("1) Edit Title");
            System.out.println("2) Edit Author");
            System.out.println("3) Edit Year Published");
            System.out.print("Enter your choice: ");
            int editChoice = scanner.nextInt();
            scanner.nextLine();
 
            switch (editChoice) {
                case 1:
                    System.out.print("Edit Title: ");
                    String newTitle = scanner.nextLine();
                    bookEdit.setTitle(newTitle);
                    break;
                case 2:
                    System.out.print("Edit Author: ");
                    String newAuthor = scanner.nextLine();
                    bookEdit.setAuthor(newAuthor);
                    break;
                case 3:
                    System.out.print("Edit Year Published: ");
                    int newyear = scanner.nextInt();
                    scanner.nextLine();
                    bookEdit.setyearPublished(newyear);
                    break;
                default:
                    System.out.println("No changes made ");

            }
            System.out.println("Book data successfully updated. Return to Home Page?");
        } else {
            System.out.println("Invalid book number.");
        }
        loggedInUser.handleReturnToHomePage();
    }
    /**
     * method allows for the removal of existing book entries
     * 
     * @param loggedInUser
     */
    public static void removeBook(User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remove Book");
        viewLibrary(loggedInUser);
        System.out.print("Choose which entry to remove. Enter in the number on the list: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();
        if (bookNumber >= 1 && bookNumber <= library.size()) {
            Book removedBook = library.remove(bookNumber - 1);
            System.out.println("Book successfully removed. Return to Home Page?");
        } else {
            System.out.println("Invalid book number");
        }
        loggedInUser.handleReturnToHomePage();
    }
    /**
     * method allows for the viewing of existing book entries
     * 
     * @param loggedInUser
     */
    public static void viewLibrary(User loggedInUser) {
        List<Book> library = LibraryManagement.getLibrary();
        System.out.println("Library");
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            System.out.println((i+1) + ")" + book.getTitle() + " by " + book.getAuthor() + ", Published in " + book.getYearPublished());     
    }
}
    
}

