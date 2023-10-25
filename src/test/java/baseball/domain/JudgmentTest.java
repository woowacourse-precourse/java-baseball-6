package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.config.JudgmentTestConfig.TestComputer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Judgment 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JudgmentTest {

    private static Player player;

    @BeforeAll
    static void setUp() {
        player = new Player("123");
    }

    @Test
    void isBallAndStrike_메소드는_ball_개수가_0보다_크고_strike_개수가_0보다_크면_true를_반환한다() {
        Judgment judgment = new Judgment();
        TestComputer computer = new TestComputer(1, 1);
        judgment.judge(computer, player);

        assertEquals(judgment.isBallAndStrike(), true);
    }

    @Test
    void isBallAndStrike_메소드는_ball_또는_strike_개수가_0이면_false를_반환한다() {
        Judgment judgment = new Judgment();
        TestComputer computer = new TestComputer(1, 0);
        judgment.judge(computer, player);

        assertEquals(judgment.isBallAndStrike(), false);
    }

    @Test
    void isBall_메소드는_ball_개수가_0보다_크고_strike_개수가_0이면_true를_반환한다() {
        Judgment judgment = new Judgment();
        TestComputer computer = new TestComputer(1, 0);
        judgment.judge(computer, player);

        assertEquals(judgment.isBall(), true);
    }

    @Test
    void isBall_메소드는_ball_개수가_0이면_false를_반환한다() {
        Judgment judgment = new Judgment();
        TestComputer computer = new TestComputer(0, 1);
        judgment.judge(computer, player);

        assertEquals(judgment.isBall(), false);
    }

    @Test
    void isStrike_메소드는_ball_개수가_0이고_strike_개수가_숫자길이보다_적으면_true를_반환한다() {
        Judgment judgment = new Judgment();
        TestComputer computer = new TestComputer(0, 2);
        judgment.judge(computer, player);

        assertEquals(judgment.isStrike(), true);
    }

    @Test
    void isStrike_메소드는_strike_개수가_0이면_false를_반환한다() {
        Judgment judgment = new Judgment();
        TestComputer computer = new TestComputer(1, 0);
        judgment.judge(computer, player);

        assertEquals(judgment.isStrike(), false);
    }

    @Test
    void isNothing_메소드는_ball_strike_개수가_모두_0이면_true를_반환한다() {
        Judgment judgment = new Judgment();
        TestComputer computer = new TestComputer(0, 0);
        judgment.judge(computer, player);

        assertEquals(judgment.isNothing(), true);
    }
}
