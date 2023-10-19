package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallNumTest {

    @Test
    void BallNum_VO_생성() {
        BallNum ballNum = new BallNum(5);
        assertThat(ballNum.getNumber()).isEqualTo(5);
    }

    @Test
    void BallNum_VO_동등성() {
        BallNum ballNum = new BallNum(5);
        assertThat(ballNum).isEqualTo(new BallNum(5));
    }
}
