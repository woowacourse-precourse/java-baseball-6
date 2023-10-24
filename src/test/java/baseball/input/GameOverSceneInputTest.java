package baseball.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class GameOverSceneInputTest {

    @Test
    void getUserInput_입력값_반환() {
        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn("123");

            final GameOverSceneInput gameOverSceneInput = new GameOverSceneInput();
            assertThat(gameOverSceneInput.getUserInput()).contains("123");
        }
    }
}
