package baseball;

import baseball.game.CompareResult;
import baseball.game.GoalValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoalValueTest {
    @Test
    void 비교시_올바른_결과반환한다() {
        // given
        String[][] cases = {{"123", "321"}, {"123", "123"}, {"123", "231"}, {"123", "456"}};
        int[][] answers = {{2, 1}, {0, 3}, {3, 0}, {0, 0}};

        for (int i = 0; i < cases.length; i++) {
            // when
            GoalValue goalValue1 = GoalValue.create(cases[i][0]);
            GoalValue goalValue2 = GoalValue.create(cases[i][1]);

            CompareResult result = GoalValue.compare(goalValue1, goalValue2);

            // then
            assertEquals(result.getBall(), answers[i][0],
                    "case " + cases[i][0] + ", " + cases[i][1] + "에서 ball 불일치");
            assertEquals(result.getStrike(), answers[i][1],
                    "case " + cases[i][0] + ", " + cases[i][1] + "에서 strike 불일치");
        }
    }

    @Test
    void 올바르지_않은_값으로_생성할수없다() {
        // given
        String[] cases = {"123", "456", "789", "112", "121", "211", "111", "", "1", "11", "1111", "cow", "24L"};
        boolean[] answers = {true, true, true, false, false, false, false, false, false, false, false, false, false};

        for (int i = 0; i < cases.length; i++) {
            // when
            String value = cases[i];

            // then
            if (answers[i]) {
                assertDoesNotThrow(() -> GoalValue.create(value),
                        "올바른 값인데 생성하지 못했습니다. : " + cases[i]);
            } else {
                assertThrows(IllegalArgumentException.class, () -> GoalValue.create(value),
                        "생성되면 안되는 값이 생성되었습니다. : " + cases[i]);
            }
        }
    }
}
