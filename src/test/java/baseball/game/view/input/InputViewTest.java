package baseball.game.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.game.view.exception.NotMenuOptionException;
import baseball.game.view.exception.NumberContainsZeroException;
import baseball.game.view.exception.SizeNotMatchException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("정상_입력")
    void validInput() {
        String input = "123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        InputView inputView = new InputView(in);

        assertThat(inputView.getGuessNumbers())
                .contains(1, 2, 3);
    }

    @Test
    @DisplayName("예외_세자리보다_적은_숫자")
    void invalidInput1() {
        String input = "12\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThatThrownBy(() -> inputView.getGuessNumbers()).isInstanceOf(SizeNotMatchException.class);
    }

    @Test
    @DisplayName("예외_세자리보다_많은_숫자")
    void invalidInput2() {
        String input = "1234\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThatThrownBy(() -> inputView.getGuessNumbers()).isInstanceOf(SizeNotMatchException.class);
    }

    @Test
    @DisplayName("예외_숫자가_아닌_문자")
    void invalidInput3() {
        String input = "12a\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThatThrownBy(() -> inputView.getGuessNumbers()).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("예외_0이_포함된 숫자")
    void invalidInput4() {
        String input = "120\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThatThrownBy(() -> inputView.getGuessNumbers()).isInstanceOf(NumberContainsZeroException.class);
    }

    @Test
    @DisplayName("게임계속_입력")
    void askContinueTrue() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThat(inputView.askForGameContinue()).isTrue();
    }

    @Test
    @DisplayName("게임종료_입력")
    void askContinueFalse() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThat(inputView.askForGameContinue()).isFalse();
    }

    @Test
    @DisplayName("예외_게임종료_외_입력1")
    void askContinueError1() {
        String input = "12\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThatThrownBy(() -> inputView.askForGameContinue()).isInstanceOf(NotMenuOptionException.class);
    }

    @Test
    @DisplayName("예외_게임종료_외_입력2")
    void askContinueError2() {
        String input = "a\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(in);

        assertThatThrownBy(() -> inputView.askForGameContinue()).isInstanceOf(NotMenuOptionException.class);
    }
}