package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    
    @Test
    @DisplayName("3자리 이상의 숫자를 입력할 경우 예외 발생")
    void validateLength() {
        List<Integer> input = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자를 입력할 경우 예외 발생")
    void validateDuplicateNumber() {
        List<Integer> input = List.of(1, 2, 2);
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 이외의 숫자를 입력할 경우 예외 발생")
    void validateRange() {
        List<Integer> input = List.of(1, 2, 0);
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 숫자가 리스트 안에 존재할 경우 true를 반환한다.")
    void checkBall() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        int target = 1;

        boolean isContain = numbers.contains(target);

        assertThat(isContain).isTrue();
    }

    @Test
    @DisplayName("입력된 숫자가 리스트 안에 존재하지 않을 경우 false를 반환한다.")
    void checkNotBall() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        int target = 5;

        boolean isContain = numbers.contains(target);

        assertThat(isContain).isFalse();
    }

    @Test
    @DisplayName("입력된 숫자가 리스트 안에 존재하고 위치도 동일할 경우 경우 true를 반환한다.")
    void checkStrike() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        int target = 3;
        int position = 2;

        boolean isStrike = numbers.isSamePosition(position, target);

        assertThat(isStrike).isTrue();
    }

    @Test
    @DisplayName("입력된 숫자가 리스트 안에 존재하지만 위치가 다를 경우 false를 반환한다.")
    void checkNotStrike() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        int target = 3;
        int position = 0;

        boolean isStrike = numbers.isSamePosition(position, target);

        assertThat(isStrike).isFalse();
    }
}
