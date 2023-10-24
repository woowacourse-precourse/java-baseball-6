package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    private final NumberBaseballGameInputView inputView = new NumberBaseballGameInputView();
    private ByteArrayInputStream inContent;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    void readUserInput_3자리_입력값_테스트() {
        String input = "123\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        String userInput = inputView.readUserInput();
        assertEquals("123", userInput);
    }


}