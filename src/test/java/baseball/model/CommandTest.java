package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTest {

    @DisplayName("1 또는 2가 아닌 명령일 경우 예외가 발생한다.")
    @Test
    void findCommandEx() {
        assertThatThrownBy(() -> Command.find("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
