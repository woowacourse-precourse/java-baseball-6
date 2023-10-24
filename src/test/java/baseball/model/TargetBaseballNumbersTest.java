package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

class TargetBaseballNumbersTest {
    @Test
    @DisplayName("생성 시 중복 숫자 건너뛰기 테스트")
    void verifyRandomInstanceDuplicationNumberSkipTest() {
        try (MockedStatic<BaseballNumber> baseballNumber = mockStatic(BaseballNumber.class)) {
            when(BaseballNumber.createRandomNumber())
                    .thenReturn(
                            new BaseballNumber(1),
                            new BaseballNumber(1),
                            new BaseballNumber(1),
                            new BaseballNumber(2),
                            new BaseballNumber(3));

            TargetBaseballNumbers targetBaseballNumbers = TargetBaseballNumbers.randomInstance();
            baseballNumber.verify(BaseballNumber::createRandomNumber, times(5));
        }
    }

    @ParameterizedTest
    @DisplayName("게임 결과 계산 실패 테스트 - 사이즈 불일치")
    @MethodSource("wrongSizeInputNumbers")
    void verifySizeTest(List<Integer> playerInputNumbers) {
        TargetBaseballNumbers targetBaseballNumbers = TargetBaseballNumbers.randomInstance();
        assertThrows(IllegalArgumentException.class, () ->
                targetBaseballNumbers.calculateGameResult(playerInputNumbers));
    }

    public static Stream<Arguments> wrongSizeInputNumbers() {
        return Stream.of(
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @DisplayName("게임 결과 계산 실패 테스트 - 중복값 존재")
    @MethodSource("duplicateInputNumbers")
    void verifyDuplicateTest(List<Integer> playerInputNumbers) {
        TargetBaseballNumbers targetBaseballNumbers = TargetBaseballNumbers.randomInstance();
        assertThrows(IllegalArgumentException.class, () ->
                targetBaseballNumbers.calculateGameResult(playerInputNumbers));
    }

    public static Stream<Arguments> duplicateInputNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 1)),
                Arguments.of(List.of(1, 1, 2)),
                Arguments.of(List.of(1, 2, 1)),
                Arguments.of(List.of(2, 1, 1))
        );
    }

    @ParameterizedTest
    @DisplayName("게임 결과 반환 테스트")
    @MethodSource("inputNumbersAndExpectResults")
    void calculateGameResultTest(List<Integer> playerInputNumbers, int strikeCount, int ballCount) {
        try (MockedStatic<BaseballNumber> baseballNumber = mockStatic(BaseballNumber.class)) {
            when(BaseballNumber.createRandomNumber())
                    .thenReturn(
                            new BaseballNumber(1),
                            new BaseballNumber(2),
                            new BaseballNumber(3));

            TargetBaseballNumbers targetBaseballNumbers = TargetBaseballNumbers.randomInstance();
            GameResult gameResult = targetBaseballNumbers.calculateGameResult(playerInputNumbers);
            assertThat(gameResult.correctCount()).isEqualTo(strikeCount);
            assertThat(gameResult.similarCount()).isEqualTo(ballCount);
        }
    }

    public static Stream<Arguments> inputNumbersAndExpectResults() {
        return Stream.of(
                Arguments.of(List.of(4,5,6), 0, 0),
                Arguments.of(List.of(1,5,6), 1, 0),
                Arguments.of(List.of(4,2,6), 1, 0),
                Arguments.of(List.of(4,5,3), 1, 0),
                Arguments.of(List.of(4,1,6), 0, 1),
                Arguments.of(List.of(4,5,1), 0, 1),
                Arguments.of(List.of(2,5,6), 0, 1),
                Arguments.of(List.of(4,5,2), 0, 1),
                Arguments.of(List.of(3,5,6), 0, 1),
                Arguments.of(List.of(4,3,6), 0, 1),
                Arguments.of(List.of(1,3,6), 1, 1),
                Arguments.of(List.of(1,5,2), 1, 1),
                Arguments.of(List.of(3,2,6), 1, 1),
                Arguments.of(List.of(4,2,1), 1, 1),
                Arguments.of(List.of(4,1,3), 1, 1),
                Arguments.of(List.of(2,5,3), 1, 1),
                Arguments.of(List.of(1,3,2), 1, 2),
                Arguments.of(List.of(3,2,1), 1, 2),
                Arguments.of(List.of(2,1,3), 1, 2),
                Arguments.of(List.of(1,2,6), 2, 0),
                Arguments.of(List.of(1,5,3), 2, 0),
                Arguments.of(List.of(4,2,3), 2, 0),
                Arguments.of(List.of(1,2,3), 3, 0)
        );
    }
}