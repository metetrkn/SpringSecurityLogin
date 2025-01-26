package se.mete.springinloggning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Marks this class as a Spring MVC controller
public class RoleBasedController {

    /**
     * Handles requests to the login page.
     *
     * @return The name of the login view template (e.g., login.html)
     */
    @GetMapping("/login") // Maps HTTP GET requests to the /login endpoint
    public String login() {
        return "login"; // Returns the name of the login view template
    }

    /**
     * Handles requests to the user page.
     *
     * @return The name of the user view template (e.g., user.html)
     */
    @GetMapping("/user") // Maps HTTP GET requests to the /user endpoint
    public String userPage() {
        return "user"; // Returns the name of the user view template
    }

    /**
     * Handles requests to the admin page.
     *
     * @return The name of the admin view template (e.g., admin.html)
     */
    @GetMapping("/admin") // Maps HTTP GET requests to the /admin endpoint
    public String adminPage() {
        return "admin"; // Returns the name of the admin view template
    }

    /**
     * Handles requests to the manager page.
     *
     * @return The name of the manager view template (e.g., manager.html)
     */
    @GetMapping("/manager") // Maps HTTP GET requests to the /manager endpoint
    public String managerPage() {
        return "manager"; // Returns the name of the manager view template
    }
}