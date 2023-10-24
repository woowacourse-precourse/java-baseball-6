package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("[List Utils]")
class ListUtilsTest {

    @Test
    @DisplayName("리스트의 길이가 같은지 테스트 - 같으면 true")
    void isLengthEqual_Success() {
        Assertions.assertTrue(ListUtils.isLengthEqual(List.of(1, 2, 3, 4), 4));
    }

    @Test
    @DisplayName("리스트의 길이가 같은지 테스트 - 다르면 false  ")
    void isLengthEqual_Failure() {
        Assertions.assertFalse(ListUtils.isLengthEqual(List.of(1, 2, 4), 4));
    }

    @Test
    @DisplayName("리스트의 길이가 같은지 테스트 - 리스트가 null이면 예외처리  ")
    void isLengthEqual_NullListException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () ->ListUtils.isLengthEqual(null, 4));
    }

    @Test
    @DisplayName("리스트의 길이가 같은지 테스트 - 길이를 음수로 입력하면 예외 처리  ")
    void isLengthEqual_LengthException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () ->ListUtils.isLengthEqual(List.of(1,2,3), -3));
    }
}