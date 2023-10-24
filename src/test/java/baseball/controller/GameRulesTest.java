package baseball.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Score;
import baseball.model.UserBalls;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class GameRulesTest extends NsTest {

    private static final UserBalls userBalls = new UserBalls("123");

    @Test
    void 낫싱() {
        UserBalls computerBalls1 = new UserBalls("456");
        Score score = GameRules.getScore(computerBalls1.getUserBalls(), userBalls.getUserBalls());
        assertSimpleTest(() -> {
            assertThat(score.getBall()).isEqualTo(0);
            assertThat(score.getStrike()).isEqualTo(0);
        });
    }

    @Test
    void 삼_볼() {
        UserBalls computerBalls2 = new UserBalls("312");
        Score score = GameRules.getScore(computerBalls2.getUserBalls(), userBalls.getUserBalls());
        assertSimpleTest(() -> {
            assertThat(score.getBall()).isEqualTo(3);
            assertThat(score.getStrike()).isEqualTo(0);
        });
    }

    @Test
    void 삼_스트라이크() {
        UserBalls computerBalls3 = new UserBalls("123");
        Score score1 = GameRules.getScore(computerBalls3.getUserBalls(), userBalls.getUserBalls());
        System.out.println(score1.getBall());
        System.out.println(score1.getStrike());
        assertSimpleTest(() -> {
            assertThat(score1.getBall()).isEqualTo(0);
            assertThat(score1.getStrike()).isEqualTo(3);
        });
    }

    @Test
    void 일_볼_일_스트라이크() {
        UserBalls computerBalls4 = new UserBalls("142");
        Score score = GameRules.getScore(computerBalls4.getUserBalls(), userBalls.getUserBalls());
        assertSimpleTest(() -> {
            assertThat(score.getBall()).isEqualTo(1);
            assertThat(score.getStrike()).isEqualTo(1);
        });
    }

    @Test
    void 이_볼_일_스트라이크() {
        UserBalls computerBalls5 = new UserBalls("321");
        Score score = GameRules.getScore(computerBalls5.getUserBalls(), userBalls.getUserBalls());
        assertSimpleTest(() -> {
            assertThat(score.getBall()).isEqualTo(2);
            assertThat(score.getStrike()).isEqualTo(1);
        });
    }

    @Test
    void 출력_확인() {
        UserBalls computerBalls6 = new UserBalls("142");
        Score score = GameRules.getScore(computerBalls6.getUserBalls(), userBalls.getUserBalls());
        OutputView.printResult(score.getBall(), score.getStrike());
        assertSimpleTest(() -> assertThat(output()).contains("1볼 1스트라이크"));

    }

    @Override
    protected void runMain() {
    }
}
