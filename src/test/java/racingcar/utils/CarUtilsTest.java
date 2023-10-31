package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CarUtilsTest {

    @Test
    public void 랜덤으로_0부터_9까지의_정수_하나를_반환한다() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        assertTrue(randomValue >= 0 && randomValue <= 9);
    }
}
