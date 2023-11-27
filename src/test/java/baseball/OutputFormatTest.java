package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.view.OutputFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OutputFormatTest {

    @Test
    void 개수에_따른_출력_형식_테스트_볼_스트라이크() {
        String format = OutputFormat.getFormat(1, 1, 0);
        assertThat(format).isEqualTo("1볼 1스트라이크");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 개수에_따른_출력_형식_테스트_볼(int ballCount) {
        String format = OutputFormat.getFormat(0, ballCount, 0);
        assertThat(format).isEqualTo(ballCount + "볼");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 개수에_따른_출력_형식_테스트_스트라이크(int strikeCount) {
        String format = OutputFormat.getFormat(strikeCount, 0, 0);
        assertThat(format).isEqualTo(strikeCount + "스트라이크");
    }

    @Test
    void 개수에_따른_출력_형식_테스트_낫싱() {
        int outCount = 3;
        String format = OutputFormat.getFormat(0, 0, outCount);
        assertThat(format).isEqualTo("낫싱");
    }
}