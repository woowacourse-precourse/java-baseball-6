package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballRefereeTest {
    private static BaseballReferee baseballReferee;

    @BeforeAll
    static void setUp() {
        baseballReferee = new BaseballReferee();
    }

    @Test
    @DisplayName("볼 개수 테스트")
    void countBallTest() {
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(3, 4, 1);

        UserInputResult userInputResult = baseballReferee.scoreInput(expect, actual);

        assertEquals(2, userInputResult.getBall());
    }

    @Test
    @DisplayName("스트라이크 개수 테스트")
    void countStrikeTest() {
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(1, 4, 3);

        UserInputResult userInputResult = baseballReferee.scoreInput(expect, actual);

        assertEquals(2, userInputResult.getStrike());
    }

    @Test
    @DisplayName("볼과 스트라이크 개수 테스트")
    void countBallAndStrikeTest() {
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(1, 3, 4);

        UserInputResult userInputResult = baseballReferee.scoreInput(expect, actual);

        assertEquals(1, userInputResult.getBall());
        assertEquals(1, userInputResult.getStrike());
    }

    @Test
    @DisplayName("낫싱 테스트")
    void countNoBallAndStrikeTest() {
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(4, 5, 6);

        UserInputResult userInputResult = baseballReferee.scoreInput(expect, actual);

        assertEquals(0, userInputResult.getBall());
        assertEquals(0, userInputResult.getStrike());
    }
}