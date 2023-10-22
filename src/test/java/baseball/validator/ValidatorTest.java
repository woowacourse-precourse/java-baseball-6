package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("숫자야구 입력시 고유한 3자리 숫자를 입력한다면 검증에 성공한다.")
    @ParameterizedTest(name = "[{index} 차]시도: input: {0}")
    @ValueSource(strings = {"123", "456", "789", "158", "321"})
    void testVerifyForBaseballNumber(String input) {
        //given
        //when
        validator.verifyForBaseballNumber(input);
        //then
    }

    @DisplayName("게임 재시작 여부 입력시 1또는 2를 입력한다면 검증에 성공한다.")
    @ParameterizedTest(name = "[{index} 차]시도: input: {0}")
    @ValueSource(strings = {"1", "2"})
    void testVerifyForRedo(String input) {
        //given
        //when
        validator.verifyForRedo(input);
        //then
    }


    @DisplayName("게임 재시작 여부 입력시 1 또는 2가 아니면 IllegalException 밠생한다.")
    @ParameterizedTest(name = "[{index} 차]시도: input: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"12", "english", "한글", "aaaa", "1a"})
    void failVerifyForRedo(String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> validator.verifyForRedo(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 야구 입력시 고유한 3자리라는 조건을 충족하지 않으면 IllegalException 밠생한다.")
    @ParameterizedTest(name = "[{index} 차]시도: input: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"1", "12", "1234", "1aa", "12a", "abc"})
    void failVerifyForBaseballNumber(String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> validator.verifyForBaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}