package baseball.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("입력값이 4자리 숫자면 예외를 발생시킨다.")
    @Test
    void exception4digit() {
        //given
        //when
        //then
        assertThatThrownBy(() -> InputValidator.isValidInput("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 3자리만 입력 가능합니다.");
    }
    @DisplayName("입력값이 2자리 숫자면 예외를 발생시킨다.")
    @Test
    void exception2digit() {
        //given
        //when
        //then
        assertThatThrownBy(() -> InputValidator.isValidInput("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 3자리만 입력 가능합니다.");
    }

    @DisplayName("입력값이 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void exceptionNotDigit() {
        //given
        //when
        //then
        assertThatThrownBy(() -> InputValidator.isValidInput("1a2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @DisplayName("입력값이 중복된 숫자면 예외를 발생시킨다.")
    @Test
    void exceptionNotDistinct() {
        //given
        //when
        //then
        assertThatThrownBy(() -> InputValidator.isValidInput("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자는 입력할 수 없습니다.");
    }

    @DisplayName("입력값이 3자리 숫자이고, 숫자가 서로 다르면 예외를 발생시키지 않는다.")
    @Test
    void normalInput() {
        //given
        //when
        //then
        assertThatCode(() -> InputValidator.isValidInput("123"))
                .doesNotThrowAnyException();
    }

    @DisplayName("재시작 입력값이 1이면 예외를 발생시키지 않는다.")
    @Test
    void restartWhen1() {
        //given
        //when
        //then
        assertThatCode(() -> InputValidator.isValidRestart("1"))
                .doesNotThrowAnyException();
    }
    @DisplayName("재시작 입력값이 2이면 예외를 발생시키지 않는다.")
    @Test
    void restartWhen2() {
        //given
        //when
        //then
        assertThatCode(() -> InputValidator.isValidRestart("2"))
                .doesNotThrowAnyException();
    }

    @DisplayName("재시작 입력값이 1 또는 2가 아니면 예외를 발생시킨다.")
    @Test
    void exceptionWhenNot1or2() {
        //given
        //when
        //then
        assertThatThrownBy(() -> InputValidator.isValidRestart("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2만 입력 가능합니다.");
    }

}