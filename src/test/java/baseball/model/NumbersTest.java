package baseball.model;

import baseball.game.model.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumbersTest {
    @ParameterizedTest
    @MethodSource("범위_1부터_9까지_성공_케이스")
    @DisplayName("입력된 수가 1부터 9사이의 수로 구성 - 성공 테스트")
    void 범위_1부터_9까지_성공_테스트(List<Integer> numbers) {
        Numbers number = new Numbers(numbers);
        assertThat(number.getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @MethodSource("범위_1부터_9까지_실패_케이스")
    @DisplayName("입력된 수가 1부터 9사이의 수로 구성 - 실패 테스트")
    void 범위_1부터_9까지_실패_테스트(List<Integer> numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지 범위의 수로 이루어져 있지 않습니다.");
    }

    @ParameterizedTest
    @MethodSource("중복된_수_성공_케이스")
    @DisplayName("중복된_수가_있는지_확인 - 성공 테스트")
    void 중복된_수_성공_테스트(List<Integer> numbers) {
        Numbers number = new Numbers(numbers);
        assertThat(number.getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @MethodSource("중복된_수_실패_케이스")
    @DisplayName("중복된_수가_있는지_확인 - 실패 테스트")
    void 중복된_수_실패_테스트(List<Integer> numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 수가 존재합니다.");
    }

    static Stream<Arguments> 중복된_수_실패_케이스() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2)),
                Arguments.of(List.of(2, 2, 2)),
                Arguments.of(List.of(1, 2, 1))
        );
    }

    static Stream<Arguments> 중복된_수_성공_케이스() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(2, 3, 6)),
                Arguments.of(List.of(1, 7, 3))
        );
    }

    static Stream<Arguments> 범위_1부터_9까지_성공_케이스() {
        return Stream.of(
                Arguments.of(List.of(1, 9, 2)),
                Arguments.of(List.of(1, 3, 6)),
                Arguments.of(List.of(1, 7, 3))
        );
    }

    static Stream<Arguments> 범위_1부터_9까지_실패_케이스() {
        return Stream.of(
                Arguments.of(List.of(11, 9, 2)),
                Arguments.of(List.of(0, 0, 6)),
                Arguments.of(List.of(0, 10, 0))
        );
    }
}
