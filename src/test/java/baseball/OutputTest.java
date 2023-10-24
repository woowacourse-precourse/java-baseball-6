package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.GameScore;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputTest {
    private OutputStream outputStream;
    final OutputView outputView = new OutputView();
    final InputView inputView = new InputView();
    GameScore gameScore;

    @BeforeEach
    void initStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 스트라이크_3개() {
        gameScore = new GameScore(3, 0);
        gameScore.printResult();
        assertThat(outputStream.toString()).contains("3스트라이크");
    }

    @Test
    void 적중_X() {
        gameScore = new GameScore(0, 0);
        gameScore.printResult();
        assertThat(outputStream.toString()).contains("낫싱");
    }

    @Test
    void 그외의_경우() {
        gameScore = new GameScore(2, 1);
        gameScore.printResult();
        assertThat(outputStream.toString()).contains("1볼 2스트라이크");
    }

    @Test
    void 게임종료() {
        gameScore = new GameScore(3, 0);
        if (gameScore.isUserFindAnswer()) {
            outputView.roundEndMsg();
            inputView.askRestartMsg();
        }
        assertThat(outputStream.toString()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
