package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumberTest {

    @Test
    @DisplayName("각각의 자리 수에 대해 올바른 자리수 값을 반환하는지 테스트한다")
    void getNumberAt() {
        BallNumber ballNumber = new BallNumber(123);
        assertThat(ballNumber.getNumberAt(0)).isEqualTo(1);
        assertThat(ballNumber.getNumberAt(1)).isEqualTo(2);
        assertThat(ballNumber.getNumberAt(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("BaseballNumber가 해당 number를 가지고 있다면 true를 반환하는지 테스트한다")
    void contains(int number, int target, boolean expected) {
        BallNumber ballNumber = new BallNumber(685);
        assertThat(ballNumber.contains(6)).isTrue();
        assertThat(ballNumber.contains(1)).isFalse();
        assertThat(ballNumber.contains(8)).isTrue();
    }
}