package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.config.ComputerTestConfig;
import baseball.config.JudgmentTestConfig.TestComputer;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Judgment 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JudgmentTest {

    private static Player player;

    @BeforeEach
    void setUp() {
        player = new Player("123");
    }

    private static Stream<Arguments> providePlayerAndComputerNumbers() {
        return Stream.of(
                Arguments.of("132", List.of(1, 2, 3), 2, 1),
                Arguments.of("123", List.of(1, 2, 3), 0, 3),
                Arguments.of("312", List.of(1, 2, 3), 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("providePlayerAndComputerNumbers")
    void Player와_Computer의_숫자를_비교해_ball_strike_개수를_계산한다(
            String playerNumbers, List<Integer> computerNumbers, int ball, int strike
    ) {
        Computer testComputer = new TestComputer(ball, strike);
        Player testPlayer = new Player(playerNumbers);
        Judgment testJudgment = new Judgment();
        testJudgment.judge(testComputer, testPlayer);

        Player player = new Player(playerNumbers);
        Computer computer = new ComputerTestConfig.TestComputer(computerNumbers);
        Judgment judgment = new Judgment();
        judgment.judge(computer, player);

        Assertions.assertEquals(judgment, testJudgment);
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
