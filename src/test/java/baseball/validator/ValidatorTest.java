package baseball.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 재시작_종료_옵션_검증() {
        // 입력값이 1 또는 2가 아닌 경우
        assertThatThrownBy(() -> Validator.isValidGameOption("3")).isInstanceOf(IllegalArgumentException.class);

        // 정상적인 입력값인 경우
        assertDoesNotThrow(() -> Validator.isValidGameOption("1"));
        assertDoesNotThrow(() -> Validator.isValidGameOption("2"));
    }
    @Test
    void 사용자에게_입력받은_값_검증() {
        // length가 3이 아닌 경우
        assertThatThrownBy(() -> Validator.isValidNumbers("1244")).isInstanceOf(IllegalArgumentException.class);
        // 정수가 아닌 경우
        assertThatThrownBy(() -> Validator.isValidNumbers("1a3")).isInstanceOf(IllegalArgumentException.class);
        // 중복된 값이 있는 경우
        assertThatThrownBy(() -> Validator.isValidNumbers("223")).isInstanceOf(IllegalArgumentException.class);
        // 0이 포함된 경우
        assertThatThrownBy(() -> Validator.isValidNumbers("103")).isInstanceOf(IllegalArgumentException.class);

        // 유효한 값인 경우
        assertDoesNotThrow(() -> Validator.isValidNumbers("289"));
    }

    @Test
    void 정수인지_판별() {
        // 입력값이 정수인 경우
        assertThat(Validator.isInteger("123")).isTrue();
        // 입력값이 정수가 아닌 경우
        assertThat(Validator.isInteger("1A3")).isFalse();
    }

    @Test
    void 중복_값_있는지_확인() {
        // 입력값에 중복이 없는 경우
        assertThat(Validator.hasDuplicate("124")).isFalse();
        // 입력값에 중복이 있는 경우
        assertThat(Validator.hasDuplicate("224")).isTrue();
    }

    @Test
    void 입력받은_값_세자리_확인() {
        // 입력받은 값 length가 3인 경우
        assertThat(Validator.isValidDigit("123")).isTrue();
        // 입력받은 값 length가 3이 아닌 경우
        assertThat(Validator.isValidDigit("1234")).isFalse();
        assertThat(Validator.isValidDigit("12345")).isFalse();
    }

    @Test
    void 문자_0이_포함되어_있는지_확인() {
        // 0이 없는 경우
        assertThat(Validator.hasZero("124")).isFalse();
        // 0이 있는 경우
        assertThat(Validator.hasZero("104")).isTrue();
    }

}