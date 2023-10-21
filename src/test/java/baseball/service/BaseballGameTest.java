package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    public void isCountToWin_3Strike_true() {
        // given
        int strikeCount = 3;

        // when
        boolean countToWin = BaseballGame.isCountToWin(strikeCount);

        // then
        assertTrue(countToWin);
    }

    @Test
    public void isCountToWin_2Strike_false() {
        // given
        int strikeCount = 2;

        // when
        boolean countToWin = BaseballGame.isCountToWin(strikeCount);

        // then
        assertFalse(countToWin);
    }

    @Test
    public void calculateBall_test() {
        // given
        List<Integer> numbers = Lists.newArrayList(1, 2, 3);
        BaseballGame baseballGame = new BaseballGame(numbers);

        // when && then
        int result1 = baseballGame.calculateBall(Lists.newArrayList(1, 2, 3));
        assertEquals(result1, 0);

        int result2 = baseballGame.calculateBall(Lists.newArrayList(3, 1, 2));
        assertEquals(result2, 3);

        int result3 = baseballGame.calculateBall(Lists.newArrayList(2, 1, 8));
        assertEquals(result3, 2);
    }

    @Test
    public void calculateStrike_test() {
        // given
        List<Integer> numbers = Lists.newArrayList(1, 2, 3);
        BaseballGame baseballGame = new BaseballGame(numbers);

        // when && then
        int result1 = baseballGame.calculateStrike(Lists.newArrayList(1, 2, 3));
        assertEquals(result1, 3);

        int result2 = baseballGame.calculateStrike(Lists.newArrayList(3, 1, 2));
        assertEquals(result2, 0);

        int result3 = baseballGame.calculateStrike(Lists.newArrayList(1, 2, 8));
        assertEquals(result3, 2);
    }

    @Test
    public void isPlayerWin_3Strike_true() {
        // given
        List<Integer> numbers = Lists.newArrayList(1, 2, 3);
        BaseballGame baseballGame = new BaseballGame(numbers);

        // when
        boolean isPlayerWin = baseballGame.isPlayerWin(Lists.newArrayList(1, 2, 3));
        assertTrue(isPlayerWin);
    }

    @Test
    public void isPlayerWin_2Strike_false() {
        // given
        List<Integer> numbers = Lists.newArrayList(1, 2, 3);
        BaseballGame baseballGame = new BaseballGame(numbers);

        // when
        boolean isPlayerWin = baseballGame.isPlayerWin(Lists.newArrayList(1, 2, 8));
        assertFalse(isPlayerWin);
    }
}