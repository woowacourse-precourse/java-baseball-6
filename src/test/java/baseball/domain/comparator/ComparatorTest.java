package baseball.domain.comparator;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.baseballnumber.BaseballNumbers;
import baseball.domain.compararesult.CompareResult;
import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[ComparatorTest]")
class ComparatorTest {

    @ParameterizedTest(name = "[{index}] : {0}, {1} -> {2}")
    @MethodSource("compareData")
    @DisplayName("발생하는 모든 결과에 대한 비교 테스트")
    void compareWithEveryCases(final List<Integer> computerInput,
                            final List<Integer> playerInput,
                            final String expectedResult) {
        // given
        BaseballNumbers computerNumbers = new BaseballNumbers(computerInput);
        Computer computer = new Computer(computerNumbers);

        BaseballNumbers playerNumbers = new BaseballNumbers(playerInput);
        Player player = new Player();
        player.changeNumbers(playerNumbers);

        Comparator comparator = new Comparator(computer, player);

        // when
        CompareResult compareResult = comparator.compare();

        // then
        assertThat(compareResult.toString()).isEqualTo(expectedResult);
    }

    static Stream<Arguments> compareData() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), "낫싱"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 5, 6), "1스트라이크"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 1, 6), "1볼"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 5, 2), "1볼 1스트라이크"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), "2볼 1스트라이크"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 3, 2), "2볼"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 5, 3), "2스트라이크"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2), "3볼"),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), "3스트라이크")
        );
    }
}