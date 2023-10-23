package baseball.viewTest;

import baseball.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

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

        // 스트라이크 1, 볼 2인 경우
        OutputView.gameResultOutput(1, 2);
        assertThat("2볼 1스트라이크").isEqualTo(output.toString().trim());

        // 스트라이크 0, 볼 3인 경우
        output.reset();  // 출력 내용 초기화
        OutputView.gameResultOutput(0, 3);
        assertThat("3볼").isEqualTo(output.toString().trim());

        // 스트라이크 2, 볼 0인 경우
        output.reset();
        OutputView.gameResultOutput(2, 0);
        assertThat("2스트라이크").isEqualTo(output.toString().trim());

        // 낫싱인 경우
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
