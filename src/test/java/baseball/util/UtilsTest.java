package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @DisplayName("String 값을 Integer List 로 변환한다.")
    @Test
    void stringToList() {
        // given
        String inputValue = "123";
        List<Integer> answerValue = List.of(1, 2, 3);

        // when
        List<Integer> userNumber = Utils.stringToList(inputValue);

        // then
        assertEquals(answerValue, userNumber);
    }

    @DisplayName("1,2 가 아닌 숫자가 들어왔을 경우 예외를 발생시킨다.")
    @Test
    void validateEndNumber() {
        // given
        int number = 3;

        // when, then
        assertThatThrownBy(() -> Utils.validateEndNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}