import java.util.*;

public class VaultManager {
    private List<PasswordEntry> vault;
    private Scanner sc;

    public VaultManager() {
        this.vault = SecureStorage.loadVault();
        this.sc = new Scanner(System.in);
    }

    public void addPassword() {
        System.out.print("Enter website: ");
        String website = sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        String encryptedPassword = EncryptionUtil5.encrypt(password);
        vault.add(new PasswordEntry(website, username, encryptedPassword));
        SecureStorage.saveVault(vault);
        System.out.println("✅ Password Added Securely!");
    }

    public void retrievePassword() {
        System.out.print("Enter website to retrieve password: ");
        String website = sc.nextLine();

        for (PasswordEntry entry : vault) {
            if (entry.getWebsite().equalsIgnoreCase(website)) {
                String decryptedPassword = EncryptionUtil5.decrypt(entry.getEncryptedPassword());
                System.out.println("\n🔑 Password for " + entry.getWebsite() + ": " + decryptedPassword);
                return;
            }
        }
        System.out.println("❌ No password found for this website.");
    }

    public void updatePassword() {
        System.out.print("Enter website to update password: ");
        String website = sc.nextLine();

        for (PasswordEntry entry : vault) {
            if (entry.getWebsite().equalsIgnoreCase(website)) {
                System.out.print("Enter new password: ");
                String newPassword = sc.nextLine();
                entry.setEncryptedPassword(EncryptionUtil5.encrypt(newPassword));
                SecureStorage.saveVault(vault);
                System.out.println("✅ Password Updated Successfully!");
                return;
            }
        }
        System.out.println("❌ No password found for this website.");
    }

    public void deletePassword() {
        System.out.print("Enter website to delete password: ");
        String website = sc.nextLine();

        Iterator<PasswordEntry> iterator = vault.iterator();
        while (iterator.hasNext()) {
            PasswordEntry entry = iterator.next();
            if (entry.getWebsite().equalsIgnoreCase(website)) {
                iterator.remove();
                SecureStorage.saveVault(vault);
                System.out.println("✅ Password Deleted Successfully!");
                return;
            }
        }
        System.out.println("❌ No password found for this website.");
    }
}
