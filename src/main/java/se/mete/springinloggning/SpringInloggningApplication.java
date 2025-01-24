package se.mete.springinloggning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Annotation to make this class spring boot application
@SpringBootApplication
public class SpringInloggningApplication {
    public static void main(String[] args) {
        /**
         * .run is a static method of SpringApplication class
         *
         * @param source = class to run as starting point / main method
         * @param args = Command-line arguments
         */
        SpringApplication.run(SpringInloggningApplication.class, args);
    }

}
