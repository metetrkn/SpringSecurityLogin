package se.mete.springinloggning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.mete.springinloggning.Service.UserService;

/**
 * Controller to retrieve HTTP request from client and returns response (view)
 */
@Controller
public class UserController {
    // Constructor injection
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Response to HTTP requests to  base url "localhost:8080"
     *
     * @return String = returns the corresponding of  the name of HTML file
     */
    @GetMapping("/")
    public String welcoming() {
        return "welcome";
    }
}
