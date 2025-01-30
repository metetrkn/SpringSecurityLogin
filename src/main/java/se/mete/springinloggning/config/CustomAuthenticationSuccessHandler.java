package se.mete.springinloggning.config;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Set;


/**
 * Marks this class as a Spring component for auto-detection and dependency injection.
 * Implements AuthenticationSuccessHandler interface to define custom behavior after successful authentication,
 * such as redirecting the user or performing additional actions etc
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * onAuthenticationSuccess abstract method of AuthenticationSuccessHandler interface that must be implemented
     * It checks the roles assigned to the authenticated user and redirects them
     * to a different page based on their role.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        // Roles set contains all roles <USER, ADMIN, MANAGER>
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        // Default target URL for users with the ROLE_USER role
        String targetUrl;

        // Check for the highest-priority role first
        if (roles.contains("ROLE_ADMIN")) {
            targetUrl = "/admin";
        } else if (roles.contains("ROLE_MANAGER")) {
            targetUrl = "/manager";
        } else {
            targetUrl = "/user";
        }

        // Redirect the user to the appropriate page based on their role
        response.sendRedirect(targetUrl);
    }
}

