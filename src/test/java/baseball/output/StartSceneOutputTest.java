package baseball.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class StartSceneOutputTest extends PrintOutputTest {
    @Test
    void 시작_메시지_출력() {
        final StartSceneOutput startSceneOutput = new StartSceneOutput();
        startSceneOutput.printStartMessage();
        assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
    }
}
