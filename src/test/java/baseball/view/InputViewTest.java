package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private final InputView inputView = new InputView();

    @DisplayName("숫자를 입력받는다.")
    @Test
    void inputNumber() {
        // given
        ByteArrayInputStream inContent = new ByteArrayInputStream("123".getBytes());
        System.setIn(inContent);

        // when
        String input = inputView.inputNumber();

        // then
        assertThat(input).isEqualTo("123");
    }

    @DisplayName("재시작 여부를 입력받는다.")
    @Test
    void inputRestartChoice() {
        // given
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);

        // when
        int input = inputView.inputRestartChoice();

        // then
        assertThat(input).isEqualTo(1);
    }

}