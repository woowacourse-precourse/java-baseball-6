package baseball.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void InputView_사용자정답_입력(String correctInput) {
        InputView inputView = new InputView();
        String input = correctInput;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String inputPlayersAnswer = inputView.readPlayersAnswer();

        Assertions.assertEquals(correctInput, inputPlayersAnswer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void InputView_게임재실행_입력(String correctInput) {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(correctInput.getBytes()));

        String inputPlayersContinue = inputView.readPlayersContinue();

        Assertions.assertEquals(correctInput, inputPlayersContinue);
    }
}
