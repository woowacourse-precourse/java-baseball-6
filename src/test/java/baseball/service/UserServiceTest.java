package baseball.service;

import baseball.domain.User;
import baseball.repository.MemoryUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    MemoryUserRepository memoryUserRepository;

    @BeforeEach
    public void beforeEach(){
        memoryUserRepository = new MemoryUserRepository();
        userService = new UserService();
    }

    @AfterEach
    public void afterEach(){
        memoryUserRepository.clearStore();
    }

    @Test
    public void join(){
        User user = new User();
        user.setName("name");

        Long saveId = userService.join(user);

        User result = userService.findOne(saveId).get();
        assertThat(user).isEqualTo(result);
    }
}