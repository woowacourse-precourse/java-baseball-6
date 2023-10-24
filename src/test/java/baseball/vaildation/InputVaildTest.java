package baseball.vaildation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputVaildTest {

    @Test
    @DisplayName("입력값에 0이 들어가면 안된다.")
    void inputVaildationTestZero() {
        // when
        String input = "206";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputVaild.inputVaildation(input));
    }

    @Test
    @DisplayName("입력은 숫자만 할 수 있다.")
    void inputVaildationTestInt() {
        // when
        String input = "문자열";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputVaild.inputVaildation(input));
    }

    @Test
    @DisplayName("입력은 세자리만 입력할 수 있다.")
    void inputVaildationTestLength3() {
        // when
        String input = "1234";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputVaild.inputVaildation(input));
    }
}