package baseball.util;

import static baseball.util.Converter.integerListToString;
import static baseball.util.Converter.stringToIntegerList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ConverterTest {

    @Test
    void 문자열을_정수형_리스트로_변환한다() {
        // given
        String number = "123";

        // when
        final List<Integer> numbers = stringToIntegerList(number);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 정수형_리스트를_문자열로_변환한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);

        // when
        final String number = integerListToString(numbers);

        // then
        assertThat(number).isEqualTo("123");
    }
}
