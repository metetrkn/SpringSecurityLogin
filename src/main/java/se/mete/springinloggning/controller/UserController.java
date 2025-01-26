package se.mete.springinloggning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class to handle HTTP requests and return views.
 * This class maps incoming requests to specific views (HTML pages).
 */
@Controller // Marks this class as a Spring MVC controller
public class UserController {

    /**
     * Handles requests to the "/welcome" URL.
     * Returns the welcome view.
     *
     * @return The name of the welcome HTML file (welcome.html)
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome"; // Returns the welcome.html view
    }
}