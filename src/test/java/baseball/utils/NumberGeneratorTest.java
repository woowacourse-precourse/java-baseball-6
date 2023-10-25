package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {


    @Test
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다.")
    void createThreeDigitNumberComposedOfDifferent1To9() {
        //given //when
        List<Integer> numbers = NumberGenerator.createComputerNumbers();

        //then
        assertThat(numbers).hasSize(3)
            .doesNotHaveDuplicates()
            .allMatch(n -> 1 <= n && n <= 9);
    }
}