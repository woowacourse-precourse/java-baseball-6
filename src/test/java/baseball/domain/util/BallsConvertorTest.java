package baseball.domain.util;

import baseball.domain.ball.Ball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BallsConvertorTest {

    @Test
    @DisplayName("142 를 자르면 1, 4, 2 를 가진 리스트를 반환한다.")
    void cutNumberTest() {
        List<Integer> integers = BallsConvertor.cutNumber(142);
        Assertions.assertThat(integers).contains(1, 4, 2);
    }

    @Test
    @DisplayName("142 를 변환하면 각 숫자 Ball 들을 가진 리시트를 반환한다.")
    void convertBallsTest() {
        List<Ball> balls = BallsConvertor.convertNumberToBalls(142);
        Assertions.assertThat(balls).contains(new Ball(1, 0),
                new Ball(4, 1), new Ball(2, 2));
    }
}