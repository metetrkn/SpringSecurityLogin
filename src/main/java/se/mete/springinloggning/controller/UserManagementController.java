package se.mete.springinloggning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.mete.springinloggning.service.UserService;


/**
 * Responsible to create new users
 * Interacts with UserService to do so
 */
@Controller // Marks this class as a Spring MVC controller
public class UserManagementController {
    // Constructor injection
    private final UserService userService;

    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Displays the form for creating a new user.
     *
     * @return The name of the create-user view template (e.g., create-user.html)
     */
    @GetMapping("/create-user") // Maps HTTP GET requests to the /create-user endpoint
    public String showCreateUserForm() {
        return "create-user";
    }

    /**
     * Handles the submission of the create-user form.
     * Creates a new user with the provided username, password, and role.
     *
     * @param username The username of the new user
     * @param password The password of the new user
     * @param role The role of the new user
     * @param redirectAttributes Used to add flash attributes for displaying messages after redirection
     * @return A redirect to the /create-user endpoint
     */
    @PostMapping("/create-user") // Maps HTTP POST requests to the /create-user endpoint
    public String createUser(@RequestParam String username, // Binds the username parameter from the form
                             @RequestParam String password, // Binds the password parameter from the form
                             @RequestParam String role, // Binds the role parameter from the form
                             RedirectAttributes redirectAttributes) { // Used to pass attributes after redirection

        try {
            // Attempt to create a new user using the UserService
            userService.createUser(username, password, role);
            // Add a success message to be displayed after redirection
            redirectAttributes.addFlashAttribute("message", "User created successfully!");
        } catch (RuntimeException e) {
            // If an error occurs, add the error message to be displayed after redirection
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        // Redirect back to the create-user page
        return "redirect:/create-user";
    }
}