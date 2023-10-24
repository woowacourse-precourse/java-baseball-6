package baseball.util;

import baseball.ball.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class RandomUniqueNumberTest {
    @Test
    @DisplayName("랜덤한 번호 만들기")
    void testMakeRandomNum() {
        List<Integer> randomUniqueNumbers = RandomUniqueNumber.getRandomUniqueNumbers(3);

        Set<Integer> uniqueSet = new HashSet<>(randomUniqueNumbers);
        assertThat(uniqueSet.size() == Balls.BALLS_SIZE);
    }
}
