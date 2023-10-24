package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsFactoryTest {

    @Test
    void 팩토리로_볼생성() {
        //given
        List<Ball> ballsList = Arrays.asList(new Ball(new Position(1), new BallNumber(4))
                ,new Ball(new Position(2), new BallNumber(5))
                ,new Ball(new Position(3), new BallNumber(6)));

        Balls balls = new Balls(ballsList);
        List<Integer> ballNumbers = Arrays.asList(4, 5, 6);
        //when
        Balls createBalls = BallsFactory.createBalls(ballNumbers);
        //then
        assertThat(createBalls).isEqualTo(balls);
    }
}