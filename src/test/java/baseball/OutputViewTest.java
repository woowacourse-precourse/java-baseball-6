package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init(){
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput(){
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 게임_시작_출력_테스트() {
        OutputView.startGame();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 스트라이크_볼_기준_힌트_출력_테스트(){
        int[][] strikeAndBallCounts = {{0, 0}, {0, 1}, {2, 0}, {1, 1}};
        List<String> hintResult = Arrays.asList("낫싱", "1볼", "2스트라이크", "1볼 1스트라이크");
        for (int index = 0; index < hintResult.size(); index++){
            OutputView.showGameResult(strikeAndBallCounts[index]);
            assertThat(output()).contains(hintResult.get(index));
        }
    }

    @Test
    void 게임_종료_출력_테스트() {
        OutputView.finishGame();
        assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
