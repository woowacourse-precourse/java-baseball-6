package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class NumberCreatorTest extends NsTest {

    @Test
    void 랜덤으로_중복되지_않는_3개의_수를_반환한다() {
        // given
        NumberCreator numberCreator = NumberCreator.initGame();

        // when
        List<Integer> computerNumber = numberCreator.getComputerNumber();
        Stream<Integer> numberStream = computerNumber.stream();
        Stream<Integer> distinctComputerNumberStream = numberStream.distinct();

        // then
        assertThat(computerNumber.size()).isEqualTo(3);
        assertThat(distinctComputerNumberStream.count()).isEqualTo(3);
    }

    @Test
    void 랜덤으로_1부터_9까지수를_반환한다() {
        // given
        NumberCreator numberCreator = NumberCreator.initGame();

        // when
        List<Integer> computerNumber = numberCreator.getComputerNumber();

        // then
        assertThat(computerNumber.get(0)).isGreaterThan(0);
        assertThat(computerNumber.get(0)).isLessThan(10);
        assertThat(computerNumber.get(1)).isGreaterThan(0);
        assertThat(computerNumber.get(1)).isLessThan(10);
        assertThat(computerNumber.get(2)).isGreaterThan(0);
        assertThat(computerNumber.get(2)).isLessThan(10);
    }

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