package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.ball.Balls;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HintTest {
    Balls computerBalls;
    @BeforeEach
    void setUp(){
        computerBalls = new Balls(Arrays.asList(1,2,3));
    }
    @Test
    @DisplayName("낫싱 반환")
    public void getNothingTest() {
        Balls targetBalls = new Balls(Arrays.asList(4,5,6));
        Hint hint = computerBalls.match(targetBalls);
        assertThat(hint.getHintMessage()).isEqualTo("낫싱");
    }
    @Test
    @DisplayName("1스트라이크 반환")
    public void getStrikeOneTest() {
        Balls targetBalls = new Balls(Arrays.asList(1,5,6));
        Hint hint = computerBalls.match(targetBalls);
        assertThat(hint.getHintMessage()).isEqualTo("1스트라이크");
    }
    @Test
    @DisplayName("3스트라이크 반환")
    public void getStrikeThreeTest() {
        Balls targetBalls = new Balls(Arrays.asList(1,2,3));
        Hint hint = computerBalls.match(targetBalls);
        assertThat(hint.getHintMessage()).isEqualTo("3스트라이크");
    }
    @Test
    @DisplayName("2볼 반환")
    public void getTwoBallTest() {
        Balls targetBalls = new Balls(Arrays.asList(3,4,1));
        Hint hint = computerBalls.match(targetBalls);
        assertThat(hint.getHintMessage()).isEqualTo("2볼");
    }
    @Test
    @DisplayName("1볼 1스트라이크 반환")
    public void getOneBallAndOneStrikeTest() {
        Balls targetBalls = new Balls(Arrays.asList(1,3,4));
        Hint hint = computerBalls.match(targetBalls);
        assertThat(hint.getHintMessage()).isEqualTo("1볼 1스트라이크");
    }
}
