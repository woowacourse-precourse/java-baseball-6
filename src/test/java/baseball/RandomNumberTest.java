package baseball;


import static org.assertj.core.api.Assertions.*;

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
}
