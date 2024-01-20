package pl.edu.pja.sportsmap.filter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.edu.pja.sportsmap.persistence.model.User;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) {
        Long userId = ((User) authentication.getPrincipal()).getId();
        Cookie userIdCookie = new Cookie("userId", userId.toString());
        userIdCookie.setHttpOnly(true);
        userIdCookie.setPath("/");
        response.addCookie(userIdCookie);
    }
}