package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionCheckerTest {

    ExceptionChecker exceptionChecker = new ExceptionChecker();

    @DisplayName("유저 입력 정답이 3자리수가 아닌경우")
    @Test
    void checkAnswerSize() {
        String userInput = "1234";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> exceptionChecker.checkAnswerInputException(userInput));
        assertThat(e.getMessage()).isEqualTo("3자리 숫자만 입력 가능합니다.");
    }

    @DisplayName("유저 입력 정답에 문자가 포함된 경우")
    @Test
    void checkAnswerOnlyNumber() {
        String userInput = "X12";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> exceptionChecker.checkAnswerInputException(userInput));
        assertThat(e.getMessage()).isEqualTo("숫자만 입력 가능합니다.");
    }

    @DisplayName("유저 입력 정답이 1~9 범위가 아닌경우")
    @Test
    void checkAnswerNumberRange() {
        String userInput = "012";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> exceptionChecker.checkAnswerInputException(userInput));
        assertThat(e.getMessage()).isEqualTo("1~9사이 숫자만 입력 가능합니다.");
    }

    @DisplayName("유저 입력 정답에 중복된 숫자가 포함된 경우")
    @Test
    void checkDuplicated() {
        String userInput = "112";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> exceptionChecker.checkAnswerInputException(userInput));
        assertThat(e.getMessage()).isEqualTo("중복된 숫자는 입력이 불가능합니다.");
    }

    @DisplayName("재시작 입력때 1자리 숫자가 아닌경우")
    @Test
    void checkEndNumberSize() {
        String userInput = "12";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> exceptionChecker.checkRegameOrQuitInputException(userInput));
        assertThat(e.getMessage()).isEqualTo("1자리 숫자만 입력 가능합니다.");
    }

    @DisplayName("재시작 입력때 1~2 범위를 벗어난 경우")
    @Test
    void checkEndOnlyNumber() {
        String userInput = "3";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> exceptionChecker.checkRegameOrQuitInputException(userInput));
        assertThat(e.getMessage()).isEqualTo("1 혹은 2만 입력 가능합니다.");
    }
}