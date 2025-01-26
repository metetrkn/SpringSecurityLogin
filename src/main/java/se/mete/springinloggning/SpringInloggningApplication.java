package se.mete.springinloggning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Spring Boot, entry point for the app
 * Annotation which makes this class Spring App
 */
@SpringBootApplication
public class SpringInloggningApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command-line args to app
     */
    public static void main(String[] args) {
        /**
         * SpringApplication.run() is a static method of the SpringApplication class.
         * It is bootstrap for Spring Boot apps
         *
         * @param source The primary source class (this class) to run as the starting point
         * @param args Command-line arguments passed to the application
         */
        SpringApplication.run(SpringInloggningApplication.class, args);
    }
}