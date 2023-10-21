package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @DisplayName("볼의 개수가 3개가 아니라면 예외 발생")
    @Test
    void createBalls() {
        // given
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(1, 1));

        // when, then
        assertThatThrownBy(() -> new Balls(ballList))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("다른 Balls와 비교해서 스트라이크 개수 찾기")
    @Test
    void countStrike() {
        // given
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(4, 0));
        ballList.add(new Ball(5, 1));
        ballList.add(new Ball(6, 2));
        Balls com = new Balls(ballList);

        ballList = new ArrayList<>();
        ballList.add(new Ball(4, 0));
        ballList.add(new Ball(5, 1));
        ballList.add(new Ball(6, 2));
        Balls user = new Balls(ballList);

        // when
        int result = com.countStrike(user);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("삼진아웃인지 확인하기")
    @Test
    void isThreeStrike() {
        // given
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(4, 0));
        ballList.add(new Ball(5, 1));
        ballList.add(new Ball(6, 2));
        Balls com = new Balls(ballList);

        ballList = new ArrayList<>();
        ballList.add(new Ball(4, 0));
        ballList.add(new Ball(5, 1));
        ballList.add(new Ball(6, 2));
        Balls user = new Balls(ballList);

        // when
        boolean result = com.isThreeStrike(user);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("낫싱인지 확인하기")
    @Test
    void isNothing() {
        // given
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(4, 0));
        ballList.add(new Ball(5, 1));
        ballList.add(new Ball(6, 2));
        Balls com = new Balls(ballList);

        ballList = new ArrayList<>();
        ballList.add(new Ball(7, 0));
        ballList.add(new Ball(8, 1));
        ballList.add(new Ball(9, 2));
        Balls user = new Balls(ballList);

        // when
        boolean result = com.isNothing(user);

        // then
        assertThat(result).isTrue();
    }
}