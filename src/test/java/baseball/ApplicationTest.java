package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private List<Integer> guess;
    private String myNumber;
    private Application baseballGame;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 스트라이크_볼_갯수세기(){
        baseballGame = new Application();
        guess = Arrays.asList(1,3,2);
        myNumber = "123";
        baseballGame.countStrikeAndBall(myNumber,guess);
        int strike = baseballGame.getStrike();
        Assertions.assertEquals(1,strike);

    }

    @Test
    void 숫자야구_결과_테스트(){
        System.setOut(new PrintStream(outContent));
        Application baseballGame = new Application();
        baseballGame.displayBaseballGameResult(2,0);
        String consoleOutput = outContent.toString().trim();
        Assertions.assertEquals("2스트라이크",consoleOutput);
        System.setOut(originalOut); // 콘솔 출력을 원래대로 복구

    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
