package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.util.constants.BaseballGameConstants;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 야구 정답 생성기 테스트")
public class BaseballAnswerGeneratorTest {
    @Test
    @DisplayName("정답 길이 확인")
    void testAnswerLength() {
        int[] numbers = BaseballAnswerGenerator.generate();
        assertEquals(BaseballGameConstants.NUM_LENGTH, numbers.length);
    }

    @Test
    @DisplayName("정답 범위 확인")
    void testAnswerRange() {
        int[] numbers = BaseballAnswerGenerator.generate();
        assertTrue(Arrays.stream(numbers)
                .allMatch(v -> v >= BaseballGameConstants.MIN_NUM && v <= BaseballGameConstants.MAX_NUM));
    }

    @Test
    @DisplayName("정답 중복 확인")
    void testAnswerNotDuplicated() {
        int[] numbers = BaseballAnswerGenerator.generate();
        long distinctCount = Arrays.stream(numbers).distinct().count();
        assertEquals(numbers.length, distinctCount);
    }

}
