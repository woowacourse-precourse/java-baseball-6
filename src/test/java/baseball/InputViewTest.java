package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest extends NsTest {

    private String choice;

    @Test
    @DisplayName("1을 입력하면 재시작 선택을 반환한다")
    void acceptRestartChoice() {
        run("1");

        assertThat(choice).isEqualTo("1");
    }

    @Test
    @DisplayName("2를 입력하면 종료 선택을 반환한다")
    void acceptExitChoice() {
        run("2");

        assertThat(choice).isEqualTo("2");
    }

    @Test
    @DisplayName("1과 2 이외의 숫자는 거부한다")
    void rejectOtherNumber() {
        assertInvalidChoice("3");
    }

    @Test
    @DisplayName("문자 입력은 거부한다")
    void rejectLetter() {
        assertInvalidChoice("a");
    }

    @Test
    @DisplayName("빈 입력은 거부한다")
    void rejectEmptyInput() {
        assertInvalidChoice("\n");
    }

    @Test
    @DisplayName("공백이 포함된 입력은 거부한다")
    void rejectWhitespace() {
        assertInvalidChoice("1 ");
    }

    private void assertInvalidChoice(String input) {
        assertThatThrownBy(() -> run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        InputView inputView = new InputView();
        choice = inputView.readRestartChoice();
    }
}
