package baseball;

import baseball.game.GoalValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GoalValueTest {
    @Test
    void 비교시_올바른_결과반환한다() {

    }

    @Test
    void 올바르지_않은_값으로_생성할수없다() {
        String[] cases = {"123", "456", "789", "112", "121", "211", "111", "", "1", "11", "1111", "cow", "24L"};
        boolean[] answers = {true, true, true, false, false, false, false, false, false, false, false, false, false};

        for (int i = 0; i < cases.length; i++) {
            try {
                GoalValue.create(cases[i]);
                if (!answers[i]) {
                    Assertions.fail("생성되면 안되는 값이 생성되었습니다. : " + cases[i]);
                }
            } catch (IllegalArgumentException expected) {
                if (answers[i]) {
                    Assertions.fail("올바른 값인데 생성하지 못했습니다. : " + cases[i]);
                }
            } catch (Exception e) {
                Assertions.fail("예상치 못한 오류가 발생했습니다. : " + cases[i], e);
            }
        }
    }
}
