package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameOptionValidatorTest {

    @Test
    @DisplayName("게임 재시작 옵션이 1 또는 2일 경우 예외를 발생시키지 않는다.")
    void doesNotThrowExceptionOfGameRestartOption1Or2() {
        //given
        String gameRestartOptionOne = "1";
        String gameRestartOptionTwo = "2";
        //when //then
        assertThatCode(() -> GameOptionValidator.validateGameRestartOption(gameRestartOptionOne))
            .doesNotThrowAnyException();
        assertThatCode(() -> GameOptionValidator.validateGameRestartOption(gameRestartOptionTwo))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("게임 재시작 옵션에 수가 아닌 문자일 경우 예외를 발생시킨다.")
    void throwExceptionOfGameRestartOptionNotDigit() {
        //given
        String gameRestartOption = "일";
        //when //then
        assertThatThrownBy(() -> GameOptionValidator.validateGameRestartOption(gameRestartOption))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("재시작 옵션은 1또는 2를 입력해야 합니다.");
    }

    @Test
    @DisplayName("게임 재시작 옵션이 1 또는 2가 아닌 수일 경우 예외를 발생시킨다.")
    void doesNotThrowExceptionOfGameRestartOptionNot1Or2() {
        //given
        String gameRestartOption = "11";
        //when //then
        assertThatThrownBy(() -> GameOptionValidator.validateGameRestartOption(gameRestartOption))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("재시작 옵션은 1또는 2를 입력해야 합니다.");
    }
}