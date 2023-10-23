package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballTest {

    @Nested
    @DisplayName("세 자리 숫자를 생성할 시")
    class from {

        static private Stream<Arguments> getSuccessTestInput() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3)),
                    Arguments.of(List.of(6, 5, 4)),
                    Arguments.of(List.of(7, 8, 9)));
        }

        static private Stream<Arguments> getValidationFailTestInput() {
            return Stream.of(
                    Arguments.of(List.of()),
                    Arguments.of(List.of(2, 3)),
                    Arguments.of(List.of(1, 2, 3, 4)),
                    Arguments.of(List.of(1, 2, 2)),
                    Arguments.of(List.of(2, 1, 2)),
                    Arguments.of(List.of(2, 2, 1)),
                    Arguments.of(List.of(3, 3, 3)));
        }

        @DisplayName("성공적으로 생성한다")
        @MethodSource("getSuccessTestInput")
        @ParameterizedTest(name = "입력: {0}")
        void success(List<Integer> input) {
            //given
            //when
            Baseball baseball = Baseball.from(input);

            //then
            assertThat(baseball).isNotNull();
            assertThat(baseball.getBaseballNumbers()).hasSize(input.size())
                    .extracting(BaseballNumber::getNumber)
                    .containsExactlyElementsOf(input);
        }

        @DisplayName("유효성 검사에 실패하면 예외를 발생시킨다")
        @MethodSource("getValidationFailTestInput")
        @ParameterizedTest(name = "입력: {0}")
        void fail_ValidationFail(List<Integer> input) {
            //given
            //when then
            assertThatThrownBy(() -> Baseball.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}