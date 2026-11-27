package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartChoiceTest {

    @Test
    @DisplayName("1은 재시작 선택으로 변환한다")
    void acceptRestartChoice() {
        assertThat(RestartChoice.from("1"))
                .isEqualTo(RestartChoice.RESTART);
    }

    @Test
    @DisplayName("2는 종료 선택으로 변환한다")
    void acceptExitChoice() {
        assertThat(RestartChoice.from("2"))
                .isEqualTo(RestartChoice.EXIT);
    }

    @Test
    @DisplayName("1과 2 이외의 숫자는 거부한다")
    void rejectOtherNumber() {
        assertInvalidChoice("3");
    }

    @Test
    @DisplayName("문자는 거부한다")
    void rejectLetter() {
        assertInvalidChoice("a");
    }

    @Test
    @DisplayName("빈 문자열은 거부한다")
    void rejectEmptyInput() {
        assertInvalidChoice("");
    }

    @Test
    @DisplayName("공백이 포함된 입력은 거부한다")
    void rejectWhitespace() {
        assertInvalidChoice("1 ");
    }

    private void assertInvalidChoice(String input) {
        assertThatThrownBy(() -> RestartChoice.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
