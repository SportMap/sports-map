package pl.edu.pja.sportsmap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.pja.sportsmap.dto.LoginDto;
import pl.edu.pja.sportsmap.dto.SignUpDto;
import pl.edu.pja.sportsmap.exception.BadRequestException;
import pl.edu.pja.sportsmap.persistence.model.User;
import pl.edu.pja.sportsmap.service.UserService;

import java.io.IOException;
import java.net.URI;

@RestController
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final AuthenticationSuccessHandler successHandler;
    private final SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();

    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, AuthenticationSuccessHandler successHandler) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.successHandler = successHandler;
    }

    @PostMapping("login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Authentication authentication;
        try {
            authentication = authenticateUser(loginDto.username(), loginDto.password());
        } catch (AuthenticationException ex) {
            String username = userService.getUsernameByEmail(loginDto.username());
            authentication = authenticateUser(username, loginDto.password());
        }
        setAuthenticationContext(request, response, authentication);
        return ResponseEntity.ok().build();
    }

    @PostMapping("signup")
    public ResponseEntity<Void> registerUser(@RequestBody SignUpDto signUpDto, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(userService.usernameExists(signUpDto.username())){
            throw new BadRequestException("Username already exists");
        }
        if(userService.existsByEmail(signUpDto.email())){
            throw new BadRequestException("User with this email already exists");
        }
        User newUser = userService.createNewUser(signUpDto);
        URI location = ServletUriComponentsBuilder.fromUriString("users")
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        Authentication authentication = authenticateUser(signUpDto.username(), signUpDto.password());
        setAuthenticationContext(request, response, authentication);
        return ResponseEntity.created(location).build();
    }

    private void setAuthenticationContext(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);
        successHandler.onAuthenticationSuccess(request, response, authentication);
    }

    private Authentication authenticateUser(String username, String password) {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
