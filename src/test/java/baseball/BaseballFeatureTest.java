package baseball;

import static baseball.global.BaseballConstant.GUESS_NUMBER_SIZE;
import static baseball.global.BaseballConstant.MAX_RANGE;
import static baseball.global.BaseballConstant.MIN_RANGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.Computer;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class BaseballFeatureTest {

    @Test
    void 랜덤하게_고른_숫자가_1에서_9까지의_서로_다른_3자리_숫자인지_확인() {
        Computer computer = new Computer();
        int count = (int) IntStream.rangeClosed(MIN_RANGE, MAX_RANGE)
                .filter(computer::numbersContains)
                .count();
        assertThat(count).isEqualTo(GUESS_NUMBER_SIZE);
    }
}
