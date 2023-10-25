package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private final InputView inputView = new InputView();

    @DisplayName("숫자를 입력받을때 숫자가 3자리가 아니면 Exception 발생한다.")
    @Test
    void inputNumberNotThreeDigitsThrowsException() {
        // given
        String input = "1234";

        // when // then
        assertThatThrownBy(() -> inputView.validateThreeDigitNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 3자리의 숫자를 입력하여야 합니다.");
    }

    @DisplayName("재시작 여부를 선택할 때 1 또는 2 가 아니면 Exception 발생한다.")
    @Test
    void validateIsOneOrTwo() {
        // given
        int choice = 3;
        // when // then
        assertThatThrownBy(() -> inputView.validateIsOneOrTwo(choice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 또는 2의 숫자만 선택해야 합니다.");
    }
}