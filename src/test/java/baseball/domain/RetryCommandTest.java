package baseball.domain;

import baseball.constant.RetryCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RetryCommandTest {

    @Test
    @DisplayName("1, 2이외의 숫자를 입력할 경우 예외 발생")
    void validateRange() {
        int input = 3;
        assertThatThrownBy(() -> RetryCommand.getRetryCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1을 입력할 경우 재시작")
    void getRetryCommand() {
        int input = 1;

        RetryCommand retryCommand = RetryCommand.getRetryCommand(input);

        assertThat(retryCommand).isEqualTo(RetryCommand.RETRY);
    }
}
