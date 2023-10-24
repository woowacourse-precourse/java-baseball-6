package baseball.repository;

import baseball.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryUserRepositoryTest {
    MemoryUserRepository repository = new MemoryUserRepository();

    @AfterEach
    public void afterEach() { repository.clearStore();}

    @Test
    public void save(){
        User user = new User();
        user.setName("username");

        repository.save(user);

        User result = repository.findById(user.getId()).get();
        assertThat(user).isEqualTo(result);
    }
}