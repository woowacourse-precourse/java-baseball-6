package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CarUtilsTest {

    @Test
    public void 랜덤으로_0부터_9까지의_정수_하나를_반환한다() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        assertTrue(randomValue >= 0 && randomValue <= 9);
    }

    @Test
    void 인풋으로받은_문자열을_split으로_쉼표기준으로_짤른이후_확인한다() {
        String input = "pobi,woni,jun";
        String[] expected = {"pobi", "woni", "jun"};

        String[] result = input.split(",");

        // 예상 결과와 실제 결과를 배열 요소별로 비교합니다.
        assertArrayEquals(expected, result);
    }
}
