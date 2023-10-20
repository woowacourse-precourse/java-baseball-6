package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberBaseballTest {

    @Test
    @DisplayName("컴퓨터가 생성한 숫자가_3자리 서로 다른 임의의 숫자이면_성공한다")
    void generateNumber_is3DifferentRandomNumber_Success() {
        Computer computer = new Computer();
        String number = computer.generateRandomNumber();
        System.out.println(number);
        assertThat(number.charAt(0))
                .isNotEqualTo(number.charAt(1))
                .isNotEqualTo(number.charAt(2));
        assertThat(number.charAt(1))
                .isNotEqualTo(number.charAt(2));
    }
}
