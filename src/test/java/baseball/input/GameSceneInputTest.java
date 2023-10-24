package baseball.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import baseball.game.GameConstants;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class GameSceneInputTest {

    private GameSceneInput gameSceneInput;

    @BeforeEach
    void before() {
        gameSceneInput = new GameSceneInput();
    }

    @Test
    void getUserInput_입력값_반환() {
        final String numberString = "123";

        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn("123");
            assertThat(gameSceneInput.getUserInput()).contains(numberString);
        }
    }

    @Test
    void 초기_개수와_다른_개수로_입력하면_IllegalArgumentException_예외() {
        String numberString = "";

        for (int i = 0; i < GameConstants.SIZE_RANDOM_NUMBER - 1; i++) {
            numberString += String.valueOf(i + 1);
        }

        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn(numberString);
            assertThatThrownBy(() -> gameSceneInput.getUserInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
