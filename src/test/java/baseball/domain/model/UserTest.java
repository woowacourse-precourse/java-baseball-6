package baseball.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("사용자 입력 123")
    void 사용자_입력을_객체로_저장() {
        String userInput = "123";
        Assertions.assertThat(new User(userInput)).isEqualTo(new User(List.of("1", "2", "3")));
    }

}