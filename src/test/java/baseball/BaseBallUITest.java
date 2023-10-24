package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BaseBallUITest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 숫자_야구게임을시작하는_문구가_출력되야한다() {
        final String expect = "숫자 야구 게임을 시작합니다.";
        BaseBallUI baseBallUI = new BaseBallUI();
        baseBallUI.startGame();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,낫싱", "0,1,1볼", "0,2,2볼", "0,3,3볼",
            "1,0,1스트라이크", "1,1,1볼 1스트라이크", "1,2,2볼 1스트라이크",
            "2,0,2스트라이크", "2,1,1볼 2스트라이크",
            "3,0,3스트라이크"

    })
    void 게임_점수_문구가_출력되야한다(int strike, int ball, String expect) {
        BaseBallUI baseBallUI = new BaseBallUI();
        baseBallUI.printBaseBallScore(new BaseBallScore(strike, ball));
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expect);
    }

    @Test
    void 숫자_야구게임_플레이_문구가_출력되야한다() {
        final String expect = "숫자를 입력해주세요 :";
        BaseBallUI baseBallUI = new BaseBallUI();
        baseBallUI.playing();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expect);
    }

    @Test
    void 숫자_야구게임을끝나는_문구가_출력되야한다() {
        final String expect = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        BaseBallUI baseBallUI = new BaseBallUI();
        baseBallUI.endGame();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expect);
    }

}