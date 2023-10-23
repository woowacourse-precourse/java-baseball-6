package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class BallStrikeCalculatorTest {

    BallStrikeCalculator ballStrikeCalculator = new BallStrikeCalculator();

    @Test
    void 스트라이크_갯수_계산_성공테스트() {

        int[] userInput = {1, 2, 3};
        int[] computerAnswer = {1, 2, 4};

        // userInput      = {1,2,3};
        // computerAnswer = {1,2,4};
        // 1과 2는 같은 위치에 존재하기 때문에 2스트라이크가 나와야한다.
        int strikes = ballStrikeCalculator.countStrike(userInput, computerAnswer);

        Assertions.assertThat(strikes).isEqualTo(2);
    }

    @Test
    void 볼_갯수_계산_성공테스트() {
        int[] userInput = {1, 2, 3};
        int[] computerAnswer = {3, 1, 2};

        // userInput      = {1,2,3};
        // computerAnswer = {3,1,2};
        // 1, 2, 3 모두 다른위치에 존재하므로 3볼이 나와야한다.
        int balls = ballStrikeCalculator.countBall(userInput, computerAnswer);

        Assertions.assertThat(balls).isEqualTo(3);
    }

    @Test
    void 스트라이크_볼_Score_반환_테스트() {
        int[] userInput = {1, 2, 3};
        int[] computerAnswer = {1, 3, 2};

        // userInput      = {1,2,3};
        // computerAnswer = {1,3,2};
        // 1은 같은위치에 존재하고 2,3 은 다른 위치에 존재하므로 2볼 1스트라이크가 나와야한다.
        Score score = ballStrikeCalculator.countStrikeAndBallToScore(userInput, computerAnswer);

        Assertions.assertThat(score.ball).isEqualTo(2);
        Assertions.assertThat(score.strike).isEqualTo(1);
    }

}