package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void 스트링을_정수형_리스트로_변환한다() {
        // given
        String input = "123";
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);

        // when
        List<Integer> numbers = Converter.convertStringToIntegerList(input);

        // then
        assertThat(numbers).isEqualTo(inputNumbers);
    }
}
