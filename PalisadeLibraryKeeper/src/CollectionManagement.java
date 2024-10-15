import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * this class allows for the management of book collections
 */
public class CollectionManagement {
    // an ArrayList to store book collections and their book data
    private static List<List<Book>> collections = new ArrayList<>();
    /**
     * sets the list of books as the library
     * @param library
     */
    public static void setLibrary(List<Book> library) {
        if (collections.isEmpty()) {
            collections.add(new ArrayList<>(library));
        }
        collections.get(0).clear();
        collections.get(0).addAll(library);
    }
    /**
     * retrieves the existing book collections
     * 
     * @return existing book collections
     */
    public static List<List<Book>> getCollections() {
        return collections;
    }
    /**
     * creates new book collection populated with book data 
     * and a name for each collection
     * 
     * @param loggedInUser the user that's currently logged in
     */
    public static void createCollection(User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        viewCollection(loggedInUser);
        System.out.println("Create Collection");
        System.out.print("Enter Collection Name: ");
        String collectionName = scanner.nextLine();
        System.out.println("Library Books: ");
        LibraryManagement.viewLibrary(loggedInUser);

        System.out.print("Instructions: Type in the number in which the book appears and hit enter to record each entry. Choose which books to add to the collection: ");
        boolean done = false;

        while (!done) {
            try {
                int bookNumber = Integer.parseInt(scanner.nextLine());

                if (bookNumber >= 1 && bookNumber <= LibraryManagement.getLibrary().size()) {
                    Book chosenBook = LibraryManagement.getLibrary().get(bookNumber - 1);
                    collections.get(0).add(new Book(chosenBook.getTitle(), chosenBook.getAuthor(), chosenBook.getYearPublished()));
                    System.out.println("Book added to collection: " + chosenBook.getTitle());
                } else if (bookNumber == 0) {
                    done = true;
                } else {
                    System.out.println("Invalid book number");
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }

            System.out.print("Instructions: Type in the number in which the book appears and hit enter to record each entry. Choose which books to add to the collection: ");
        }

        System.out.println("A new Collection has been created that's been named '" + collectionName + "'. Return to Home Page?");
        loggedInUser.handleReturnToHomePage();
    }
    /**
     * removes an existing collection
     * 
     * @param loggedInUser the user that's currently logged in
     */
    public static void removeCollection(User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        viewCollection(loggedInUser);
        System.out.print("Choose which collection to remove. Enter in the number on the list: ");
        int collectionNumber = scanner.nextInt();
        scanner.nextLine();

        if (collectionNumber >= 1 && collectionNumber <= collections.size()) {
            collections.remove(collectionNumber - 1);
            System.out.println("Collection successfully removed. Returning to Home Page");
        } else {
            System.out.println("Invalid collection number");
        }
        loggedInUser.handleReturnToHomePage();
    }
    /**
     * allows the user to view all existing collections
     * 
     * @param loggedInUser the user that's currently logged in
     */
    public static void viewCollection(User loggedInUser) {
        System.out.println("View Collections");

        // loops through all existing collections and their details
        for (int i = 0; i < collections.size(); i++) {
            List<Book> selectedCollection = collections.get(i);
            System.out.println((i + 1) + ") Collection '" + selectedCollection.get(0).getTitle() + "':");
            for (Book book : selectedCollection) {
                System.out.println("   Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Published in " + book.getYearPublished());
            }
            System.out.println();
        }

        System.out.println("Returning to Home Page");
        loggedInUser.handleReturnToHomePage();
    }
   
}
