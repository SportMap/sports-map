package pl.edu.pja.sportsmap.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.persistence.dao.UserRepository;
import pl.edu.pja.sportsmap.persistence.model.User;

import java.util.Optional;

@Service

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getNicknameById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(User::getNickname).orElse(null);
    }
    public String getAvatarById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(User::getAvatar).orElse(null);
    }
}
