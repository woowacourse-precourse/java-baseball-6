package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
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
}