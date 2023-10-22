package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    @DisplayName("1에서 9사이의 값이 들어오면 Number가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1,5,9})
    void make_number(int inputNumber) {
        Number number = new Number(inputNumber);
        assertThat(inputNumber).isEqualTo(number.getNumber());
    }

    @DisplayName("1에서 9사이의 값이 들어오지 않으면 예외가 발생된다..")
    @ParameterizedTest
    @ValueSource(ints = {0,10,100})
    void make_number_exception(int inputNumber) {
        assertThrows(IllegalArgumentException.class, () -> {
            Number number = new Number(inputNumber);
        });
    }


    @DisplayName("Number 값 에따른 true false 테스트")
    @ParameterizedTest
    @MethodSource("createIsSameNumberData")
    void Number_숫자_같은지에따른_결과_테스트(Number number, Number otherNumber, boolean expect) {
        assertThat(number.isSameNumber(otherNumber)).isEqualTo(expect);
    }

    private static Stream<Arguments> createIsSameNumberData() {
        return Stream.of(
                Arguments.of(new Number(1), new Number(1),true),
                Arguments.of(new Number(1), new Number(8),false)
        );
    }



}