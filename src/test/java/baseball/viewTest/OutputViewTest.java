package baseball.viewTest;

import baseball.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("숫자 야구 게임을 시작합니다.", output.toString().trim());
    }

    @Test
    void 게임결과_출력_테스트() {

        // 스트라이크 1, 볼 2인 경우
        OutputView.gameResultOutput(1, 2);
        assertEquals("2볼 1스트라이크", output.toString().trim());

        // 스트라이크 0, 볼 3인 경우
        output.reset();  // 출력 내용 초기화
        OutputView.gameResultOutput(0, 3);
        assertEquals("3볼", output.toString().trim());

        // 스트라이크 2, 볼 0인 경우
        output.reset();
        OutputView.gameResultOutput(2, 0);
        assertEquals("2스트라이크", output.toString().trim());

        // 낫싱인 경우
        output.reset();
        OutputView.gameResultOutput(0, 0);
        assertEquals("낫싱", output.toString().trim());
    }

    @Test
    void 게임종료_출력_테스트() {
        OutputView.gameEndOutput();
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료", output.toString().trim());
    }
}
