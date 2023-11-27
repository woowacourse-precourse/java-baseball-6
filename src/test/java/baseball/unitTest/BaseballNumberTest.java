package baseball.unitTest;

import static org.assertj.core.api.Assertions.*;

import baseball.model.vo.BaseballNumber;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[BaseballNumber] VO 테스트")
public class BaseballNumberTest {

    @DisplayName("[new] 생성자 테스트")
    @Nested
    class CreateTest {

        static Stream<Arguments> provideInput() {
            return Stream.of(
                    Arguments.of("숫자가 아닐 경우 예외 발생", "a"),
                    Arguments.of("0이 포함됐을 경우 예외 발생", "120"),
                    Arguments.of("3자리 숫자가 아닐 경우 예외 발생", "1234"),
                    Arguments.of("각 자리수가 중복된 숫자일 경우 예외 발생", "131")
            );
        }

        @ParameterizedTest(name = "[EXCEPTION] {0}")
        @MethodSource("provideInput")
        @DisplayName("[validate] 입력 검증 테스트")
        void should_throwException_when_notPassValidation(String message, String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> BaseballNumber.of(input));
        }
    }

    @DisplayName("[VO] 불변성 테스트")
    @Nested
    class ImmutableTest {

        @Test
        @DisplayName("[SUCCESS] 같은 숫자를 가진 두 객체가 같은 객체일 경우 true를 반환한다")
        void should_success_when_isSameObject() {
            BaseballNumber number1 = BaseballNumber.of("123");
            BaseballNumber number2 = BaseballNumber.of("123");

            assertThat(number1.equals(number2)).isTrue();
            assertThat(number1.hashCode()).isEqualTo(number2.hashCode());
        }
    }
}
