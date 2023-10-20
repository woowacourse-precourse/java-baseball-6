package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareNumberTest {
    CompareNumber generatedBall;
    @BeforeEach
    void beforeEach() {
        generatedBall = new CompareNumber(1, 3);

    }
    @Test
    void 숫자_비교_스트라이크() {
        //생성된 숫자를 인자로 넣는다.
        CompareNumber userBall = new CompareNumber(1, 3);
        assertThat(generatedBall.calculateScore(userBall)).isEqualTo(BallScore.STRIKE);
    }
    @Test
    void 숫자_비교_볼() {
        //생성된 숫자를 인자로 넣는다.
        CompareNumber userBall = new CompareNumber(2, 3);
        assertThat(generatedBall.calculateScore(userBall)).isEqualTo(BallScore.BALL);
    }
    @Test
    void 숫자_비교_낫싱() {
        //생성된 숫자를 인자로 넣는다.
        CompareNumber userBall = new CompareNumber(1, 4);
        assertThat(generatedBall.calculateScore(userBall)).isEqualTo(BallScore.NOTHING);
    }
}
