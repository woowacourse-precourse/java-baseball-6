package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTest {

    @Test
    @DisplayName("서로 다른 1부터 9까지의 숫자 3자리는 허용한다.")
    void acceptValidInput() {
        assertThatCode(() -> new BaseballNumber("123"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 3자리보다 짧으면 예외가 발생한다")
    void rejectShortInput() {
        assertInvalidInput("12");
    }

    @Test
    @DisplayName("입력값이 3자리보다 길면 예외가 발생한다")
    void rejectLongInput() {
        assertInvalidInput("1234");
    }

    @Test
    @DisplayName("0이 포함되면 예외가 발생한다")
    void rejectZero() {
        assertInvalidInput("012");
    }

    @Test
    @DisplayName("문자가 포함되면 예외가 발생한다")
    void rejectLetters() {
        assertInvalidInput("1a3");
    }

    @Test
    @DisplayName("공백이 포함되면 예외가 발생한다")
    void rejectWhitespace() {
        assertInvalidInput("1 3");
    }

    @Test
    @DisplayName("숫자가 중복되면 예외가 발생한다")
    void rejectDuplicateDigits() {
        assertInvalidInput("121");
    }

    @Test
    @DisplayName("입력값이 비어 있으면 예외가 발생한다.")
    void rejectEmptyInput() {
        assertInvalidInput("");
    }

    private void assertInvalidInput(String input) {
        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자와 위치가 같으면 스트라이크로 계산한다")
    void countStrikes() {
        BaseballNumber answer = new BaseballNumber("425");
        BaseballNumber guess = new BaseballNumber("426");

        GameResult result = answer.compare(guess);

        assertThat(result.ballCount()).isZero();
        assertThat(result.strikeCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자는 같고 위치가 다르면 볼로 계산한다")
    void countBalls() {
        BaseballNumber answer = new BaseballNumber("425");
        BaseballNumber guess = new BaseballNumber("254");

        GameResult result = answer.compare(guess);

        assertThat(result.ballCount()).isEqualTo(3);
        assertThat(result.strikeCount()).isZero();
    }

    @Test
    @DisplayName("볼과 스트라이크를 함께 계산한다")
    void countBallsAndStrikes() {
        BaseballNumber answer = new BaseballNumber("425");
        BaseballNumber guess = new BaseballNumber("456");

        GameResult result = answer.compare(guess);

        assertThat(result.ballCount()).isEqualTo(1);
        assertThat(result.strikeCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("일치하는 숫자가 없으면 볼과 스트라이크는 모두 0이다")
    void countNoMatches() {
        BaseballNumber answer = new BaseballNumber("425");
        BaseballNumber guess = new BaseballNumber("789");

        GameResult result = answer.compare(guess);

        assertThat(result.ballCount()).isZero();
        assertThat(result.strikeCount()).isZero();
    }

    @Test
    @DisplayName("정답과 같으면 3스트라이크이고 볼은 0이다")
    void countAllStrikes() {
        BaseballNumber answer = new BaseballNumber("425");
        BaseballNumber guess = new BaseballNumber("425");

        GameResult result = answer.compare(guess);

        assertThat(result.ballCount()).isZero();
        assertThat(result.strikeCount()).isEqualTo(3);
    }
}
