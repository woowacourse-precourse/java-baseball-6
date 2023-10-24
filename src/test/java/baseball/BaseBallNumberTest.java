package baseball;


import baseball.model.BaseBallNumber;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseBallNumber 관련 테스트")
class BaseBallNumberTest {


    @ParameterizedTest(name = "{0} 실패, 값 : {1}")
    @MethodSource("inValidNumberArray")
    @DisplayName("잘못된 사용자 입력이 들어온 경우 BaseBallNumber 생성 실패 테스트")
    void InvalidInputStringExceptionThrown(String reason, String inputNumber) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> BaseBallNumber.parse(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> inValidNumberArray() {
        return Stream.of(
                Arguments.of("3자리보다 큰 숫자 문자열이 들어온 경우", "1234"),
                Arguments.of("3자리보다 작은 숫자 문자열이 들어온 경우", "12"),
                Arguments.of("-가 포함된 경우", "-112"),
                Arguments.of("영어 소문자가 포함된 경우", "a12"),
                Arguments.of("영어 소문자로만 이루어진 경우", "abc"),
                Arguments.of("한글로만 이루어진 경우", "테스트"),
                Arguments.of("특수문자가 포함된 경우", "~!@"),
                Arguments.of("특수문자가 포함되어 3자리인 경우", "~12"),
                Arguments.of("특수문자가 포함되고 3자리보다 큰 경우", "123!"),
                Arguments.of("특수문자가 포함되고 3자리보다 작은 경우", "1!")
        );
    }

}
