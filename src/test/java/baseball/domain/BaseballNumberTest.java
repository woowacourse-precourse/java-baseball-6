package baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballNumberTest {

    @ParameterizedTest
    @MethodSource("provideIsSameValueTestArguments")
    void isSameValueTest(BaseballNumber number, BaseballNumber anotherNumber, boolean expected) {
        assertThat(number.isSameValue(anotherNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> provideIsSameValueTestArguments() {
        return Stream.of(
                arguments(new BaseballNumber(1), new BaseballNumber(1), true),
                arguments(new BaseballNumber(1), new BaseballNumber(2), false)
        );
    }
}
