package baseball.computer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @DisplayName("Number 인스턴스의 생성자에 양의 정수인 5을 넣으면 정상적으로 인스턴스가 생성된다.")
    @Test
    void createNumber() {
        int validNumber = 5;
        Number number = new Number(validNumber);

        assertThat(number.getNumber())
                .isEqualTo(validNumber);
    }

    @DisplayName("Number 인스턴스의 생성자에 양의 정수의 경계선인 0을 넣으면 예외가 발생한다.")
    @Test
    void createNumberWithZero() {
        int invalidNumber = 0;

        assertThatThrownBy(() -> new Number(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 " + 1 + "에서 " + 9 + "까지여야 합니다.");
    }

    @DisplayName("Number 인스턴스의 생성자에 양의 정수의 경계선인 10을 넣으면 예외가 발생한다.")
    @Test
    void createNumberWithTen() {
        int invalidNumber = 10;

        assertThatThrownBy(() -> new Number(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 " + 1 + "에서 " + 9 + "까지여야 합니다.");
    }

    @DisplayName("Number 인스턴스의 toString 메서드를 호출하면 그 인스턴스의 numberString을 반환한다.")
    @Test
    void toString_withValidNumber() {
        int validNumber = 6;
        Number number = new Number(validNumber);

        assertThat(number.toString())
                .hasToString("6");
    }

}
