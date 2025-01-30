package se.mete.springinloggning.config;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Set;


/**
 * Marks this class as a Spring component for auto-detection and dependency injection.
 * Implements AuthenticationSuccessHandler to define custom behavior after successful authentication,
 * such as redirecting the user or performing additional actions etc
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    // Logger for logging messages <Records events and messages>
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        // Convert the user's authorities (roles) into a Set of strings
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        // Log the user's roles for debugging purposes
        logger.info("User roles: {}", roles);

        // Default target URL for users with the ROLE_USER role
        String targetUrl = "/user";

        // Check if the user has the ROLE_MANAGER role
        if (roles.contains("ROLE_MANAGER")) {
            targetUrl = "/manager"; // Set the target URL to the manager page
            logger.info("Redirecting to manager page"); // Log the redirection
        }
        // Check if the user has the ROLE_ADMIN role
        else if (roles.contains("ROLE_ADMIN")) {
            targetUrl = "/admin"; // Set the target URL to the admin page
            logger.info("Redirecting to admin page"); // Log the redirection
        }
        // If the user has neither ROLE_MANAGER nor ROLE_ADMIN, assume ROLE_USER
        else {
            logger.info("Redirecting to user page"); // Log the redirection
        }

        // Log the final target URL before redirecting
        logger.info("Final target URL: {}", targetUrl);

        // Redirect the user to the appropriate page based on their role
        response.sendRedirect(targetUrl);
    }
}