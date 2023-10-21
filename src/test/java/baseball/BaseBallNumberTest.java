package baseball;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BaseBallNumberTest {

    private GameRule rule;
    private BaseBallNumber userGuess;
    private BaseBallNumber goalNumber;

    @BeforeEach
    void init() {
        rule = new GameRule(3, 1, 9);
        userGuess = new BaseBallNumber(rule);
        goalNumber = new BaseBallNumber(rule);
    }

    @Test
    void 스트라이크_판정() {
        // given
        MockedStatic<RandomNumberGenerator> mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        mocked.when(() -> RandomNumberGenerator.getNonDuplicateNumbers(rule)).thenReturn(List.of(1, 3, 5));
        BaseBallNumber goalNumber = new BaseBallNumber(rule);
        goalNumber.initGoalNumber();
        String[] inputs = {"246", "531", "136", "135"};
        for (int i = 0; i < 4; i++) {
            // when
            userGuess.setUserInput(inputs[i]);
            // then
            Assertions.assertEquals(i, goalNumber.countStrike(userGuess));
        }
        mocked.close();
    }

    @Test
    void 볼_판정() {
        // given
        MockedStatic<RandomNumberGenerator> mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        mocked.when(() -> RandomNumberGenerator.getNonDuplicateNumbers(rule)).thenReturn(List.of(1, 3, 5));
        BaseBallNumber goalNumber = new BaseBallNumber(rule);
        goalNumber.initGoalNumber();
        String[] inputs = {"246", "214", "913", "351"};
        for (int i = 0; i < 4; i++) {
            // when
            userGuess.setUserInput(inputs[i]);
            // then
            Assertions.assertEquals(i, goalNumber.countBall(userGuess));
        }
        mocked.close();
    }
}
