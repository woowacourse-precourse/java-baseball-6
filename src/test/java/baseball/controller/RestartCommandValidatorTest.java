package baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartCommandValidatorTest {
    RestartCommandValidator validator = new RestartCommandValidator();

    @Test
    @DisplayName("[성공 테스트] 재시작 여부 1")
    void correctRestartCommandInputTest1() {
        // given
        String restartCommandInput = "1";
        // when, then
        assertThatCode(() -> validator.validateRestartCommandInput(restartCommandInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[성공 테스트] 재시작 여부 2")
    void correctRestartCommandInputTest2() {
        // given
        String restartCommandInput = "2";
        // when, then
        assertThatCode(() -> validator.validateRestartCommandInput(restartCommandInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[실패 테스트] 1자리 수가 아님")
    void wrongLengthTest() {
        // given
        List<String> inputNums = List.of("10", "111", "-1", "00", "-100", "9999", "111111111",
                "-1.1", "0.0", "1.1", "0.9", "2.0", "2.1"); // double 까지 검사
        int wantLength = 1;
        // when, then
        for (String inputNum : inputNums) {
            assertThatThrownBy(() -> validator.validateRestartCommandInput(inputNum))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("[실패 테스트] 1자리 수 이지만, 1 또는 2가 아님")
    void sameLengthButWrongNumber() {
        // given
        List<String> inputNums = List.of("0", "3", "4", "5", "6", "7", "8", "9");
        // when, then
        for (String inputNum : inputNums) {
            assertThatThrownBy(() -> validator.validateRestartCommandInput(inputNum))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("[실패 테스트] 숫자가 아님")
    void notNumberTest() {
        // given
        List<String> inputNums = List.of("", " ", "1 ", " 1", "2 ", " 2", ".",  // 공백
                "\n", "1\n", "\n1", // 이스케이프
                "ㄱ1", "I14",    // 문자 혼합
                "adf", "이순신");  // 순수문자
        // when, then
        for (String inputNum : inputNums) {
            assertThatThrownBy(() -> validator.validateRestartCommandInput(inputNum))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}