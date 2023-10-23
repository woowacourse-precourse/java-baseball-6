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
    private Application baseballGame;
    private List<Integer> guess;
    private String myNumber;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
   @BeforeEach
   public void setUp(){
       baseballGame = new Application();
       guess = Arrays.asList(1,3,2);
       myNumber = "123";
       System.setOut(new PrintStream(outContent));
   }
    @AfterEach
    public void restoreOut() {
        System.setOut(originalOut); // 콘솔 출력을 원래대로 복구
    }

   @Test
   void 스트라이크_볼_갯수세기(){
       baseballGame.countStrikeAndBall(myNumber,guess);
       Assertions.assertEquals(1,Application.strike);

   }

   @Test
   void 숫자야구_결과_테스트(){
       baseballGame.displayBaseballGameResult(2,0);
       String consoleOutput = outContent.toString().trim();
       Assertions.assertEquals("2스트라이크",consoleOutput);

       }
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
