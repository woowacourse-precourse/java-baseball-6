package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerBallsTest {

    @Test
    void 생성_테스트() {
        Integer[] input = {1, 2, 3};
        PlayerBalls result = new PlayerBalls(input);
        List<Ball> expect = List.of(new Ball(1), new Ball(2), new Ball(3));
        assertEquals(expect, result.getBalls());
    }

    @Test
    void 입력_개수_초과_테스트() {
        Integer[] input = {1, 2, 3, 4, 5};
        assertThrows(IllegalArgumentException.class, () ->
                new PlayerBalls(input)
        );
    }

    @Test
    void 중복_숫자_입력_테스트() {
        Integer[] input = {1, 1, 3};
        assertThrows(IllegalArgumentException.class, () ->
                new PlayerBalls(input)
        );
    }
}