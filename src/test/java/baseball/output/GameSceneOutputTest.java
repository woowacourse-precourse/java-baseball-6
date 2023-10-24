package baseball.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import org.junit.jupiter.api.Test;

public class GameSceneOutputTest extends PrintOutputTest {
    @Test
    void 숫자_입력_메시지_출력() {
        final GameSceneOutput gameSceneOutput = new GameSceneOutput();
        gameSceneOutput.printInputMessage();
        assertThat(output()).contains("숫자를 입력해주세요 : ");
    }
}
