package baseball.number_creator;

import baseball.NumberCreator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GuessNumberTest extends NsTest {

    @Test
    void 중복된_수는_입력할_수_없습니다() {
        assertThatThrownBy(() -> run("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리_수만_입력할_수_있습니다() {
        assertThatThrownBy(() -> run("12"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> run("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자의_범위는_1부터_9까지_입니다() {
        assertThatThrownBy(() -> run("012"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> run("890"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_형식으로_세자리_수를_입력하면_통과합니다() {
        run("123");
        run("147");
        run("369");
    }

    @Override
    public void runMain() {
        NumberCreator numberCreator = NumberCreator.initGame();
        numberCreator.getGuessNumber();
    }
}
