package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BaseballTest {

    @Test
    void 볼_0개_스트라이크_1개() {
        Baseball baseball1 = new Baseball(Arrays.asList(1, 2, 3));
        Baseball baseball2 = new Baseball(Arrays.asList(1, 5, 6));
        BaseballResult baseballResult = baseball1.compareTo(baseball2);
        assertEquals("1스트라이크", baseballResult.toString());
    }

    @Test
    void 볼_3개_스트라이크_0개() {
        Baseball baseball1 = new Baseball(Arrays.asList(1, 2, 3));
        Baseball baseball2 = new Baseball(Arrays.asList(3, 1, 2));
        BaseballResult baseballResult = baseball1.compareTo(baseball2);
        assertEquals("3볼 ", baseballResult.toString());
    }

    @Test
    void 볼_1개_스트라이크_1개() {
        Baseball baseball1 = new Baseball(Arrays.asList(1, 2, 3));
        Baseball baseball2 = new Baseball(Arrays.asList(1, 4, 2));
        BaseballResult baseballResult = baseball1.compareTo(baseball2);
        assertEquals("1볼 1스트라이크", baseballResult.toString());
    }

    @Test
    void 스트라이크_3개() {
        Baseball baseball1 = new Baseball(Arrays.asList(1, 4, 2));
        Baseball baseball2 = new Baseball(Arrays.asList(1, 4, 2));
        BaseballResult baseballResult = baseball1.compareTo(baseball2);
        assertEquals(true, baseballResult.isGameDone());
    }
}