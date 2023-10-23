package baseball.model;

import baseball.constant.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameNumberTest {

    @DisplayName("숫자는 3개 가질 수 있다")
    @ParameterizedTest
    @MethodSource("inValidSizeData")
    void validateSize(List<Integer> inValidNumbers){
        assertThrows(IllegalArgumentException.class,() -> new GameNumber(inValidNumbers));
    }

    @DisplayName("숫자는 1부터 9까지만 가질 수 있다")
    @ParameterizedTest
    @MethodSource("inValidRangeData")
    void validateRange(List<Integer> inValidNumbers){
        assertThrows(IllegalArgumentException.class,() -> new GameNumber(inValidNumbers));
    }

    @DisplayName("숫자는 서로 다른 수로 이루어져 있다")
    @ParameterizedTest
    @MethodSource("inValidDuplicateData")
    void validateDuplicate(List<Integer> inValidNumbers){
        assertThrows(IllegalArgumentException.class,() -> new GameNumber(inValidNumbers));
    }

    @DisplayName("같은 수애 같은 자리에 있는 수의 개수를 구할 수 있다")
    @ParameterizedTest
    @MethodSource("matchCountData")
    void matchCount(List<Integer> computerNumber, List<Integer> userNumber, long expected){
        GameNumber computerGameNumber = new GameNumber(computerNumber);
        GameNumber userGameNumber = new GameNumber(userNumber);
        long result = computerGameNumber.matchCount(userGameNumber);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("같은 수에 다른 자리에 있는 수의 개수를 구할 수 있다")
    @ParameterizedTest
    @MethodSource("containsCountData")
    void containsCount(List<Integer> computerNumber, List<Integer> userNumber, long expected){
        GameNumber computerGameNumber = new GameNumber(computerNumber);
        GameNumber userGameNumber = new GameNumber(userNumber);
        long result = computerGameNumber.containsCount(userGameNumber);
        assertThat(result).isEqualTo(expected);
    }


    static Stream<Arguments> inValidSizeData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2))
        );
    }
    static Stream<Arguments> inValidRangeData() {
        return Stream.of(
                Arguments.of(Arrays.asList(-1, 2, 33)),
                Arguments.of(Arrays.asList(0, 0, 0)),
                Arguments.of(Arrays.asList(11, 22, 33))
        );
    }
    static Stream<Arguments> inValidDuplicateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 1)),
                Arguments.of(Arrays.asList(2, 2, 2)),
                Arguments.of(Arrays.asList(5, 3, 3))
        );
    }
    static Stream<Arguments> matchCountData() {
            List<Integer> computerNumber = Arrays.asList(4, 2, 3);
            return Stream.of(
                    Arguments.of(computerNumber, Arrays.asList(4, 2, 3), 3L),
                    Arguments.of(computerNumber, Arrays.asList(1, 2, 3), 2L),
                    Arguments.of(computerNumber, Arrays.asList(4, 3, 2), 1L),
                    Arguments.of(computerNumber, Arrays.asList(3, 4, 5), 0L)
        );
    }
    static Stream<Arguments> containsCountData() {
        List<Integer> computerNumber = Arrays.asList(4, 2, 3);
        return Stream.of(
                Arguments.of(computerNumber, Arrays.asList(4, 2, 3), 3L),
                Arguments.of(computerNumber, Arrays.asList(4, 3, 2), 3L),
                Arguments.of(computerNumber, Arrays.asList(1, 2, 3), 2L),
                Arguments.of(computerNumber, Arrays.asList(3, 2, 5), 2L),
                Arguments.of(computerNumber, Arrays.asList(3, 6, 5), 1L),
                Arguments.of(computerNumber, Arrays.asList(6, 7, 8), 0L)
        );
    }
}