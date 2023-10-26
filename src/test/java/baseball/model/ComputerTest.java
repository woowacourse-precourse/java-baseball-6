package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("컴퓨터 수에 있는 숫자일 경우 참, 없는 숫자일 경우 거짓을 반환한다.")
    @Test
    void hasNumber() {
        Computer computer = new Computer(List.of(1, 2, 3));

        boolean result1 = computer.hasNumber(1);
        boolean result2 = computer.hasNumber(5);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @DisplayName("같은 수가 같은 위치에 있을 경우 참, 다른 위치에 있을 경우 거짓을 반환한다.")
    @Test
    void isSameIndex() {
        Computer computer = new Computer(List.of(1, 2, 3));

        boolean result1 = computer.isSameIndex(1, 0);
        boolean result2 = computer.isSameIndex(1, 1);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}
