package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgmentTest {

    @DisplayName("컴퓨터 숫자와 사용자 숫자 같은 갯수 테스트")
    @Test
    void NumberCorrectCount() {
        Judgment judgment = new Judgment();
        int count = judgment.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1));

        assertEquals(3, count);
    }

    @DisplayName("같은 자리에 같은 숫자 있는지 확인 테스트")
    @Test
    void NumberHasPlace() {
        Judgment judgment = new Judgment();
        boolean hasPlace = judgment.hasPlace(Arrays.asList(1, 2, 3), 0, 1);

        assertTrue(hasPlace);
    }

}
