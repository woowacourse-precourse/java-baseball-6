package baseball;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
    @Test
    @DisplayName("각 자리 숫자는 1부터 9까지의 정수이다.")
    void test1() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        assertThat(randomNumber).isBetween(1, 9);
    }

    @Test
    @DisplayName("랜덤 숫자는 3자리 난수이다.")
    void test2() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }

        assertThat(randomNumbers.size()).isEqualTo(3);
    }
}
