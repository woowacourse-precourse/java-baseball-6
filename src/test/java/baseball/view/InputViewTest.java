package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    void userInput(String input) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
    }

    @Test
    void 숫자_입력_변환_테스트() {
        userInput("234");
        int userNumbers = InputView.getUserNumbers();
        assertThat(userNumbers).isEqualTo(234);
    }

    @Test
    void 문자_포함_예외_테스트() {
        userInput("a34");

        Exception e = assertThrows(IllegalArgumentException.class, InputView::getUserNumbers);
        assertThat(e.getClass()).isEqualTo((IllegalArgumentException.class));
        assertThat(e.getMessage()).isEqualTo("숫자를 입력해주세요.");
    }
}
