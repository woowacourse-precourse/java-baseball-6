package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNumberTest {
    @DisplayName("입력 받은 숫자가 1~9의 서로 다른 숫자 3개인 경우 정상 처리 된다.")
    @Test
    void validatePlayerNumber_o() {
        UserNumber userNumber = UserNumber.from(List.of(1, 2, 3));
        assertThat(userNumber.getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "[{index}] {0} 입력 시 예외가 발생한다.")
    @MethodSource("generateData")
    void validatePlayerNumber_ex(List<Integer> numbers) {
        assertThatThrownBy(() -> UserNumber.from(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2)),
                Arguments.of(List.of(1, 1, 2)),
                Arguments.of(List.of(1, 2, 10))
        );
    }
}