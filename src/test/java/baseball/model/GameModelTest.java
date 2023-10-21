package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GameInputValid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameModelTest {

    private GameModel gameModel;

    @BeforeEach
    public void setUp() {
        GameInputValid gameInputValid = new GameInputValid();
        gameModel = new GameModel(gameInputValid);
    }

    @DisplayName("사용자가 숫자를 입력한다.")
    @Test
    public void inputisNumeric() {
        //when
        String input = "123";

        //then
        assertDoesNotThrow(() -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    public void inputisNotNumeric() {
        //when
        String input = "abc";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 3자리 미만의 값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputLessThanRange() {
        //when
        String input = "12";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 3자리 초과의 값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputGreaterThanRange() {
        //when
        String input = "1234";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 0의 숫자값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputZeroValue() {
        //when
        String input = "012";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 Null(띄어쓰기)의 값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputNullPoint() {
        //when
        String input = "1 3";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }
}