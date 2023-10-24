package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballInputViewTest {
    private BaseballInputView baseballInputView;

    @BeforeEach
    public void setUp() {
        baseballInputView = new BaseballInputView();
    }

    @Test
    @DisplayName("유요한 입력일 경우")
    public void testUserGuessInputValid() {
        String userGuess = "123";
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> result = baseballInputView.userGuessInput(userGuess);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("유효하지 않은 길이의 입력일 경우")
    public void testUserGuessInputInvalidLength() {
        String userGuess = "12";
        assertThrows(IllegalArgumentException.class, () -> {
            baseballInputView.userGuessInput(userGuess);
        });
    }

    @Test
    @DisplayName("숫자를 입력하지 않은 입력일 경우")
    public void testUserGuessInputContainsNonDigit() {
        String userGuess = "12a";
        assertThrows(IllegalArgumentException.class, () -> {
            baseballInputView.userGuessInput(userGuess);
        });
    }

    @Test
    @DisplayName("중복되는 숫자가 있는 입력일 경우")
    public void testUserGuessInputContainsDuplicates() {
        String userGuess = "112";
        assertThrows(IllegalArgumentException.class, () -> {
            baseballInputView.userGuessInput(userGuess);
        });
    }

    @Test
    @DisplayName("유효한 사용자 진행 선택 입력일 경우")
    public void testUserProgressInputValid() {
        String userProgress = "1";
        int expected = 1;
        int result = baseballInputView.userProgressInput(userProgress);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("유효하지 않은 사용자 진행 선택 입력일 경우")
    public void testUserProgressInputInvalidChoice() {
        String userProgress = "3";
        assertThrows(IllegalArgumentException.class, () -> {
            baseballInputView.userProgressInput(userProgress);
        });
    }
}