package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputDeviceTest {

    public static final String RESTART_NUMBER = "1";
    public static final String EXIT_NUMBER = "2";

    @ParameterizedTest
    @DisplayName("서로 다른 세자리수를 입력한다")
    @ValueSource(strings = {"123", "167", "987", "764"})
    void inputThreeDifferentNumbers(String given) {
        // given
        InputDevice inputDevice = new InputDevice(new DoubleConsoleService(given), new InputValidator());

        // when
        List<Integer> result = inputDevice.inputTryNumber();

        // then
        assertThat(result).isEqualTo(List.of(1, 2, 3));
    }

    @ParameterizedTest
    @DisplayName("서로 다른 세자리수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"102", "suz", "1&%", "1234", "12", "155"})
    void inputError(String given) {
        // given
        InputDevice inputDevice = new InputDevice(new DoubleConsoleService(given), new InputValidator());

        // when // then
        assertThatThrownBy(inputDevice::inputTryNumber)
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시작을 위해 1을 입력한다")
    void inputOneForRestart() {
        // given
        InputDevice inputDevice = new InputDevice(new DoubleConsoleService(RESTART_NUMBER), new InputValidator());

        // when
        int result = inputDevice.restartOrExit();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("종료를 위해 2를 입력한다.")
    void inputTwoForExit() {
        // given
        InputDevice inputDevice = new InputDevice(new DoubleConsoleService(EXIT_NUMBER), new InputValidator());

        // when
        int result = inputDevice.restartOrExit();

        // then
        assertThat(result).isEqualTo(2);
    }
}
