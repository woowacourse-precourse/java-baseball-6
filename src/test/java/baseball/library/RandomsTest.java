package baseball.library;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomsTest {
    @DisplayName("pickNumberInRange 함수는 특정 범위에서 랜덤한 숫자를 뽑는다")
    @Test
    void pickRandomNumberInRange() {
        // given
        int startInclusive = 0;
        int endInclusive = 9;

        // when
        int number = Randoms.pickNumberInRange(startInclusive, endInclusive);

        // then
        assertThat(number).isBetween(startInclusive, endInclusive);
    }
}
