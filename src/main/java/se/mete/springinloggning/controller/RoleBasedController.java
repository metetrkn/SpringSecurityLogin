package se.mete.springinloggning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Returns login and role-based views
 */
@Controller // Marks this class as a Spring MVC controller
public class RoleBasedController {

    /**
     * Handles requests to the login page.
     *
     * @return The name of the login view template (e.g., login.html)
     */
    @GetMapping("/login") // Maps HTTP GET requests to the /login endpoint
    public String login(Model model, @RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout) {

        // If wrong credentials, gets this message on the screen
        if (error != null) {
            model.addAttribute("error", "Invalid username or password!");
        }

        // If logout successfully
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login"; // Returns the name of the login view template
    }


    /**
     * Handles requests to the user page.
     *
     * @return The name of the user view template (e.g., user.html)
     */
    @GetMapping("/user") // Maps HTTP GET requests to the /user endpoint
    public String userPage() {
        return "user";
    }


    /**
     * Handles requests to the admin page.
     *
     * @return The name of the admin view template (e.g., admin.html)
     */
    @GetMapping("/admin") // Maps HTTP GET requests to the /admin endpoint
    public String adminPage() {
        return "admin";
    }

    /**
     * Handles requests to the manager page.
     *
     * @return The name of the manager view template (e.g., manager.html)
     */
    @GetMapping("/manager") // Maps HTTP GET requests to the /manager endpoint
    public String managerPage() {
        return "manager";
    }
}