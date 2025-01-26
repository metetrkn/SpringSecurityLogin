package se.mete.springinloggning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Spring Boot application.
 * This class serves as the entry point for the application.
 */
@SpringBootApplication // Marks this class as a Spring Boot application
public class SpringInloggningApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application
     */
    public static void main(String[] args) {
        /**
         * SpringApplication.run() is a static method of the SpringApplication class.
         * It bootstraps the Spring Boot application.
         *
         * @param source The primary source class (this class) to run as the starting point
         * @param args Command-line arguments passed to the application
         */
        SpringApplication.run(SpringInloggningApplication.class, args);
    }
}