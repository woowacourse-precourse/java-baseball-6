package baseball;

import baseball.View.BaseballGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    void 게임_클리어유저_입력_정상() {
        String simulatedUserInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        int result = baseballGame.readEndUserInput();

        assertThat(result).isEqualTo(1);
    }
    @Test
    void 게임_클리어유저_입력_오류_후_정상() {
        String simulatedUserInput = "invalid\n1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        BaseballGame baseBallGame = new BaseballGame();

        int result = baseBallGame.readEndUserInput();

        assertThat(result).isEqualTo(1);
    }
}
