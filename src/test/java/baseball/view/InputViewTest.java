package baseball.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    void userInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 숫자_입력_변환_테스트() {
        userInput("234");
        int userNumbers = InputView.getUserNumbers();
        assertThat(userNumbers).isEqualTo(234);
    }
 /*
    @Test
    void 게임_재시작_입력_테스트() {
        userInput("1");
        int userNumbers = InputView.getRestart();
        assertThat(userNumbers).isEqualTo(1);
    }
 */
}
