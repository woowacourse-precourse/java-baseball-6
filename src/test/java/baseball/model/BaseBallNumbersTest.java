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
        assertThatThrownBy(() -> BaseBallNumbers.from(overSizeIntegers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 야구_숫자_목록_사이즈에_벗어나지_않는_경우에는_객체_생성에_성공한다() {
        List<Integer> rightSizeIntegers = List.of(1, 2, 3);

        assertDoesNotThrow(() -> BaseBallNumbers.from(rightSizeIntegers));
    }

    @Test
    void 중복이_있는_야구_숫자는_야구_숫자_목록_생성에_실패한다() {
        List<Integer> duplicateNumbers = List.of(1, 1, 2);

        assertThatThrownBy(() -> BaseBallNumbers.from(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복이_없는_야구_숫자를_통해_야구_숫자_목록_생성에_성공한다() {
        List<Integer> noDuplicateNumbers = List.of(1, 2, 3);

        assertDoesNotThrow(() -> BaseBallNumbers.from(noDuplicateNumbers));
    }

    @Test
    void 랜덤한_야구_숫자_목록을_생성하는데_랜덤으로_생성된_목록이_중복이_없고_사이즈에_벗어나지_않는_경우_야구숫자_목록_생성에_성공한다() {
        List<Integer> initialNumbers = List.of(1, 2, 3);
        NumberGenerator numberGenerator = new SequentialNumberGenerator(initialNumbers);

        assertDoesNotThrow(() -> BaseBallNumbers.createRandomNumbers(numberGenerator));
    }

    @Test
    void 랜덤한_야구_숫자_목록을_생성하는데_랜덤으로_생성되는_숫자값이_중복인_경우_다시_랜덤으로_값을_구해_야구_숫자_목록을_생성한다() {
        List<Integer> duplicatedNumbers = List.of(1, 1, 2, 3);
        NumberGenerator numberGenerator = new SequentialNumberGenerator(duplicatedNumbers);
        List<Integer> expectedNumbers = List.of(1, 2, 3);
        BaseBallNumbers expectedBaseBallNumbers = BaseBallNumbers.from(expectedNumbers);

        BaseBallNumbers baseBallNumbers = BaseBallNumbers.createRandomNumbers(numberGenerator);

        assertThat(baseBallNumbers).usingRecursiveComparison()
                .isEqualTo(expectedBaseBallNumbers);
    }

    @Test
    void 랜덤한_야구_숫자_목록을_생성하는데_랜덤으로_생성되는_값이_야구_숫자_목록_사이즈를_벗어나지_않도록_생성한다() {
        List<Integer> initialNumbers = List.of(1, 2, 3, 4);
        NumberGenerator numberGenerator = new SequentialNumberGenerator(initialNumbers);
        List<Integer> expectedNumbers = List.of(1, 2, 3);
        BaseBallNumbers expectedBaseBallNumbers = BaseBallNumbers.from(expectedNumbers);

        BaseBallNumbers baseBallNumbers = BaseBallNumbers.createRandomNumbers(numberGenerator);

        assertThat(baseBallNumbers).usingRecursiveComparison()
                .isEqualTo(expectedBaseBallNumbers);
    }

    @ParameterizedTest
    @MethodSource("providePlayerBaseBallNumbersAndResult")
    void 야구_숫자_목록에_따라서_결과를_계산한다(List<Integer> playerNumbers, BaseBallGameResult expectedResult) {
        BaseBallNumbers computerNumbers = BaseBallNumbers.from(List.of(1, 2, 3));
        BaseBallNumbers playerBaseBallNumbers = BaseBallNumbers.from(playerNumbers);

        BaseBallGameResult baseBallGameResult = computerNumbers.evaluateGameResult(playerBaseBallNumbers);

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
        int threeStrikes = 3;
        int twoStrikes = 2;
        int oneStrike = 1;
        int noStrikes = 0;

        int threeBalls = 3;
        int twoBalls = 2;
        int oneBall = 1;
        int noBalls = 0;

        return Stream.of(
                Arguments.of(List.of(1, 2, 3), BaseBallGameResult.of(threeStrikes, noBalls)),
                Arguments.of(List.of(1, 2, 4), BaseBallGameResult.of(twoStrikes, noBalls)),
                Arguments.of(List.of(1, 3, 2), BaseBallGameResult.of(oneStrike, twoBalls)),
                Arguments.of(List.of(1, 3, 4), BaseBallGameResult.of(oneStrike, oneBall)),
                Arguments.of(List.of(1, 4, 5), BaseBallGameResult.of(oneStrike, noBalls)),
                Arguments.of(List.of(2, 3, 1), BaseBallGameResult.of(noStrikes, threeBalls)),
                Arguments.of(List.of(2, 3, 4), BaseBallGameResult.of(noStrikes, twoBalls)),
                Arguments.of(List.of(3, 4, 5), BaseBallGameResult.of(noStrikes, oneBall)),
                Arguments.of(List.of(4, 5, 6), BaseBallGameResult.of(noStrikes, noBalls))
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
