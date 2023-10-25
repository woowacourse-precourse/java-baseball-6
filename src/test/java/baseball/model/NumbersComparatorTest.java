package baseball.model;

import baseball.game.model.Numbers;
import baseball.game.model.NumbersComparator;
import baseball.game.model.dto.GameResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersComparatorTest {

    @DisplayName("N스트라이크 M볼 테스트")
    @ParameterizedTest
    @MethodSource("랜덤_숫자와_사용자가_입력한_숫자를_비교")
    void 입력값과_정답값을_비교_N스트라이크_M볼(Numbers numbers, List<Integer> randomNumbers, GameResultDto expected) {
        NumbersComparator comparator = new NumbersComparator();

        GameResultDto executeResult = comparator.checkNumber(numbers, randomNumbers);

        assertThat(executeResult.getBall()).isEqualTo(expected.getBall());
        assertThat(executeResult.getStrike()).isEqualTo(expected.getStrike());
    }

    private static Stream<Arguments> 랜덤_숫자와_사용자가_입력한_숫자를_비교() {
        return Stream.of(
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(2, 4, 5), new GameResultDto(0, 3)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(2, 4, 6), new GameResultDto(0, 2)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(1, 4, 3), new GameResultDto(0, 1)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(5, 2, 4), new GameResultDto(3, 0)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(5, 2, 6), new GameResultDto(2, 0)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(4, 1, 3), new GameResultDto(1, 0)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(2, 5, 3), new GameResultDto(1, 1)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(2, 5, 4), new GameResultDto(2, 1)),
                Arguments.of(new Numbers(List.of(2, 4, 5)), List.of(1, 3, 6), new GameResultDto(0, 0))
        );
    }

}
