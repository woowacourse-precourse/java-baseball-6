package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballTest {

    private Baseball computerBall;

    @BeforeEach
    void setup() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        computerBall = new Baseball(numbers);
    }

    @Test
    void 포함된_공_계산() {
        List<Integer> numbers = Arrays.asList(3, 1, 6);
        Baseball userBall = new Baseball(numbers);
        assertEquals("2볼 ", computerBall.compareTo(userBall).toString());
    }

    @Test
    void 동일한_위치_공_계산() {
        List<Integer> numbers = Arrays.asList(1, 2, 5);
        Baseball userBall = new Baseball(numbers);
        assertEquals("2스트라이크", computerBall.compareTo(userBall).toString());
    }

}