package pl.edu.pja.sportsmap.dto;

import jakarta.validation.constraints.NotNull;

public record SignUpDto(
        @NotNull(message = "Username cannot be null")
        String username,
        @NotNull(message = "Email cannot be null")
        String email,
        @NotNull(message = "Password cannot be null")
        String password
) {
}
