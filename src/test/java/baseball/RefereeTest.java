package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RefereeTest {

    @Test
    @DisplayName("judge 메서드 작동 확인 테스트")
    void judge() {
        Referee referee = Referee.enter();
        referee.playBall(3, 5, 7);

        int[] input = new int[]{1, 5, 3};
        int[] judge = referee.judge(input);

        assertTrue(judge[0] == 2 && judge[1] == 1);
    }
}