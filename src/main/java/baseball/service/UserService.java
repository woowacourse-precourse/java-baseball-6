package baseball.service;

import baseball.domain.User;
import baseball.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* 유저 등록 */
    public Long join(User user){
        userRepository.save(user);

        return user.getId();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
