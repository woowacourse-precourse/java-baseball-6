package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    void countNumbers() {
        BaseballGame yourClass = new BaseballGame(3); // YourClassName에 맞게 클래스 이름을 수정해주세요.

        // 예시 입력 데이터
        List<Integer> candidate = Arrays.asList(1, 2, 3);
        List<Integer> pickedList = Arrays.asList(3, 2, 1);

        Map<String, Integer> result = yourClass.countNumbers(candidate, pickedList);

        // 예상 결과: 1 스트라이크, 2 볼
        assertEquals(1, result.get("strike"));
        assertEquals(2, result.get("ball"));
    }


    @Test
    void validateInput() {
        BaseballGame yourClass = new BaseballGame(3); // YourClassName에 맞게 클래스 이름을 수정해주세요.

        // 유효한 입력
        assertDoesNotThrow(() -> yourClass.validateInput("123"));

        // 길이가 3이 아닌 경우
        assertThrows(IllegalArgumentException.class, () -> yourClass.validateInput("12"));
        assertThrows(IllegalArgumentException.class, () -> yourClass.validateInput("1234"));

        // 숫자가 아닌 경우
        assertThrows(IllegalArgumentException.class, () -> yourClass.validateInput("abc"));

        // 중복된 숫자가 있는 경우
        assertThrows(IllegalArgumentException.class, () -> yourClass.validateInput("112"));

        // 0이 있는 경우
        assertThrows(IllegalArgumentException.class, () -> yourClass.validateInput("102"));
    }


}