package baseball.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareTest {

    private Compare compare;

    @BeforeEach
    void setUp() {
        compare = new Compare();
    }

    @DisplayName("같은 수가 같은 자리에 있을 때 스트라이크 확인 테스트")
    @ParameterizedTest
    @CsvSource({"123, 1", "413, 1", "135, 1", "421, 2", "415, 2", "125, 2", "425, 3"})
    void confirmSamePositionStrike(String userInput, int expectedStrikes) {
        // given
        List<Integer> computerInput = List.of(4, 2, 5);

        // when
        String result = compare.getGameResult(computerInput, userInput);

        // then
        assertTrue(result.contains(expectedStrikes + "스트라이크"));
    }

    @DisplayName("같은 수가 다른 자리에 있을 때 볼 확인 테스트")
    @ParameterizedTest
    @CsvSource({"213, 1", "341, 1", "742, 2", "512, 2", "542, 3"})
    void confirmOtherPositionBall(String userInput, int expectedBall) {
        // given
        List<Integer> computerInput = List.of(4, 2, 5);

        // when
        String result = compare.getGameResult(computerInput, userInput);

        // then
        assertTrue(result.contains(expectedBall + "볼"));
    }

    @DisplayName("컴퓨터와 사용자의 숫자가 전부 다를 경우 낫싱 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"183", "891", "316"})
    void confirmNothingTest(String userInput) {
        // given
        List<Integer> computerInput = List.of(4, 2, 5);

        // when
        String result = compare.getGameResult(computerInput, userInput);

        // then
        assertTrue(result.equals("낫싱"));
    }

    @DisplayName("3자리 미만 혹은 초과 정수가 입력되었을 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "3542", "6523562"})
    void confirmInputOverOrUnderThreeNumber(String userInput) {
        // given
        List<Integer> computerInput = List.of(4, 2, 5);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            compare.getGameResult(computerInput, userInput);
        });

        // then
        assertEquals("3자리의 양의 정수를 입력해야 됩니다. 사용자의 입력 : " + userInput, illegalArgumentException.getMessage());
    }

    @DisplayName("사용자가 중복된 숫자가 입력했을 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"112", "223", "445", "787", "131", "828"})
    void confirmInputDuplicatedNumbers(String userInput) {
        // given
        List<Integer> computerInput = List.of(4, 2, 5);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            compare.getGameResult(computerInput, userInput);
        });

        // then
        assertEquals("서로 다른 양의 정수 3자리가 입력되어야 합니다. 사용자의 입력 : " + userInput, illegalArgumentException.getMessage());
    }
}