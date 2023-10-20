package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballGameResultTest {

    @Test
    void 결과_계산_볼_하나_스트라이크_하나() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        List<Integer> userNumbs = List.of(2, 5, 1);
        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        assertEquals(gameResult.ballCount, 1);
        assertEquals(gameResult.strikeCount, 1);
    }

    @Test
    void 결과_계산_볼_하나_스트라이크_없음() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        List<Integer> userNumbs = List.of(2, 4, 1);
        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        assertEquals(gameResult.ballCount, 1);
        assertEquals(gameResult.strikeCount, 0);
    }

    @Test
    void 결과_계산_볼_둘_스트라이크_없음() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        List<Integer> userNumbs = List.of(2, 3, 1);
        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        assertEquals(gameResult.ballCount, 2);
        assertEquals(gameResult.strikeCount, 0);
    }

    @Test
    void 결과_계산_볼_없음_스트라이크_셋() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        List<Integer> userNumbs = List.of(3, 5, 2);
        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        assertEquals(gameResult.ballCount, 0);
        assertEquals(gameResult.strikeCount, 3);
    }

    @Test
    void 결과_계산_볼_셋_스트라이크_없음() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        List<Integer> userNumbs = List.of(5, 2, 5);
        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        assertEquals(gameResult.ballCount, 3);
        assertEquals(gameResult.strikeCount, 0);
    }
}
