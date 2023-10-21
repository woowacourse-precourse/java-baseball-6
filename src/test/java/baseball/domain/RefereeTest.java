package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefereeTest {

    @Test
    void Referee_STRIKE_BALL개수_테스트() {
        List<Integer> computerBallNumbers = Arrays.asList(3, 1, 2);
        List<Integer> playerBallNumbers = Arrays.asList(3, 2, 4);
        Balls balls = new Balls(computerBallNumbers);
        Balls playerBalls = BallsFactory.createPlayerBalls(playerBallNumbers);
        List<BallStatus> result = balls.play(playerBalls);
        Referee referee = new Referee();
        assertThat(referee.getStrikeNumber()).isEqualTo(1);

    }
}
