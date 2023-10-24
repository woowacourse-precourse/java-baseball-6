package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballTest {

    private static List<BaseballNumber> getBaseNumberList(Integer... input) {
        return Arrays.stream(input)
                .map(BaseballNumber::new)
                .toList();
    }

    @Nested
    @DisplayName("세 자리 숫자를 생성할 시")
    class from {

        static private Stream<Arguments> getSuccessTestInput() {
            return Stream.of(
                    Arguments.of(getBaseNumberList(1, 2, 3)),
                    Arguments.of(getBaseNumberList(6, 5, 4)),
                    Arguments.of(getBaseNumberList(7, 8, 9)));
        }

        static private Stream<Arguments> getFailInvalidLengthTestInput() {
            return Stream.of(
                    Arguments.of(getBaseNumberList()),
                    Arguments.of(getBaseNumberList(2, 3)),
                    Arguments.of(getBaseNumberList(1, 2, 3, 4)));
        }

        static private Stream<Arguments> getFailDuplicatedTestInput() {
            return Stream.of(
                    Arguments.of(getBaseNumberList(1, 2, 2)),
                    Arguments.of(getBaseNumberList(2, 1, 2)),
                    Arguments.of(getBaseNumberList(2, 2, 1)),
                    Arguments.of(getBaseNumberList(3, 3, 3)));
        }

        @DisplayName("성공적으로 생성한다")
        @MethodSource("getSuccessTestInput")
        @ParameterizedTest(name = "입력: {0}")
        void success(List<BaseballNumber> input) {
            //given
            //when
            Baseball baseball = Baseball.from(input);

            //then
            assertThat(baseball).isNotNull();
            assertThat(baseball.getBaseballNumbers()).hasSize(input.size())
                    .containsExactlyElementsOf(input);
        }

        @DisplayName("숫자의 길이가 3 이상이라면 예외를 발생시킨다")
        @MethodSource("getFailInvalidLengthTestInput")
        @ParameterizedTest(name = "입력: {0}")
        void fail_InvalidLength(List<BaseballNumber> input) {
            //given
            //when then
            assertThatThrownBy(() -> Baseball.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("중복 숫자가 있다면 예외를 발생시킨다")
        @MethodSource("getFailDuplicatedTestInput")
        @ParameterizedTest(name = "입력: {0}")
        void fail_Duplicated(List<BaseballNumber> input) {
            //given
            //when then
            assertThatThrownBy(() -> Baseball.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}