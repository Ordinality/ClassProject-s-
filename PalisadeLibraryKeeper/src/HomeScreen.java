import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * the HomeScreen class implements the dashboard where specific operations
 * can be chosen by the logged in user
 */
public class HomeScreen {
    /**
     * the method displays the management dashboard to get operations started
     * 
     * @param loggedInUser
     */
    public static void displayDashboard(User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        // field that user alters to pick a specific operation
        int choice;
        List<Book> library = LibraryManagement.getLibrary();
        // do while field with switch cases for the eleven options
        do {
            System.out.println("Management Dashboard");
            System.out.println("0) Logout");
            System.out.println("1) Add Book To Library");
            System.out.println("2) Edit Book Data");
            System.out.println("3) Remove Book");
            System.out.println("4) Create Collection");
            System.out.println("5) Remove Collection");
            System.out.println("6) View Library");
            System.out.println("7) View Collection");
            System.out.println("8) Import Data");
            System.out.println("9) Export Data");
            System.out.println("10) Update Profile");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Logging out.");
                    System.exit(0);
                case 1:
                    LibraryManagement.addBook(loggedInUser);
                    break;
                case 2: 
                    LibraryManagement.editBookData(loggedInUser);
                    break;
                case 3:
                    LibraryManagement.removeBook(loggedInUser);
                    break;
                case 4:
                    CollectionManagement.createCollection(loggedInUser);
                    break;
                case 5:
                    CollectionManagement.removeCollection(loggedInUser);
                    break;
                case 6:
                    LibraryManagement.viewLibrary(loggedInUser);
                    break;
                case 7:
                    CollectionManagement.viewCollection(loggedInUser);
                    break;
                case 8:
                    FileTransfer.importBookData(loggedInUser, library);
                    break;
                case 9:
                    FileTransfer.exportBookData(loggedInUser, library);
                    break;
                case 10:
                    loggedInUser.updateProfile();
                    break;
                default: 
                    System.out.println("Invalid Option");
                    displayDashboard(loggedInUser);
            }
        } while (true);
    }
}
  


    

