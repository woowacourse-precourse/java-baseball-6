package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertTest {

    @Test
    @DisplayName("String을 List<Integer>로 변환하는 기능을 테스트한다.")
    void testConvertStringToIntegerList() {
        String input = "123";

        List<Integer> userNumber = Convert.convertStringToIntegerList(input);

        assertThat(userNumber.size()).isEqualTo(3);
        assertThat(userNumber.get(0)).isEqualTo(1);
        assertThat(userNumber.get(1)).isEqualTo(2);
        assertThat(userNumber.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("String을 Integer로 변환하는 기능을 테스트한다.")
    void testConvertStringToInteger() {
        String input = "1";

        int restartOrExitNumber = Convert.convertStringToInteger(input);

        assertThat(restartOrExitNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("변환 과정에서 NumberFormatException 발생 시, 그것을 잡아 IllegalArgumentException을 발생시킨다.")
    void testCatchNumberFormatExceptionThrowIllegalArgumentException() {
        String input = "a";

        assertThatThrownBy(() -> Convert.convertStringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
