package baseball.game.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.game.controller.dto.NumberListDto;
import baseball.game.view.exception.CharacterNotNumberException;
import baseball.game.view.exception.NotMenuOptionException;
import baseball.game.view.exception.NumberContainsZeroException;
import baseball.game.view.exception.SizeNotMatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("정상_입력")
    void validInput() {
        String input = "123";
        InputView inputView = new InputView();

        NumberListDto userInputNumbers = inputView.convertOrThrow(input);

        assertThat(userInputNumbers.getNumberList())
                .contains(1, 2, 3);
    }

    @Test
    @DisplayName("예외_세자리보다_적은_숫자")
    void invalidInput1() {
        String input = "12";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.convertOrThrow(input)).isInstanceOf(SizeNotMatchException.class);
    }

    @Test
    @DisplayName("예외_세자리보다_많은_숫자")
    void invalidInput2() {
        String input = "1234";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.convertOrThrow(input)).isInstanceOf(SizeNotMatchException.class);
    }

    @Test
    @DisplayName("예외_숫자가_아닌_문자")
    void invalidInput3() {
        String input = "12a\n";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.convertOrThrow(input)).isInstanceOf(CharacterNotNumberException.class);
    }

    @Test
    @DisplayName("예외_0이_포함된 숫자")
    void invalidInput4() {
        String input = "120";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.convertOrThrow(input)).isInstanceOf(NumberContainsZeroException.class);
    }

    @Test
    @DisplayName("게임계속_입력")
    void askContinueTrue() {
        String input = "1";

        InputView inputView = new InputView();

        assertThatCode(() -> inputView.isMenuOption(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("게임종료_입력")
    void askContinueFalse() {
        String input = "2";

        InputView inputView = new InputView();

        assertThatCode(() -> inputView.isMenuOption(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("예외_게임종료_외_입력1")
    void askContinueError1() {
        String input = "12";

        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.isMenuOption(input)).isInstanceOf(NotMenuOptionException.class);
    }

    @Test
    @DisplayName("예외_게임종료_외_입력2")
    void askContinueError2() {
        String input = "a";

        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.isMenuOption(input)).isInstanceOf(NotMenuOptionException.class);
    }
}