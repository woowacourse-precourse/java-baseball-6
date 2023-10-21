package baseball.domain.restartflag;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[RestartFlagTest]")
class RestartFlagTest {

    private static final String ERROR_MESSAGE_WRONG_INPUT = "1 혹은 2만 입력해 주세요.";

    @Test
    @DisplayName("1이 입력되었을 때 isRestart()가 true를 반환한다.")
    void isRestartReturnTrueWhenInputValueIsOne() {
        // given
        int input = 1;

        // when
        RestartFlag restartFlag = new RestartFlag(1);

        // then
        assertThat(restartFlag.isRestart()).isEqualTo(true);
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(ints = {0, 3})
    @DisplayName("1,2 외에 다른 값이 입력되었을 때 IllegalArgumentException을 발생한다.")
    void throwsIllegalArgumentExceptionWhenInvalidInput(final int input) {
        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new RestartFlag(input));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_WRONG_INPUT);
    }
}