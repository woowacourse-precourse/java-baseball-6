package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallMakerTest {

    @DisplayName("야구공 제작자는 1~9 사이의 중복되지 않는 세 자리 숫자로 이루어진 공을 만들 수 있다.")
    @Test
    void createBall() {
        // given
        BallMaker ballMaker = new BallMaker();

        // when
        Ball ball = ballMaker.createBall();

        // then
        assertThat(ball).extracting("numbers")
                .asList()
                .hasSize(3)
                .doesNotHaveDuplicates();
    }

}