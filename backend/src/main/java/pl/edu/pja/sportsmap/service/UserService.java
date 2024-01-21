package pl.edu.pja.sportsmap.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.SignUpDto;
import pl.edu.pja.sportsmap.exception.NotFoundException;
import pl.edu.pja.sportsmap.persistence.dao.UserRepository;
import pl.edu.pja.sportsmap.persistence.model.Authority;
import pl.edu.pja.sportsmap.persistence.model.User;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String getNicknameById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(User::getUsername).orElse(null);
    }
    public String getAvatarById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(User::getAvatar).orElse(null);
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User createNewUser(SignUpDto signUpDto) {
        User user = convertToEntity(signUpDto);
        return userRepository.save(user);
    }

    public String getUsernameByEmail(String email) {
        Optional<String> username = userRepository.getUsernameByEmail(email);
        if (username.isEmpty()) {
            throw new NotFoundException("User with given email not found");
        }
        return username.get();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user.get();
    }

    private User convertToEntity(SignUpDto signUpDto) {
        User user = new User();
        user.setUsername(signUpDto.username());
        user.setEmail(signUpDto.email());
        user.setPassword(passwordEncoder.encode(signUpDto.password()));
        user.setAuthority(Authority.USER);
        return user;
    }
}
