package study;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CampRandomTest {
    @Test
    void pickNumberInRange_값이_반대일_경우_예외_발생() {
        assertThatThrownBy(() -> Randoms.pickNumberInRange(100, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void pickNumberInRange_Integer_범위_초과할_경우_예외_발생() {
        assertThatThrownBy(() -> Randoms.pickNumberInRange(1, Integer.MAX_VALUE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void pickNumberInRange_정상_동작() {
        assertThatNoException().isThrownBy(() -> Randoms.pickNumberInRange(1, 100));
    }
}
