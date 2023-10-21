package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberCreatorTest {

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
}