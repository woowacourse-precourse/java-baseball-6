package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import baseball.helper.TestConverter;
import baseball.model.Number;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void 스트링을_정수형_리스트로_변환한다() {
        // given
        String input = "123";
        List<Number> expected = TestConverter.makeNumberList(input);

        // when
        List<Number> result = Converter.convertStringToNumgerList(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
