package baseball.model;



import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.ball.Balls;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGamePlayerTest {

    @Test
    @DisplayName("사용자 공 생성 확인")
    public void playerBallsGenerateTest() {
        BaseBallGamePlayer baseBallGamePlayer = new BaseBallGamePlayer();
        List<Integer> givenNUmber = Arrays.asList(1, 2, 3);
        Balls targetBalls = new Balls(givenNUmber);

        Balls balls = baseBallGamePlayer.generateBalls(givenNUmber);
        assertThat(balls).isEqualTo(targetBalls);
    }

}
