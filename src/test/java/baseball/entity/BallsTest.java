package baseball.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @DisplayName("공들(balls)을 생성할 수 있다.")
    @Test
    void create() {
        Balls balls = Balls.from(List.of(1, 2, 3));
        Balls otherBalls = Balls.from(List.of(1, 2, 3));

        assertThat(balls).isEqualTo(otherBalls);
    }

    @DisplayName("알 수 없는 숫자 목록(null)으로 생성할 수 없다.")
    @Test
    void createWithNull() {
        assertThatThrownBy(() -> Balls.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 숫자 목록(null)으로 객체를 생성할 수 없습니다.");
    }

    @DisplayName("알 수 없는 숫자(null)가 포함되어 있는 목록으로 생성할 수 없다.")
    @Test
    void createWithNullIncludedList() {
        List<Integer> nullIncludedList = new ArrayList<>();
        nullIncludedList.add(1);
        nullIncludedList.add(null);
        nullIncludedList.add(3);

        assertThatThrownBy(() -> Balls.from(nullIncludedList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 숫자(null)가 포함되어 있는 목록으로 객체를 생성할 수 없습니다.");
    }

    @DisplayName("중복된 숫자가 포함되어 있는 목록으로 생성할 수 없다.")
    @Test
    void createWithDuplicateNumbers() {
        assertThatThrownBy(() -> Balls.from(List.of(1, 1, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자는 허용되지 않습니다.");
    }

    @DisplayName("공은 한 라운드에 3개만 생성할 수 있다.")
    @Test
    void createWithOverSizeNumbers() {
        assertThatThrownBy(() -> Balls.from(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자를 선택해주세요.");
    }

    @DisplayName("공 목록에 하나의 공이 들어왔을 때, 같은 자리에 같은 숫자인 경우 스트라이크이다.")
    @Test
    void strike() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));
        Ball ball = Ball.of(3, 3);

        BallStatus result = answerBalls.evaluateOne(ball);

        assertThat(result.isStrike()).isTrue();
    }

    @DisplayName("공 목록에 하나의 공이 들어왔을 때, 같은 숫자지만 다른 위치인 경우 볼이다.")
    @Test
    void ball() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));
        Ball ball = Ball.of(3, 2);

        BallStatus result = answerBalls.evaluateOne(ball);

        assertThat(result.isBall()).isTrue();
    }

    @DisplayName("공 목록에 하나의 공이 들어왔을 때, 아무 공과도 같지 않은 경우 낫싱이다.")
    @Test
    void nothing() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));
        Ball ball = Ball.of(5, 2);

        BallStatus result = answerBalls.evaluateOne(ball);

        assertThat(result.isNothing()).isTrue();
    }

    @DisplayName("공 목록에 알 수 없는 공(null)이 들어왔을 때, 비교할 수 없다.")
    @Test
    void evaluateOneWithNull() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));

        assertThatThrownBy(() -> answerBalls.evaluateOne(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 공(null)과는 비교할 수 없습니다.");
    }

    @DisplayName("공 목록과 공 목록을 비교 - 1스트라이크 2볼")
    @Test
    void oneStrikeTwoBall() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));
        Balls balls = Balls.from(List.of(1, 3, 2));

        PlayResult result = answerBalls.play(balls);

        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
    }

    @DisplayName("공 목록과 공 목록을 비교 - 3스트라이크")
    @Test
    void threeStrike() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));
        Balls balls = Balls.from(List.of(1, 2, 3));

        PlayResult result = answerBalls.play(balls);

        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @DisplayName("공 목록과 공 목록을 비교 - 3볼")
    @Test
    void threeBall() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));
        Balls balls = Balls.from(List.of(3, 1, 2));

        PlayResult result = answerBalls.play(balls);

        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(3);
    }

    @DisplayName("공 목록과 공 목록을 비교 - 낫싱")
    @Test
    void nothingBalls() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));
        Balls balls = Balls.from(List.of(4, 9, 8));

        PlayResult result = answerBalls.play(balls);

        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @DisplayName("공 목록과 알 수 없는 공 목록(null)이 들어왔을 때, 비교할 수 없다.")
    @Test
    void playWithNull() {
        Balls answerBalls = Balls.from(List.of(1, 2, 3));

        assertThatThrownBy(() -> answerBalls.play(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 공 목록(null)과 비교할 수 없습니다.");
    }
}
