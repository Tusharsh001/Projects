import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    if (userManager.userExists(newUsername)) {
                        System.out.println("Username already exists. Please choose a different username.");
                    } else {
                        System.out.print("Enter password: ");
                        String newPassword = scanner.nextLine();
                        userManager.addUser(newUsername, newPassword);
                        System.out.println("Registration successful!");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    if (userManager.isValidUser(username, password)) {
                        System.out.println("Login successful!");
                        isLoggedIn = true;
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
      
    }
}
