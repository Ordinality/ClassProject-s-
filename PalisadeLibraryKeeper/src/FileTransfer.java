import java.io.*;
import java.util.List;
import java.util.Scanner;
/**
 * a class which is in charge of importing and exporting CSV files containing book data
 */
public class FileTransfer {
    /**
     * this allows for the importing of book data from a directory
     * 
     * @param loggedInUser the user that's currently logged in
     * @param library the List containing all book data
     */
    public static void importBookData(User loggedInUser, List<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Import Book Data");
        System.out.println("Please choose a CSV file to import");
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                int yearPublished = Integer.parseInt(parts[2].trim());

                Book newBook = new Book(title, author, yearPublished);
                library.add(newBook);
            }
            System.out.println("Library Updated.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error importing data. Please check the file format and try again");
        }
        loggedInUser.handleReturnToHomePage();
    }
    /**
     * this method allows for the exporting of book data into a single CSV file
     * 
     * @param loggedInUser the user that's currently logged in
     * @param library the List containing all book data
     */
    public static void exportBookData(User loggedInUser, List<Book> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the folder path for export: ");
        String folderPath = scanner.nextLine();

        String exportFilePath = folderPath + File.separator + "exportedbookdata.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(exportFilePath))) {
            for (Book book : library) {
                writer.println(book.getTitle() + " by " + book.getAuthor() + ", Published in " + book.getYearPublished());
            }
            System.out.println("Export successful to " + exportFilePath);
        } catch (IOException e) {
            System.out.println("Error exporting data");
        }

        loggedInUser.handleReturnToHomePage();
    }
}
