package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallAndStrikeTest {

    @Test
    void 볼_테스트(){
        String computerNumber = "123";
        String playerNumber = "451";

        BaseBallNumber cpuNumber = new BaseBallNumber(computerNumber);
        BaseBallNumber userNumber = new BaseBallNumber(playerNumber);

        BallAndStrike resultBall = BallAndStrike.calcBallsAndStrikes(cpuNumber, userNumber);

        assertThat(resultBall.getStrikes()).isEqualTo(0);
        assertThat(resultBall.getBalls()).isEqualTo(1);

    }

    @Test
    void 스트라이크_테스트(){
        String computerNumber = "123";
        String playerNumber = "123";

        BaseBallNumber cpuNumber = new BaseBallNumber(computerNumber);
        BaseBallNumber userNumber = new BaseBallNumber(playerNumber);

        BallAndStrike resultBall = BallAndStrike.calcBallsAndStrikes(cpuNumber, userNumber);

        assertThat(resultBall.getBalls()).isEqualTo(0);
        assertThat(resultBall.getStrikes()).isEqualTo(3);
    }

    @Test
    void 볼_스트라이크_테스트(){
        String computerNumber = "123";
        String playerNumber = "325";

        BaseBallNumber cpuNumber = new BaseBallNumber(computerNumber);
        BaseBallNumber userNumber = new BaseBallNumber(playerNumber);

        BallAndStrike resultBall = BallAndStrike.calcBallsAndStrikes(cpuNumber, userNumber);

        assertThat(resultBall.getBalls()).isEqualTo(1);
        assertThat(resultBall.getStrikes()).isEqualTo(1);
    }

    @Test
    void 볼_스트라이크_테스트2(){
        String computerNumber = "123";
        String playerNumber = "132";

        BaseBallNumber cpuNumber = new BaseBallNumber(computerNumber);
        BaseBallNumber userNumber = new BaseBallNumber(playerNumber);

        BallAndStrike resultBall = BallAndStrike.calcBallsAndStrikes(cpuNumber, userNumber);

        assertThat(resultBall.getBalls()).isEqualTo(2);
        assertThat(resultBall.getStrikes()).isEqualTo(1);
    }
}