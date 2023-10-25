package baseball.number;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.utils.match.MatchResults;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

    @Test
    void create() {
        // given
        Numbers numbers = new Numbers("123");

        // then
        assertThat(numbers).isEqualTo(new Numbers("123"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "12a", "999", ""})
    void createException(String value) {
        // when
        assertThatThrownBy(() -> new Numbers(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void add() {
        // given
        Numbers numbers = new Numbers();

        // when
        numbers.add(new Number(1));

        // then
        assertThat(numbers.getNumbers().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("getNumbers")
    void isMoreSelect(Numbers numbers, boolean expected) {
        // when
        boolean actual = numbers.isMoreSelect();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getCompareNumbers")
    void compare(Numbers otherNumbers, String expected) {
        // given
        Numbers numbers = new Numbers("123");

        // when
        MatchResults result = numbers.compare(otherNumbers);

        // then
        assertThat(result.getResultMessage()).isEqualTo(expected);
    }

    public static Stream<Arguments> getNumbers() {
        return Stream.of(
            Arguments.of(new Numbers(), true),
            Arguments.of(new Numbers("123"), false)
        );
    }

    public static Stream<Arguments> getCompareNumbers() {
        return Stream.of(
                Arguments.of(new Numbers("123"), "3스트라이크"),
                Arguments.of(new Numbers("134"), "1볼 1스트라이크"),
                Arguments.of(new Numbers("312"), "3볼"),
                Arguments.of(new Numbers("456"), "낫싱")
        );
    }
}
