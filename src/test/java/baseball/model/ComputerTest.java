package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.GameResult;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class ComputerTest {

    @Test
    @DisplayName("컴퓨터는 숫자를 생성할 수 있다")
    void createNumbers() {
        List<Integer> numbers = Computer.createNumbers();
        Set<Integer> nonDuplicateNumbers = numbers.stream().collect(Collectors.toSet());
        List<Integer> validNumbersRange = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(nonDuplicateNumbers.size()).isEqualTo(3);
        assertThat(validNumbersRange).containsAll(numbers);
    }

    @DisplayName("컴퓨터는 숫자를 비교해 스트라이크와 볼 개수를 반환한다")
    @ParameterizedTest
    @MethodSource("compareData")
    void compare(List<Integer> computerNumber, List<Integer> userNumber, Map<GameResult, Long> expected) {
        Computer computer = new Computer(computerNumber);
        Numbers userNumbers = new Numbers(userNumber);
        Map<GameResult, Long> result = computer.compare(userNumbers);

        assertThat(result.get(GameResult.STRIKE)).isEqualTo(expected.get(GameResult.STRIKE));
        assertThat(result.get(GameResult.BALL)).isEqualTo(expected.get(GameResult.BALL));
    }

    @DisplayName("컴퓨터는 숫자를 비교해 같은 수가 없으면 낫싱을 반환한다")
    @Test
    void compareAndReturnNothing() {
        Computer computer = new Computer(List.of(1, 2, 3));
        Numbers userNumbers = new Numbers(List.of(4, 5, 6));
        Map<GameResult, Long> result = computer.compare(userNumbers);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.containsKey(GameResult.NOTHING)).isTrue();

    }

    static Stream<Arguments> compareData() {
        List<Integer> computerNumber = Arrays.asList(4, 2, 3);
        return Stream.of(
                Arguments.of(computerNumber, Arrays.asList(4, 2, 3),
                        Map.of(GameResult.STRIKE, 3L, GameResult.BALL, 0L)),
                Arguments.of(computerNumber, Arrays.asList(1, 2, 3),
                        Map.of(GameResult.STRIKE, 2L, GameResult.BALL, 0L)),
                Arguments.of(computerNumber, Arrays.asList(4, 3, 2),
                        Map.of(GameResult.STRIKE, 1L, GameResult.BALL, 2L)),
                Arguments.of(computerNumber, Arrays.asList(3, 2, 5),
                        Map.of(GameResult.STRIKE, 1L, GameResult.BALL, 1L)),
                Arguments.of(computerNumber, Arrays.asList(4, 5, 8),
                        Map.of(GameResult.STRIKE, 1L, GameResult.BALL, 0L)),
                Arguments.of(computerNumber, Arrays.asList(2, 3, 4),
                        Map.of(GameResult.STRIKE, 0L, GameResult.BALL, 3L)),
                Arguments.of(computerNumber, Arrays.asList(2, 3, 5),
                        Map.of(GameResult.STRIKE, 0L, GameResult.BALL, 2L)),
                Arguments.of(computerNumber, Arrays.asList(2, 5, 6), Map.of(GameResult.STRIKE, 0L, GameResult.BALL, 1L))
        );
    }

}