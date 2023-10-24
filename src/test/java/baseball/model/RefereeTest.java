package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
        referee.setGame();
    }

    @DisplayName("[Referee] 1. Goal Number 생성 : 세자리 수 여부 test")
    @Test
    void generateGoalNumber_Test1() {
        // Given
        String goalNumber = referee.goalNumber;
        // When & Then
        assertEquals(3, goalNumber.length());
    }

    @DisplayName("[Referee] 1. Goal Number 생성 : 연속 숫자인지 여부 test")
    @Test
    void generateGoalNumber_Test2() {
        String goalNumber = referee.goalNumber;
        long distinctCount = goalNumber.chars().distinct().count();

        assertEquals(3, distinctCount);
    }

    @DisplayName("[Referee]  1. Goal Number 생성 : 1~9로 이루어진 수 여부 test")
    @Test
    void generateGoalNumber_Test3() {
        String goalNumber = referee.goalNumber;

        for (char c : goalNumber.toCharArray()) {
            int digit = Character.getNumericValue(c);
            assertTrue(digit >= 1 && digit <= 9);
        }
    }

    @DisplayName("[Referee] 2. 볼판정 확인")
    @ParameterizedTest(name = "{index} => playerNumber={0}, expected={1}")
    @MethodSource("provideNumbersForCallBallCount")
    void callBallCount_Test(String playerNumber, int[] expected) {
        // Given
        Referee referee = new Referee();
        referee.goalNumber = "628";
        // When && Then
        assertThat(referee.callBallCount(playerNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersForCallBallCount() {
        return Stream.of(
                Arguments.of("179", new int[]{0, 0}),
                Arguments.of("123", new int[]{0, 1}),
                Arguments.of("629", new int[]{0, 2}),
                Arguments.of("628", new int[]{0, 3}),
                Arguments.of("826", new int[]{2, 1}),
                Arguments.of("286", new int[]{3, 0})
        );
    }

    @DisplayName("[Referee] 3. 삼진 아웃 판정 : ")
    @Test
    void isStrikeOut_Test() {
        // Given
        int[] ballCount_strikeOut = new int[]{0,3};
        int[] ballCount_ball = new int[]{1, 2};
        //When && Then
        assertThat(referee.isStrikeOut(ballCount_strikeOut)).isEqualTo(true);
        assertThat(referee.isStrikeOut(ballCount_ball)).isEqualTo(false);
    }


}