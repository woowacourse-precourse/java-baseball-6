package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 입력받기() {
        User user = new User();
        user.setUserInputNumber(); // 123 입력
        assertThat(user.userInputNumber).isEqualTo("123");
    }

}