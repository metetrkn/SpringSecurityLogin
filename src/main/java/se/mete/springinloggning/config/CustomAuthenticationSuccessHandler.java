package se.mete.springinloggning.config;

import jakarta.servlet.ServletException;
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

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        
        logger.info("User roles: " + roles);
        String targetUrl = "/user";

        if (roles.contains("ROLE_MANAGER")) {
            targetUrl = "/manager";
            logger.info("Redirecting to manager page");
        } else if (roles.contains("ROLE_ADMIN")) {
            targetUrl = "/admin";
            logger.info("Redirecting to admin page");
        } else {
            logger.info("Redirecting to user page");
        }

        logger.info("Final target URL: " + targetUrl);
        response.sendRedirect(targetUrl);
    }
}
