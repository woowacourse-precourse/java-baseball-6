package baseball.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    Validator validator = new Validator();

    @Test
    void 사용자_입력_길이초과_테스트() {
        String userInput = "1234";
        assertThatThrownBy(() -> validator.checkUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_정수_입력_테스트() {
        String userInput = "012";
        assertThatThrownBy(() -> validator.checkUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_중복_숫자_테스트() {
        String userInput = "112";
        assertThatThrownBy(() -> validator.checkUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_예외_테스트() {
        String restartInput = "3";
        assertThatThrownBy(() -> validator.checkUserInput(restartInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}