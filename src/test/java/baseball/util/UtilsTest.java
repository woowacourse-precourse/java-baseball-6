package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}