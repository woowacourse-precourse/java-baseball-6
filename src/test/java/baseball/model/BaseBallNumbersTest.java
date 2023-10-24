package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBallNumbersTest {

    @ParameterizedTest
    @MethodSource("provideOverSizeIntegers")
    void 야구_숫자_목록_사이즈에_벗어나는_경우에는_야구_숫자_목록_생성_실패한다(List<Integer> overSizeIntegers) {
        assertThatThrownBy(() -> BaseBallNumbers.generateNumbers(overSizeIntegers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 야구_숫자_목록_사이즈에_벗어나지_않는_경우에는_객체_생성에_성공한다() {
        List<Integer> rightSizeIntegers = List.of(1, 2, 3);

        assertDoesNotThrow(() -> BaseBallNumbers.generateNumbers(rightSizeIntegers));
    }

    @Test
    void 중복이_있는_야구_숫자는_야구_숫자_목록_생성에_실패한다() {
        List<Integer> duplicateNumbers = List.of(1, 1, 2);

        assertThatThrownBy(() -> BaseBallNumbers.generateNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복이_없는_야구_숫자를_통해_야구_숫자_목록_생성에_성공한다() {
        List<Integer> noDuplicateNumbers = List.of(1, 2, 3);

        assertDoesNotThrow(() -> BaseBallNumbers.generateNumbers(noDuplicateNumbers));
    }

    @Test
    void 랜덤한_야구_숫자_목록을_생성하는데_랜덤으로_생성된_목록이_중복이_없고_사이즈에_벗어나지_않는_경우_야구숫자_목록_생성에_성공한다() {
        List<Integer> initialNumbers = List.of(1, 2, 3);
        NumberGenerator numberGenerator = new SequentialNumberGenerator(initialNumbers);

        assertDoesNotThrow(() -> BaseBallNumbers.generateRandomNumbers(numberGenerator));
    }

    @Test
    void 랜덤한_야구_숫자_목록을_생성하는데_랜덤으로_생성되는_숫자값이_중복인_경우_다시_랜덤으로_값을_구해_야구_숫자_목록을_생성한다() {
        List<Integer> duplicatedNumbers = List.of(1, 1, 2, 3);
        NumberGenerator numberGenerator = new SequentialNumberGenerator(duplicatedNumbers);
        List<Integer> expectedNumbers = List.of(1, 2, 3);
        BaseBallNumbers expectedBaseBallNumbers = BaseBallNumbers.generateNumbers(expectedNumbers);

        BaseBallNumbers baseBallNumbers = BaseBallNumbers.generateRandomNumbers(numberGenerator);

        assertThat(baseBallNumbers).usingRecursiveComparison()
                .isEqualTo(expectedBaseBallNumbers);
    }

    @Test
    void 랜덤한_야구_숫자_목록을_생성하는데_랜덤으로_생성되는_값이_야구_숫자_목록_사이즈를_벗어나지_않도록_생성한다() {
        List<Integer> initialNumbers = List.of(1, 2, 3, 4);
        NumberGenerator numberGenerator = new SequentialNumberGenerator(initialNumbers);
        List<Integer> expectedNumbers = List.of(1, 2, 3);
        BaseBallNumbers expectedBaseBallNumbers = BaseBallNumbers.generateNumbers(expectedNumbers);

        BaseBallNumbers baseBallNumbers = BaseBallNumbers.generateRandomNumbers(numberGenerator);

        assertThat(baseBallNumbers).usingRecursiveComparison()
                .isEqualTo(expectedBaseBallNumbers);
    }

    @ParameterizedTest
    @MethodSource("providePlayerBaseBallNumbersAndResult")
    void 야구_숫자_목록에_따라서_결과를_계산한다(List<Integer> playerNumbers, BaseBallGameResult expectedResult) {
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateNumbers(List.of(1, 2, 3));
        BaseBallNumbers playerBaseBallNumbers = BaseBallNumbers.generateNumbers(playerNumbers);

        BaseBallGameResult baseBallGameResult = computerNumbers.calculateResult(playerBaseBallNumbers);

        assertThat(baseBallGameResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideOverSizeIntegers() {
        final List<Integer> overSizeIntegers = List.of(1, 2, 3, 4);
        final List<Integer> underSizeIntegers = List.of(1, 2);

        return Stream.of(
                Arguments.of(underSizeIntegers),
                Arguments.of(overSizeIntegers)
        );
    }

    private static Stream<Arguments> providePlayerBaseBallNumbersAndResult() {
        return Stream.of(
                // 3 strike
                Arguments.of(List.of(1, 2, 3), BaseBallGameResult.of(3, 0)),
                // 2 strike
                Arguments.of(List.of(1, 2, 4), BaseBallGameResult.of(2, 0)),
                // 1 strike, 2 ball
                Arguments.of(List.of(1, 3, 2), BaseBallGameResult.of(1, 2)),
                // 1 strike, 1 ball
                Arguments.of(List.of(1, 3, 4), BaseBallGameResult.of(1, 1)),
                // 1 strike
                Arguments.of(List.of(1, 4, 5), BaseBallGameResult.of(1, 0)),
                // 3 ball
                Arguments.of(List.of(2, 3, 1), BaseBallGameResult.of(0, 3)),
                // 2 ball
                Arguments.of(List.of(2, 3, 4), BaseBallGameResult.of(0, 2)),
                // 1 ball
                Arguments.of(List.of(3, 4, 5), BaseBallGameResult.of(0, 1)),
                // nothing
                Arguments.of(List.of(4, 5, 6), BaseBallGameResult.of(0, 0))
        );
    }

    private static class SequentialNumberGenerator implements NumberGenerator {

        private static final String NO_MORE_NUMBER_EXCEPTION_MESSAGE = "더 이상 숫자를 생성할 수 없습니다.";
        private final Queue<Integer> numbers;

        public SequentialNumberGenerator(List<Integer> initialNumbers) {
            this.numbers = new LinkedList<>(initialNumbers);
        }

        @Override
        public int generate(int min, int max) {
            if (numbers.isEmpty()) {
                throw new IllegalStateException(NO_MORE_NUMBER_EXCEPTION_MESSAGE);
            }
            return numbers.poll();
        }

    }

}
