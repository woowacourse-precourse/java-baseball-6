package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

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

}
