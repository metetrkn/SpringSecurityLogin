package se.mete.springinloggning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.mete.springinloggning.service.UserService;

@Controller
public class UserManagementController {

    @Autowired
    private UserService userService;

    @GetMapping("/create-user")
    public String showCreateUserForm() {
        return "create-user";
    }

    @PostMapping("/create-user")
    public String createUser(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String role,
                           RedirectAttributes redirectAttributes) {
        try {
            userService.createUser(username, password, role);
            redirectAttributes.addFlashAttribute("message", "User created successfully!");
            return "redirect:/create-user";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/create-user";
        }
    }
}
