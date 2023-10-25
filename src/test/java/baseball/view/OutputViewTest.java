package baseball.view;

import static baseball.model.constants.Phrase.BALL;
import static baseball.model.constants.Phrase.GAME_CLEAR_PHRASE;
import static baseball.model.constants.Phrase.GAME_START_PHRASE;
import static baseball.model.constants.Phrase.NOTHING;
import static baseball.model.constants.Phrase.STRIKE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("게임 시작 문구인 '숫자 야구 게임을 시작합니다.'를 출력합니다.")
    void 게임_시작_문구_출력() {
        OutputView.printGameStart();
        assertOutputEquals(GAME_START_PHRASE.getPhrase());
    }

    @Test
    @DisplayName("힌트 갯수인 '1'을 출력합니다.")
    void 힌트_갯수_출력() {
        OutputView.printCount(1);
        assertOutputEquals("1");
    }

    @Test
    @DisplayName("볼 문구인 '볼'을 출력합니다.")
    void 볼_문구_출력() {
        OutputView.printBall();
        assertOutputEquals(BALL.getPhrase());
    }

    @Test
    @DisplayName("볼 스트라이크 문구인 '볼 '을 출력합니다.")
    void 볼_스트라이크_문구_출력() {
        OutputView.printBallStrike();
        assertOutputEquals(BALL.getPhrase());
    }

    @Test
    @DisplayName("스트라이크 문구인 '스트라이크'를 출력합니다.")
    void 스트라이크_문구_출력() {
        OutputView.printStrike();
        assertOutputEquals(STRIKE.getPhrase());
    }

    @Test
    @DisplayName("낫싱 문구인 '낫싱'을 출력합니다.")
    void 낫싱_문구_출력() {
        OutputView.printNothing();
        assertOutputEquals(NOTHING.getPhrase());
    }

    @Test
    @DisplayName("게임 완료 문구인 '3개의 숫자를 모두 맞히셨습니다! 게임 종료'를 출력합니다.")
    void 게임_완료_문구_출력() {
        OutputView.printGameClear();
        assertOutputEquals(GAME_CLEAR_PHRASE.getPhrase());
    }

    private void assertOutputEquals(String expected) {
        String actual = outputStream.toString().trim();
        assertEquals(expected, actual);
    }
}