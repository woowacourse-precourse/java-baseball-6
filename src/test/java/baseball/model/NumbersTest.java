package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumbersTest {

    @DisplayName("숫자가 3개가 아니면 예외를 던진다")
    @ParameterizedTest
    @MethodSource("inValidSizeData")
    void validateSize(List<Integer> inValidNumbers) {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(inValidNumbers));
    }

    @DisplayName("숫자가 1부터 9까지의 수로 이루어지지 않았으면 예외를 던진다")
    @ParameterizedTest
    @MethodSource("inValidRangeData")
    void validateRange(List<Integer> inValidNumbers) {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(inValidNumbers));
    }

    @DisplayName("숫자가 서로 다른 수로 이루어져 있지 않으면 예외를 던진다")
    @ParameterizedTest
    @MethodSource("inValidDuplicateData")
    void validateDuplicate(List<Integer> inValidNumbers) {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(inValidNumbers));
    }

    @DisplayName("같은 수에 같은 자리에 있는 수의 개수를 구할 수 있다")
    @ParameterizedTest
    @MethodSource("matchData")
    void countMatching(List<Integer> computerNumber, List<Integer> userNumber, long expected) {
        Numbers computerNumbers = new Numbers(computerNumber);
        Numbers userNumbers = new Numbers(userNumber);
        long result = computerNumbers.countMatching(userNumbers);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("같은 수에 다른 자리에 있는 수의 개수를 구할 수 있다")
    @ParameterizedTest
    @MethodSource("containsData")
    void countContains(List<Integer> computerNumber, List<Integer> userNumber, long expected) {
        Numbers computerNumbers = new Numbers(computerNumber);
        Numbers userNumbers = new Numbers(userNumber);
        long result = computerNumbers.countContains(userNumbers);
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

    static Stream<Arguments> matchData() {
        List<Integer> computerNumber = Arrays.asList(4, 2, 3);
        return Stream.of(
                Arguments.of(computerNumber, Arrays.asList(4, 2, 3), 3L),
                Arguments.of(computerNumber, Arrays.asList(1, 2, 3), 2L),
                Arguments.of(computerNumber, Arrays.asList(4, 3, 2), 1L),
                Arguments.of(computerNumber, Arrays.asList(3, 4, 5), 0L)
        );
    }

    static Stream<Arguments> containsData() {
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