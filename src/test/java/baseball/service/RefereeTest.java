package baseball.service;

import baseball.domain.BallCounter;
import baseball.domain.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RefereeTest {

    private Referee referee;
    private List<Balls> computerBalls;
    private List<Balls> playerBalls;

    @BeforeEach
    void setUp() {
        this.referee = new Referee();
        computerBalls = new ArrayList<>();
        playerBalls = new ArrayList<>();
    }

    @DisplayName("주어진 공의 위치와 번호가 다르면 볼로 판단한다.")
    @Test
    void judgeBall() {
        computerBalls.add(new Balls(1, 3));
        playerBalls.add(new Balls(1, 2));

        BallCounter actual = referee.judgeGame(computerBalls, playerBalls);
        BallCounter expected = new BallCounter(0, 1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(actual.getBallCount(), expected.getBallCount()),
                () -> Assertions.assertEquals(actual.getStrikeCount(), expected.getStrikeCount())
        );
    }

    @DisplayName("주어진 공의 위치와 번호가 같으면 스트라이크로 판단한다.")
    @Test
    void judgeStrike() {
        computerBalls.add(new Balls(1, 3));
        playerBalls.add(new Balls(1, 3));

        BallCounter actual = referee.judgeGame(computerBalls, playerBalls);
        BallCounter expected = new BallCounter(1, 0);

        Assertions.assertAll(
                () -> Assertions.assertEquals(actual.getBallCount(), expected.getBallCount()),
                () -> Assertions.assertEquals(actual.getStrikeCount(), expected.getStrikeCount())
        );
    }

    @DisplayName("3스트라이크가 되었는지 판단한다.")
    @Test
    void isEndGameCondition() {
        boolean actualTrue = referee.isEndGameCondition(new BallCounter(3, 0));
        boolean actualFalse = referee.isEndGameCondition(new BallCounter(2, 0));

        Assertions.assertAll(
                () -> Assertions.assertTrue(actualTrue),
                () -> Assertions.assertFalse(actualFalse)
        );
    }
}
