package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class DiscriminatorTest {

    @Test
    void 주어진_인덱스의_컴퓨터의_숫자가_예측한_숫자와_일치하는지_확인합니다() {
        // given 1
        List<Integer> computerNumber = new ArrayList<>();
        List<Integer> guessNumber = new ArrayList<>();

        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(9);

        guessNumber.add(1);
        guessNumber.add(2);
        guessNumber.add(3);

        // given 2
        Discriminator discriminator = Discriminator.create(computerNumber, guessNumber);

        // when
        boolean match1 = discriminator.match(0, 0);
        boolean match2 = discriminator.match(1, 1);
        boolean match3 = discriminator.match(2, 2);

        // then
        assertThat(match1).isTrue();
        assertThat(match2).isTrue();
        assertThat(match3).isFalse();
    }
}