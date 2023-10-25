package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.JudgmentTestConfig.TestJudgment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Judgment 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JudgmentTest {

    @Test
    void isBallAndStrike_메소드는_ball_개수가_0보다_크고_strike_개수가_0보다_크면_true를_반환한다() {
        TestJudgment judgment = new TestJudgment(1, 1);
        assertEquals(judgment.isBallAndStrike(), true);
    }

    @Test
    void isBallAndStrike_메소드는_ball_또는_strike_개수가_0이면_false를_반환한다() {
        TestJudgment judgment = new TestJudgment(1, 0);
        assertEquals(judgment.isBallAndStrike(), false);

        TestJudgment judgment2 = new TestJudgment(0, 1);
        assertEquals(judgment2.isBallAndStrike(), false);
    }

    @Test
    void isBall_메소드는_ball_개수가_0보다_크고_strike_개수가_0이면_true를_반환한다() {
        TestJudgment judgment = new TestJudgment(1, 0);
        assertEquals(judgment.isBall(), true);
    }

    @Test
    void isBall_메소드는_ball_개수가_0이면_false를_반환한다() {
        TestJudgment judgment = new TestJudgment(0, 1);
        assertEquals(judgment.isBall(), false);
    }

    @Test
    void isStrike_메소드는_ball_개수가_0이고_strike_개수가_숫자길이보다_적으면_true를_반환한다() {
        TestJudgment judgment = new TestJudgment(0, 2);
        assertEquals(judgment.isStrike(), true);
    }

    @Test
    void isStrike_메소드는_strike_개수가_0이면_false를_반환한다() {
        TestJudgment judgment = new TestJudgment(1, 0);
        assertEquals(judgment.isStrike(), false);
    }

    @Test
    void isNothing_메소드는_ball_strike_개수가_모두_0이면_true를_반환한다() {
        TestJudgment judgment = new TestJudgment(0, 0);
        assertEquals(judgment.isNothing(), true);
    }
}
