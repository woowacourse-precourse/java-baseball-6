package baseball.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallServiceTest {

    private BaseBallService baseBallService;

    @BeforeEach
    void setUp() {
        baseBallService = new BaseBallService();
    }

    @DisplayName("같은 수가 같은 자리에 있을 때 스트라이크 확인 테스트")
    @ParameterizedTest
    @CsvSource({"123, 1", "413, 1", "135, 1", "421, 2", "415, 2", "125, 2", "425, 3"})
    void confirmSamePositionStrike(int userInput, int expectedStrikes) {
        // given
        int computerInput = 425;

        // when
        String result = baseBallService.getGameResult(computerInput, userInput);

        // then
        assertTrue(result.contains(expectedStrikes + "스트라이크"));
    }

    @DisplayName("같은 수가 다른 자리에 있을 때 볼 확인 테스트")
    @ParameterizedTest
    @CsvSource({"542, 1", "387, 1", "217, 1", "321, 2", "359, 2", "953, 2","351, 3"})
    void confirmOtherPositionBall(int userInput, int expectedBall) {
        // given
        int computerInput = 135;

        // when
        String result = baseBallService.getGameResult(computerInput, userInput);

        // then
        assertTrue(result.contains(expectedBall + "볼"));
    }

    @DisplayName("컴퓨터와 사용자의 숫자가 전부 다를 경우 낫싱 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {183, 891, 345})
    void confirmNothingTest(int userInput) {
        // given
        int computerInput = 206;

        // when
        String result = baseBallService.getGameResult(computerInput, userInput);

        // then
        assertTrue(result.equals("낫싱"));
    }

    @DisplayName("3자리 미만 혹은 초과 정수가 입력되었을 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 12, 3542, 6523562})
    void confirmInputOverOrUnderThreeNumber(int userInput) {
        // given
        int computerInput = 352;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            baseBallService.getGameResult(computerInput, userInput);
        });

        // then
        assertEquals("3자리의 정수를 입력해야 됩니다. 사용자의 입력 : " + userInput, illegalArgumentException.getMessage());
    }
}