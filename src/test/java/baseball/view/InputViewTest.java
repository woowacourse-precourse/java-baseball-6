package baseball.view;

import static baseball.view.InputValidator.EXIT;
import static baseball.view.InputValidator.RESTART;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.service.DoubleConsoleService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    public static final int RESTART_NUMBER = 1;
    public static final int EXIT_NUMBER = 2;

    @DisplayName("서로 다른 세자리수를 입력한다")
    void inputThreeDifferentNumbers() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService("123"), new InputValidator());

        // when
        List<Integer> result = inputView.inputTryNumber();

        // then
        assertThat(result).isEqualTo(List.of(1, 2, 3));
    }

    @ParameterizedTest
    @DisplayName("서로 다른 세자리수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"102", "suz", "1&%", "1234", "12", "155"})
    void inputError(String given) {
        // given
        InputView inputView = new InputView(new DoubleConsoleService(given), new InputValidator());

        // when // then
        assertThatThrownBy(inputView::inputTryNumber)
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시작을 위해 1을 입력한다")
    void inputOneForRestart() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService(RESTART), new InputValidator());

        // when
        int result = inputView.restartOrExit();

        // then
        assertThat(result).isEqualTo(RESTART_NUMBER);
    }

    @Test
    @DisplayName("종료를 위해 2를 입력한다.")
    void inputTwoForExit() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService(EXIT), new InputValidator());

        // when
        int result = inputView.restartOrExit();

        // then
        assertThat(result).isEqualTo(EXIT_NUMBER);
    }
}
