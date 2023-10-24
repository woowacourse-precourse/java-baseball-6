package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.model.BaseballNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberBaseballGameInputViewTest {


    private NumberBaseballGameInputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new NumberBaseballGameInputView(new ConsoleInputProvider());
    }

    @Test
    void readUserInput_3자리_입력값_테스트() {
        String input = "123\n";
        try (InputStreamProvider provider = new InputStreamProvider()) {
            provider.setInputStreamFrom(input);
            BaseballNumber userInput = inputView.readUserInput();
            assertEquals("123", userInput.value());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "abc", "", " "})
    void readUserInput_다양한_입력값_예외_테스트(String input) {
        try (InputStreamProvider provider = new InputStreamProvider()) {
            provider.setInputStreamFrom(input);
            assertThrows(IllegalArgumentException.class, inputView::readUserInput);
        }
    }


}