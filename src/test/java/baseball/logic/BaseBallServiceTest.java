package baseball.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
}