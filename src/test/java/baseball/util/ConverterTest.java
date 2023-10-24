package baseball.util;

import static baseball.fixture.NumberFixture.createNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.Number;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void 스트링을_정수형_리스트로_변환한다() {
        // given
        String input = "123";
        List<Number> expected = List.of(createNumber(1), createNumber(2), createNumber(3));

        // when
        List<Number> result = Converter.convertStringToNumgerList(input);

        // then
        assertEquals(expected, result);
    }
}
