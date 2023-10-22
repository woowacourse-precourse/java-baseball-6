package baseball.domain.command.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandValidatorTest {

    @DisplayName("잘못된 명령어를 입력하면 예외가 발생한다.")
    @Test
    void validate() {
        Integer noneCommand = 3;

        Assertions.assertThatThrownBy(() -> CommandValidator.validate(noneCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
