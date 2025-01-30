package se.mete.springinloggning.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class encodes passwords with BCrypt that can be stored in the database.
 */
public class PasswordEncoderUtil {

    /**
     * Main method to demonstrate password encoding.
     * This method encodes a raw password using BCrypt and prints the encoded password.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a BCryptPasswordEncoder instance
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Define a raw password to encode
        String rawPassword = "password"; // Replace with the actual password

        // Encode the raw password using BCrypt
        String encodedPassword = encoder.encode(rawPassword);

        // Print the encoded password to the console
        System.out.println("Encoded Password: " + encodedPassword);
    }
}