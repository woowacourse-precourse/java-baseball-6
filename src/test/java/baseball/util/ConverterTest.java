package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    @DisplayName("문자를 List<Integer>로 변환 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}, {1}")
    @MethodSource("converterParametersProvider")
    void checkConverter(String value, List<Integer> result) {
        assertThat(Converter.convertList(value)).isEqualTo(result);
    }

    static Stream<Arguments> converterParametersProvider() {
        return Stream.of(
                Arguments.arguments("123", List.of(1, 2, 3)),
                Arguments.arguments("591", List.of(5, 9, 1))
        );
    }
}