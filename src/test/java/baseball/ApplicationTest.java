package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void 스트라이크_볼_개수세기() {
        List<Character> user = List.of('1', '2', '3');
        List<Character> computer = List.of('3', '2', '1');

        int[] result = Application.count(user, computer);

        // 1스트라이크 2볼
        assertEquals(1, result[1]);
        assertEquals(2, result[0]);
    }

    @Test
    public void 스트라이크_볼_출력확인() {
        int[] result = {2, 1};
        String output = Application.output(result);

        assertEquals("2볼 1스트라이크", output);
    }

    @Test
    public void 유효한숫자예측() {
        String validGuess = "123";

        assertDoesNotThrow(() -> Application.guess(validGuess));
    }

    @Test
    public void 세자리아님() {

        String invalidGuess = "12";
        assertThrows(IllegalArgumentException.class, () -> Application.guess(invalidGuess));
    }

    @Test
    public void 숫자가아님() {

        String nonNumericGuess = "1a2";
        assertThrows(IllegalArgumentException.class, () -> Application.guess(nonNumericGuess));
    }

    @Test
    public void 중복된숫자() {
        String duplicateGuess = "112";
        assertThrows(IllegalArgumentException.class, () -> Application.guess(duplicateGuess));
    }

    @Test
    public void 범위벗어나는숫자() {
        String outOfRangeGuess = "012";
        assertThrows(IllegalArgumentException.class, () -> Application.guess(outOfRangeGuess));
    }

}
