package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class ComputerTest {

    @Test
    @DisplayName("컴퓨터는 숫자를 생성할 수 있다")
    void createNumbers(){
        List<Integer> numbers = Computer.createNumbers();
        Set<Integer> nonDuplicateNumbers = numbers.stream().collect(Collectors.toSet());
        List<Integer> validNumbersRange = List.of(1,2,3,4,5,6,7,8,9);

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(nonDuplicateNumbers.size()).isEqualTo(3);
        assertThat(validNumbersRange).containsAll(numbers);
    }

    @DisplayName("컴퓨터는 숫자를 비교해 스트라이크와 볼 개수를 반환한다")
    @ParameterizedTest
    @MethodSource("calculateData")
    void calculate(List<Integer> computerNumber, List<Integer> userNumber, Map<String ,Long> expected){
        Computer computer = new Computer(computerNumber);
        GameNumber userGameNumber = new GameNumber(userNumber);
        Map<String, Long> result = computer.calculate(userGameNumber);
        assertThat(expected.get("스트라이크")).isEqualTo(result.get("스트라이크"));
        assertThat(expected.get("볼")).isEqualTo(result.get("볼"));
    }

    static Stream<Arguments> calculateData() {
        List<Integer> computerNumber = Arrays.asList(4, 2, 3);
        return Stream.of(
                Arguments.of(computerNumber, Arrays.asList(4, 2, 3), Map.of("스트라이크", 3L, "볼", 0L)),
                Arguments.of(computerNumber, Arrays.asList(1, 2, 3), Map.of("스트라이크", 2L, "볼", 0L)),
                Arguments.of(computerNumber, Arrays.asList(4, 3, 2), Map.of("스트라이크", 1L, "볼", 2L)),
                Arguments.of(computerNumber, Arrays.asList(3, 2, 5), Map.of("스트라이크", 1L, "볼", 1L)),
                Arguments.of(computerNumber, Arrays.asList(4, 5, 8), Map.of("스트라이크", 1L, "볼", 0L)),
                Arguments.of(computerNumber, Arrays.asList(2, 3, 4), Map.of("스트라이크", 0L, "볼", 3L)),
                Arguments.of(computerNumber, Arrays.asList(2, 3, 5), Map.of("스트라이크", 0L, "볼", 2L)),
                Arguments.of(computerNumber, Arrays.asList(2, 5, 6), Map.of("스트라이크", 0L, "볼", 1L))
        );
    }
}