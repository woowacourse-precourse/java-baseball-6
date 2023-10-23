package baseball.view;

import baseball.model.GameResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {

    /**
     * System.out.println()의 출력을 재지정하여 ByteArrayOutputStream에 저장하도록 설정
     * 해당 스트림에서 문자열을 가져와 예상되는 결과와 비교
     */

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(systemOut);
    }

    @DisplayName("게임 시작 문구 출력 테스트")
    @Test
    public void printInitTest() {
        ResultView resultView = new ResultView();
        resultView.printInit();
        assertEquals("숫자 야구 게임을 시작합니다.\n", outContent.toString());
    }

    @DisplayName("3개의 숫자를 모두 맞힐 경우 출력 테스트")
    @Test
    public void printWinTest() {
        ResultView resultView = new ResultView();
        resultView.printWin();
        assertEquals("3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", outContent.toString());
    }

    @DisplayName("게임 결과 출력 테스트")
    @Test
    public void printResultTest() throws Exception {
        ResultView resultView = new ResultView();

        resultView.printBallAndStrikeCounts(new GameResult(2, 1));
        assertEquals("2볼 1스트라이크\n", outContent.toString());
        outContent.reset(); // Reset the stream to test again

        resultView.printBallAndStrikeCounts(new GameResult(1, 0));
        assertEquals("1볼\n", outContent.toString());
        outContent.reset();

        resultView.printBallAndStrikeCounts(new GameResult(0, 1));
        assertEquals("1스트라이크\n", outContent.toString());
        outContent.reset();

        resultView.printBallAndStrikeCounts(new GameResult(0, 0));
        assertEquals("낫싱\n", outContent.toString());

    }

}