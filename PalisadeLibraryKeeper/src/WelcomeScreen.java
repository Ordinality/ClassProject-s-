import java.util.Scanner;
/**
 * this is the class where the user starts out to register and then login
 * so they can be granted access to the rest of the system
 */
public class WelcomeScreen {
    public static void main(String[] args) {
        displayWelcomeScreen();
    }
    /**
     * displays the screen where the user has to go through the process
     * of registration and logging in
     */
    public static void displayWelcomeScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Palisade Library Keeper App!");
        System.out.println("1) Login"); 
        System.out.println("2) Signup");

        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();


        switch (choice) {
            case 1:
                User loggedInUser = User.login();
                if (loggedInUser != null) {
                    System.out.println("Login successful");
                    HomeScreen.displayDashboard(loggedInUser);
                } else {
                    System.out.println("Invalid login credentials. Try again.");
                }
                break;
            case 2: 
                User newUser = User.registration();
                System.out.println("Registration Completed.");
                newUser.handleReturnToWelcomePage();
                break;
            default: 
                System.out.println("Nonfunctional Option");
                System.exit(0);
            }   
    }
}
