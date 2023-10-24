package baseball.viewTest;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 게임시작_출력_테스트() {
        OutputView.gameStartOutput();
        assertThat("숫자 야구 게임을 시작합니다.").isEqualTo(output.toString().trim());
    }

    @Test
    void 게임결과_출력_테스트() {

        OutputView.gameResultOutput(1, 2);
        assertThat("2볼 1스트라이크").isEqualTo(output.toString().trim());

        output.reset();
        OutputView.gameResultOutput(0, 3);
        assertThat("3볼").isEqualTo(output.toString().trim());

        output.reset();
        OutputView.gameResultOutput(2, 0);
        assertThat("2스트라이크").isEqualTo(output.toString().trim());

        output.reset();
        OutputView.gameResultOutput(0, 0);
        assertThat("낫싱").isEqualTo(output.toString().trim());

    }

    @Test
    void 게임종료_출력_테스트() {
        OutputView.gameEndOutput();
        assertThat("3개의 숫자를 모두 맞히셨습니다! 게임 종료").isEqualTo(output.toString().trim());

    }
}
