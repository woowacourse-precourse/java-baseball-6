package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 리스트를_이용한_숫자_생성() {
        // given
        List<Integer> inputDigits = Arrays.asList(1, 2, 3);

        // when
        Number number = new Number(inputDigits);

        // then
        assertThat(number.firstDigit).isEqualTo(1);
        assertThat(number.secondDigit).isEqualTo(2);
        assertThat(number.thirdDigit).isEqualTo(3);
    }

    @Test
    void 정수를_이용한_숫자_생성() {
        // given
        int inputNumber = 123;

        // when
        Number number = new Number(inputNumber);

        // then
        assertThat(number.firstDigit).isEqualTo(1);
        assertThat(number.secondDigit).isEqualTo(2);
        assertThat(number.thirdDigit).isEqualTo(3);
    }

    @Test
    void 숫자_포함_여부_확인() {
        // given
        List<Integer> inputDigits = Arrays.asList(1, 2, 3);

        // when
        Number number = new Number(inputDigits);

        // then
        assertThat(number.contains(1)).isTrue();
        assertThat(number.contains(2)).isTrue();
        assertThat(number.contains(3)).isTrue();
        assertThat(number.contains(4)).isFalse();
    }

    @Test
    void 잘못된_숫자_입력_예외처리() {
        // given
        int inputNumber = 023;

        // then
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Number(inputNumber);
        });

    }

    @Test
    void 중복된_숫자_입력_예외처리() {
        // given
        int inputNumber = 122;

        // then
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Number(inputNumber);
        });
    }

}