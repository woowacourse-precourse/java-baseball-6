package baseball.view;

import static baseball.model.constants.Constant.BALL;
import static baseball.model.constants.Constant.GAME_CLEAR_PHRASE;
import static baseball.model.constants.Constant.GAME_START_PHRASE;
import static baseball.model.constants.Constant.NOTHING;
import static baseball.model.constants.Constant.STRIKE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    @DisplayName("게임 시작 문구인 '숫자 야구 게임을 시작합니다.'를 출력합니다.")
    void 게임시작문구출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printGameStart();

        String actualOutput = outputStream.toString().trim();

        assertEquals(GAME_START_PHRASE, actualOutput);
    }

    @Test
    @DisplayName("힌트 갯수인 '1'을 출력합니다.")
    void 힌트갯수출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printCount(1);

        String actualOutput = outputStream.toString().trim();

        assertEquals("1", actualOutput);
    }

    @Test
    @DisplayName("볼 문구인 '볼'을 출력합니다.")
    void 볼문구출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printBall();

        String actualOutput = outputStream.toString().trim();

        assertEquals(BALL, actualOutput);
    }

    @Test
    @DisplayName("볼 스트라이크 문구인 '볼 '을 출력합니다.")
    void 볼스트라이크문구출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printBallStrike();

        String actualOutput = outputStream.toString().trim();

        assertEquals(BALL, actualOutput);
    }

    @Test
    @DisplayName("스트라이크 문구인 '스트라이크'를 출력합니다.")
    void 스트라이크문구출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printStrike();

        String actualOutput = outputStream.toString().trim();

        assertEquals(STRIKE, actualOutput);
    }

    @Test
    @DisplayName("낫싱 문구인 '낫싱'을 출력합니다.")
    void 낫싱문구출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printNothing();

        String actualOutput = outputStream.toString().trim();

        assertEquals(NOTHING, actualOutput);
    }

    @Test
    @DisplayName("3개의 숫자를 모두 맞히셨습니다! 게임 종료'를 출력합니다.")
    void 게임종료문구출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printGameClear();

        String actualOutput = outputStream.toString().trim();

        assertEquals(GAME_CLEAR_PHRASE, actualOutput);
    }
}