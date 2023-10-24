package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NarratorTest {

    Narrator narrator = new Narrator();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 볼_스트라이크_출력_스트라이크가_0일때_테스트() {

        Score score = new Score(0, 3);

        // "3볼" 로 출력되어야한다.
        narrator.isThreeStrike(score);

        Assertions.assertThat(output.toString().trim()).isEqualTo("3볼");
    }

    @Test
    void 볼_스트라이크_출력_볼이_0일때_테스트() {

        Score score = new Score(2, 0);

        // "3스트라이크" 로 출력되어야한다.
        narrator.isThreeStrike(score);

        Assertions.assertThat(output.toString().trim()).isEqualTo("2스트라이크");
    }

    @Test
    void 볼_스트라이크_출력_스트라이크와_볼이_모두0일때_테스트() {

        Score score = new Score(0, 0);

        // "낫싱" 로 출력되어야한다.
        narrator.isThreeStrike(score);

        Assertions.assertThat(output.toString().trim()).isEqualTo("낫싱");
    }

    @Test
    void 볼_스트라이크_출력_스트라이크와_볼이_0이_아닐때_테스트() {

        Score score = new Score(1, 2);

        // "2볼 1스트라이크" 로 출력되어야한다.
        narrator.isThreeStrike(score);

        Assertions.assertThat(output.toString().trim()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_스트라이크_출력_3스트라이크일때_테스트() {

        Score score = new Score(3, 0);

        // true 로 반환되어야 한다.
        boolean isThreeStrike = narrator.isThreeStrike(score);

        Assertions.assertThat(isThreeStrike).isEqualTo(true);
    }
}