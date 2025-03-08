public class PasswordEntry {
    private String website;
    private String username;
    private String encryptedPassword;

    public PasswordEntry(String website, String username, String encryptedPassword) {
        this.website = website;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public String getWebsite() { return website; }
    public String getUsername() { return username; }
    public String getEncryptedPassword() { return encryptedPassword; }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public String toString() {
        return "🌐 Website: " + website + " | 👤 Username: " + username + " | 🔐 [Password Encrypted]";
    }
}
