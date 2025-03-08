import java.util.Scanner;

public class VaultApp {
    private static VaultManager vaultManager = new VaultManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🔐 Welcome to Password Vault 🔐");

        while (true) {
            System.out.println("\n1. Add Password");
            System.out.println("2. Retrieve Password");
            System.out.println("3. Update Password");
            System.out.println("4. Delete Password");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    vaultManager.addPassword();
                    break;
                case 2:
                    vaultManager.retrievePassword();
                    break;
                case 3:
                    vaultManager.updatePassword();
                    break;
                case 4:
                    vaultManager.deletePassword();
                    break;
                case 5:
                    System.out.println("Exiting... Stay Secure! 🔒");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
