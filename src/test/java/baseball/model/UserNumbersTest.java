package baseball.model;

import static baseball.fixture.NumberFixture.createNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.fixture.UserNumbersFixture;
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
        UserNumbersFixture.createUserNumbers(input);
        UserNumbers userNumbers = UserNumbers.createFromInput(input);
        List<Number> expected = List.of(createNumber(1), createNumber(2), createNumber(3));

        // when
        List<Number> result = userNumbers.getSelectedNumbers();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("invalidParameters")
    void 잘못된_입력으로_생성시에_예외가_발생한다(String input, String expectedExceptionMessage, String exceptionMessage) {
        // when & then
        assertThatThrownBy(() -> UserNumbers.createFromInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(Arguments.of("1", "숫자는 세 가지를 고를 수 있습니다.", "숫자를 하나만 입력하면 예외가 발생한다."),
                Arguments.of("12345", "숫자는 세 가지를 고를 수 있습니다.", "숫자를 세개 초과로 입력하면 예외가 발생한다."),
                Arguments.of("adz", "숫자를 입력해주세요.", "숫자말고 다른 값을 입력하면 예외가 발생한다."),
                Arguments.of("144", "중복된 값은 입력할 수 없습니다.", "중복된 값을 입력하면 예외가 발생한다."),
                Arguments.of("140", "1부터 9사이의 값이 아닙니다.", "1부터 9가 아니면 예외가 발생한다.")
        );
    }
}
