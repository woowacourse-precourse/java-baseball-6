package baseball.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.view.UserNumbers;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class UserNumbersTest {

    @Test
    void 입력의_길이가_3이다() {
        assertDoesNotThrow(() -> new UserNumbers("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserNumbers(""));
        assertThrows(IllegalArgumentException.class, () -> new UserNumbers("1234"));
        assertThrows(IllegalArgumentException.class, () -> new UserNumbers("ad"));
    }

    @Test
    void 입력이_숫자로만_이루어진다() {
        assertDoesNotThrow(() -> new UserNumbers("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserNumbers("1a2"));
    }

    @Test
    void 입력이_숫자일때_1과_9사이_숫자다() {
        assertDoesNotThrow(() -> new UserNumbers("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserNumbers("102"));
    }

    @Test
    void 입력이_숫자일때_모두_다른_숫자다() {
        assertDoesNotThrow(() -> new UserNumbers("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserNumbers("112"));
    }

    @Test
    void 숫자문자열을_숫자리스트로변환() {
        String s = "123";
        UserNumbers input = new UserNumbers("123");
        List<Integer> numberList = input.userInputToIntegerList("123");
        assertEquals(1, numberList.get(0));
        assertEquals(2, numberList.get(1));
        assertEquals(3, numberList.get(2));
    }

}