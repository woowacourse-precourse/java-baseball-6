package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class BallsCompareTest extends NsTest {

    @Test
    void 정답132_플레이어123일때_1strike_2Ball() {
        assertRandomNumberInRangeTest(
            () -> {
                run();
                assertThat(output()).contains("1","2");
            },
            1, 3,2
        );
    }

    @Override
    protected void runMain() {
        GameController gameController = new GameController();
        Balls answerBalls = gameController.generateAnswerBallsTest();
        Balls playerBalls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        System.out.println(playerBalls.getStrikeCount(answerBalls));
        System.out.println(playerBalls.getBallCount(answerBalls));
    }
}
