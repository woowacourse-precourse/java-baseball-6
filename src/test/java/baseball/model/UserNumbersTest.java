package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class UserNumbersTest {

    @Test
    void 입력으로_리스트를_만든다() {
        // given
        String input = "123";
        List<Integer> expected = Arrays.asList(1, 2, 3);
        UserNumbers userNumbers = UserNumbers.createFromInput(input);

        // when
        List<Integer> result = userNumbers.getSelectedNumbers();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("invalidParameters")
    void 잘못된_입력으로_생성시에_예외가_발생한다(String input, String expectedExceptionMessage, String exceptionMessage) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> UserNumbers.createFromInput(input));

        // then
        assertThat(e.getMessage()).isEqualTo(expectedExceptionMessage);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(Arguments.of("1", "숫자는 세 가지를 고를 수 있습니다.", "숫자를 하나만 입력하면 예외가 발생한다."),
                Arguments.of("12345", "숫자는 세 가지를 고를 수 있습니다.", "숫자를 세개 초과로 입력하면 예외가 발생한다."),
                Arguments.of("adz", "숫자를 입력해주세요.", "숫자말고 다른 값을 입력하면 예외가 발생한다."),
                Arguments.of("144", "중복된 숫자는 입력할 수 없습니다.", "중복된 숫자를 입력하면 예외가 발생한다."),
                Arguments.of("140", "0이 포함되어서는 안됩니다.", "0이 포함되어있으면 예외가 발생한다.")
        );
    }
}
