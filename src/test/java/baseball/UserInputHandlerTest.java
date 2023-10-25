package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputHandlerTest {
    UserInputHandler userInputHandler;

    @BeforeEach
    void setUp() {
        userInputHandler = new UserInputHandler();
    }

    @Test
    void 정상입력() {
        String userInput = "123";
        assertThat(userInputHandler.validateUserGuessInput(userInput)).isEqualTo(true);
    }

    @Test
    void 예상숫자가_아닌_문자열_입력() {

        String userInput = "1234a";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예상숫자가_아닌_입력없음() {
        String userInput = "";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예상숫자가_아닌_공백_입력() {
        String userInput = "  ";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리_내_입력() {
        String userInput = "1234";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 에상숫자_제로_0_입력() {
        String userInput = "000023";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다시플레이_여부_제로_0_입력() {
        String userInput = "0000000";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다시플레이_여부_문자열값() {
        String userInput = "000abc";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예측_숫자_중복() {
        String userInput = "122";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열만_입력() {
        String userInput = "abc";
        assertThatThrownBy(() -> {
            boolean result = userInputHandler.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}