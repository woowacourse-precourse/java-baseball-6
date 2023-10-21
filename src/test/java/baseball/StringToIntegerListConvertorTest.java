package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.convertor.StringToIntegerListConvertor;


public class StringToIntegerListConvertorTest {

    @ParameterizedTest
    @MethodSource("provideStringAndExpectedList")
    @DisplayName("문자열 숫자 리스트로 변환 검증")
    void validationWrongValue(String value, List<Integer> expect) {
        //when
        List<Integer> numbers = StringToIntegerListConvertor.convert(value);

        //then
        Assertions.assertThat(numbers).isEqualTo(expect);
    }

    static Stream<Arguments> provideStringAndExpectedList() {
        return Stream.of(
                Arguments.of("123", Arrays.asList(1, 2, 3)),
                Arguments.of("456", Arrays.asList(4, 5, 6)),
                Arguments.of("789", Arrays.asList(7, 8, 9))
        );
    }
}
