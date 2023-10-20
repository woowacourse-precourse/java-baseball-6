package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 입력받기() {
        User user = new User("123"); // 123 으로 test

        assertThat(user.userInputNumber).isEqualTo("123");
    }

}