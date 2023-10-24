package baseball;

import baseball.business.NumberMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NumberMakerTest {

    @Test
    void 숫자가_3자리인지_확인() {
        NumberMaker numberMaker = new NumberMaker();
        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();

        Assertions.assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    void 숫자가_중복되지_않는지_확인() {
        NumberMaker numberMaker = new NumberMaker();
        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();

        // 중복을 제거하는 set에 넣은 후에도 크기가 동일한지 확인합니다.
        Set setNumbers = new HashSet<>(randomNumbers);
        Assertions.assertThat(setNumbers.size()).isEqualTo(3);
    }
}