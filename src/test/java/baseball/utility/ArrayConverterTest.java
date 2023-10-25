package baseball.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArrayConverterTest {

    @DisplayName("문자열을 배열로 변환할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "1, 9, 3",
            "9, 5, 1",
            "8, 7, 6"
    })
    void toIntArray(String firstNumber, String secondNumber, String thirdNumber) {
        // given
        String input = new StringBuilder(firstNumber).append(secondNumber).append(thirdNumber).toString();

        // when
        int[] array = ArrayConverter.toIntArray(input);

        // then
        assertThat(array).hasSize(3);
        assertThat(array[0]).isEqualTo(Integer.parseInt(firstNumber));
        assertThat(array[1]).isEqualTo(Integer.parseInt(secondNumber));
        assertThat(array[2]).isEqualTo(Integer.parseInt(thirdNumber));
    }

}