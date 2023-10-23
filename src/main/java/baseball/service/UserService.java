package baseball.service;

import baseball.domain.User;
import baseball.repository.MemoryUserRepository;

import java.util.Optional;

public class UserService {
    private final MemoryUserRepository userRepository;


    public UserService(MemoryUserRepository memoryUserRepository) {
        this.userRepository = memoryUserRepository;
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
