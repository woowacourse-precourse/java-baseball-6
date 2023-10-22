package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Nested
    @DisplayName("사용자 입력이 비었는지 검증할 시")
    class validate {

        @DisplayName("비어있지 않다면 성공적으로 종료된다.")
        @ValueSource(strings = {"1", "NULL", "*"})
        @ParameterizedTest(name = "입력: {0}")
        void success(String input){
            //given
            //when then
            InputValidator.validate(input);
        }

        @DisplayName("비어있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"\n", "\t", "", " ", "\r"})
        @ParameterizedTest(name = "입력: {0}")
        void fail_InvalidInput(String input){
            //given
            //when //then
            assertThatThrownBy(() -> InputValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}