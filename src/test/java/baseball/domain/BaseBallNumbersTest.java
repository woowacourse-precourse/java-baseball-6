package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBallNumbersTest {

    @DisplayName("야구 숫자 목록 사이즈에 벗어나는 경우에는 객체 생성 실패한다")
    @ParameterizedTest
    @MethodSource("provideOverSizeIntegers")
    void 야구_숫자_목록_사이즈에_벗어나는_경우에는_객체_생성_실패한다(List<Integer> overSizeIntegers) {
        assertThatThrownBy(() -> BaseBallNumbers.generateNumbers(overSizeIntegers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("야구 숫자 목록 사이즈에 벗어나지 않는 경우에는 객체 생성에 성공한다")
    @Test
    void 야구_숫자_목록_사이즈에_벗어나지_않는_경우에는_객체_생성에_성공한다() {
        List<Integer> rightSizeIntegers = List.of(1, 2, 3);

        assertDoesNotThrow(() -> BaseBallNumbers.generateNumbers(rightSizeIntegers));
    }

    @DisplayName("중복이 있는 야구 숫자는 객체 생성에 실패한다")
    @Test
    void 중복이_있는_야구_숫자는_객체_생성에_실패한다() {
        List<Integer> duplicateNumbers = List.of(1, 1, 2);

        assertThatThrownBy(() -> BaseBallNumbers.generateNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복이 없는 야구 숫자를 객체 생성에 성공한다")
    @Test
    void 중복이_없는_야구_숫자를_객체_생성에_성공한다() {
        List<Integer> noDuplicateNumbers = List.of(1, 2, 3);

        assertDoesNotThrow(() -> BaseBallNumbers.generateNumbers(noDuplicateNumbers));
    }

    private static Stream<Arguments> provideOverSizeIntegers() {
        return Stream.of(
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4))
        );
    }

}
