package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberBaseballGameInputViewTest {

    private final InputStream originalIn = System.in;
    private NumberBaseballGameInputView inputView;
    private ByteArrayInputStream inContent;

    @BeforeEach
    void setUp() {
        inputView = new NumberBaseballGameInputView(new ConsoleInputProvider());;
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        Console.close();
    }

    @Test
    void readUserInput_3자리_입력값_테스트() {
        String input = "123\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        BaseballNumber userInput = inputView.readUserInput();
        assertEquals("123", userInput.value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "abc",""," "})
    void readUserInput_다양한_입력값_예외_테스트(String input) {
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        assertThrows(IllegalArgumentException.class, inputView::readUserInput);
    }


}