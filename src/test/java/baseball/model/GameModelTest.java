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
}