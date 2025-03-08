import java.io.*;
import java.util.*;

public class SecureStorage {
    private static final String FILE_PATH = "vault.txt";

    public static void saveVault(List<PasswordEntry> vault) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(vault);
        } catch (IOException e) {
            System.out.println("❌ Error saving vault data.");
        }
    }

    public static List<PasswordEntry> loadVault() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<PasswordEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
