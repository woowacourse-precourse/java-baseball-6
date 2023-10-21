package baseball.domain.command.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandValidatorTest {

    @DisplayName("잘못된 명령어를 입력하면 예외가 발생한다.")
    @Test
    void validate() {
        Integer noneCommand = 3;

        assertThatThrownBy(() -> CommandValidator.validate(noneCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
