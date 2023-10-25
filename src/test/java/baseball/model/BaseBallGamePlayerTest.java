package baseball.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.ball.Balls;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGamePlayerTest {

    BaseBallGamePlayer baseBallGamePlayer = new BaseBallGamePlayer();
    List<Integer> givenNUmber;

    @BeforeEach
    void setUp() {
        givenNUmber = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("사용자가 3자리 수를 받아 공을 생성")
    public void playerBallsGenerateTest() {
        Balls targetBalls = new Balls(givenNUmber);
        Balls balls = baseBallGamePlayer.generateBalls(givenNUmber);
        assertThat(balls).isEqualTo(targetBalls);
    }

    @Test
    @DisplayName("사용자가 4자리 수를 받아 공을 생성 실패")
    public void playerBallsGenerateFailTest() {
        givenNUmber = Arrays.asList(1, 2, 3, 4);
        assertThatThrownBy(() -> baseBallGamePlayer.generateBalls(givenNUmber)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자의 공으로 Hint 생성 : 3 스트라이크")
    public void playerGuessAllTest() {
        baseBallGamePlayer.generateBalls(givenNUmber);
        Balls targetBalls = new Balls(givenNUmber);
        Hint hint = baseBallGamePlayer.guessBalls(targetBalls);
        assertThat(hint.getHintMessage()).isEqualTo("3스트라이크");
    }
    @Test
    @DisplayName("사용자의 공으로 Hint 생성 : 낫싱")
    public void playerGuessAllNothingTest() {
        baseBallGamePlayer.generateBalls(givenNUmber);
        givenNUmber = Arrays.asList(4, 5, 6);
        Balls targetBalls = new Balls(givenNUmber);
        Hint hint = baseBallGamePlayer.guessBalls(targetBalls);
        assertThat(hint.getHintMessage()).isEqualTo("낫싱");
    }
}
