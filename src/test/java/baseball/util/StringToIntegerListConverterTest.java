package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringToIntegerListConverterTest {

    @Test
    @DisplayName("문자를 숫자로 변환하여 컬렉션에 담는다.")
    void StringToIntegerList_Test() {
        // given
        String input = "12345";
        List<Integer> expectedList = List.of(1, 2, 3, 4, 5);

        // when
        List<Integer> resultList = StringToIntegerListConverter.StringToIntegerList(input);

        // then
        assertEquals(expectedList, resultList);
    }
}