package baseball.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.ball.Balls;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGamePlayerTest {

    @Test
    @DisplayName("사용자가 3자리 수를 받아 공을 생성")
    public void playerBallsGenerateTest() {
        BaseBallGamePlayer baseBallGamePlayer = new BaseBallGamePlayer();
        List<Integer> givenNUmber = Arrays.asList(1, 2, 3);
        Balls targetBalls = new Balls(givenNUmber);

        Balls balls = baseBallGamePlayer.generateBalls(givenNUmber);
        assertThat(balls).isEqualTo(targetBalls);
    }

    @Test
    @DisplayName("사용자가 4자리 수를 받아 공을 생성 실패")
    public void playerBallsGenerateFailTest() {
        BaseBallGamePlayer baseBallGamePlayer = new BaseBallGamePlayer();
        List<Integer> givenNUmber = Arrays.asList(1, 2, 3, 4);
        assertThatThrownBy(()->baseBallGamePlayer.generateBalls(givenNUmber)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void playerGuessAllTest(){

    }
}
