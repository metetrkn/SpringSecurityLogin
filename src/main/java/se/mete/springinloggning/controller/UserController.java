package se.mete.springinloggning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.mete.springinloggning.service.UserService;

/**
 * Controller class to handle HTTP requests and return views.
 * This class maps incoming requests to specific views (HTML pages).
 */
@Controller // Marks this class as a Spring MVC controller
public class UserController {

    // Constructor injection of the UserService bean
    @Autowired
    private final UserService userService;

    /**
     * Constructor for dependency injection.
     *
     * @param userService The UserService bean to be injected
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles requests to the root URL ("/").
     * Redirects to the welcome page.
     *
     * @return A redirect to the "/welcome" endpoint
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/welcome"; // Redirects to the welcome page
    }

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

    /**
     * Handles requests to the "/login" URL.
     * Returns the login view.
     *
     * @return The name of the login HTML file (login.html)
     */
    @GetMapping("/login")
    public String login() {
        return "login"; // Returns the login.html view
    }
}