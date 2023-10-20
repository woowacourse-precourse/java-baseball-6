package baseball;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallNumberTest {

    private GameRule rule;
    private BaseBallNumber userGuess;

    @BeforeEach
    void init() {
        rule = new GameRule(3, 1, 9);
        userGuess = new BaseBallNumber(rule);
    }

    @Test
    void 스트라이크_판정() {
        // given
        BaseBallNumber goalNumber = new BaseBallNumber(rule);
        goalNumber.initGoalNumber(new ArrayList<>(List.of(new Integer[]{1, 3, 5})));
        String[] inputs = {"246", "531", "136", "135"};
        for (int i = 0; i < 4; i++) {
            // when
            userGuess.setUserInput(inputs[i]);
            // then
            Assertions.assertEquals(i, goalNumber.countStrike(userGuess));
        }
    }
}
