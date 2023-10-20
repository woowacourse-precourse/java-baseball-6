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
        String s = inputView.inputNumber();

        // then
        assertThat(s).isEqualTo("123");
    }

}