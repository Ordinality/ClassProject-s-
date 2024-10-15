import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * this is the class where the user's account details are stored in
 */
public class User {
    // field for storing username
    public String username;
    // field for storing password
    public String password;
    // field for storing email
    public String email;
    // field for storing birthday date
    public String birthday;
    // field for storing gender
    public String gender;

    // field that stores the max number of characters in username
    public static final int MAX_USERNAME_LENGTH = 20;
    // field that stores the max number of characters in password
    public static final int MAX_PASSWORD_LENGTH = 20;
    // date formatter field
    public static final DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    // List that stores all the users registered so far
    public static List<User> registeredUsers = new ArrayList<>();
    /**
     * constructor for new user with these fields
     * 
     * @param username username
     * @param password password
     * @param email email
     * @param birthday birthday
     * @param gender gender
     */
    public User(String username, String password, String email, String birthday, String gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }
    /**
     * main method where registration and login happens to send the user to main dashboard
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User newUser = registration();
        System.out.println("Registration completed");
        
        User loggedInUser = login();
        if (loggedInUser != null) {
            System.out.println("Login successful.");
            HomeScreen.displayDashboard(loggedInUser);
        } else {
            System.out.println("Login credentials don't match. Try again.");
        }
    }
    /**
     * Method that supports registration of new users
     * 
     * @return
     */
    public static User registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registration");
        String username = getValidUsername(scanner);
        String password = getValidPassword(scanner);
        String email = getEmail(scanner);
        String birthday = getValidBirthday(scanner);
        String gender = getGender(scanner);
        User newUser = new User(username, password, email, birthday, gender);
        registeredUsers.add(newUser);
        return newUser;
    }

    /**
     * method that supports user login
     * 
     * @return
     */
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login");
        System.out.print("Username: ");
        String enterUsername = scanner.nextLine();
        System.out.print("Password: ");
        String enterPassword = scanner.nextLine();
        for (User user : registeredUsers) {
            if (user.getUsername().equals(enterUsername) && user.getPassword().equals(enterPassword)) {
                return user;
            }
        }
        return null;
    }
    /**
     * sets limitations to how long username can be
     * @param scanner
     * @return
     */
    public static String getValidUsername(Scanner scanner) {
        String username;
        do {
            System.out.print("Enter Username: ");
            username = scanner.nextLine();
        } while (username.length() > MAX_USERNAME_LENGTH);
        return username;
    }
    /**
     * sets limits to how long password can be
     * 
     * @param scanner
     * @return
     */
    public static String getValidPassword(Scanner scanner) {
        String password;
        do {
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
        } while (password.length() > MAX_PASSWORD_LENGTH);
        return password;
    }
    /**
     * allows retrieval of email 
     * 
     * @param scanner
     * @return
     */
    public static String getEmail(Scanner scanner) {
        System.out.print("Enter Email: ");
        return scanner.nextLine();
    }
    /**
     * allows for retrieval of birthday date
     * 
     * @param scanner
     * @return
     */
    public static String getValidBirthday(Scanner scanner) {
        String birthday;
        do {
            System.out.print("Enter Birthday (MM/dd/yyyy): ");
            birthday = scanner.nextLine();
        }
        while (!isValidBirthday(birthday));
 
        return birthday;
    }
    /**
     * sets limitations for a valid birthday date entered into the console
     * @param birthday
     * @return
     */
    public static boolean isValidBirthday(String birthday) {
        try {
            LocalDate.parse(birthday, PARSE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid birthdate. Try again.");
            return false;
        }
    }
    /**
     * method which retrieves gender
     * 
     * @param scanner
     * @return
     */
    public static String getGender(Scanner scanner) {
        System.out.print("Enter Gender: ");
        return scanner.nextLine();
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    
    /**
     * method to allow for return to home page after operations conclude
     */
    public void handleReturnToHomePage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Return to Home Page? (Y/N): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            HomeScreen.displayDashboard(this);
        } else {
            System.out.print("Exiting screen. ");
            System.exit(0);
        }
    }
    /**
     * enables the user to return to welcome page
     */
    public void handleReturnToWelcomePage() {
        System.out.println("Returning to Welcome Page ");
        WelcomeScreen.displayWelcomeScreen();
    }
    /**
     * method to enable user to update their profile details
     * 
     */
    public void updateProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Update Profile");

        System.out.print("Enter new Email: ");
        String newEmail = scanner.nextLine();
        setEmail(newEmail);

        String newBirthday;
        do {
            System.out.print("Enter new Birthday (MM/dd/yyyy): ");
            newBirthday = scanner.nextLine();
        } while (!isValidBirthday(newBirthday));
        setBirthday(newBirthday);

        System.out.print("Enter new Gender: ");
        String newGender = scanner.nextLine();
        setGender(newGender);

        System.out.println("Profile updated successfully.");
    }

    /**
     * sets new email 
     * 
     * @param email new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * sets new birthday date
     * 
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    /**
     * sets new gender
     * 
     * @param gender new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }


}