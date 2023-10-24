package baseball.people.preparation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("strikeOut 메서드 작동 확인 테스트")
    void strikeOut() {
        Referee referee = Referee.enter();
        referee.playBall(3, 5, 7);

        int[] input = new int[]{1, 5, 3};
        boolean strikeOut = referee.strikeOut(input);

        assertFalse(strikeOut);
    }
}