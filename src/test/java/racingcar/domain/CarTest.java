package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 랜덤_값을_받은_이후_해당_값이_4이상인_값인지_확인한다() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        assertTrue(randomValue >= 0 && randomValue <= 9);
    }

    @Test
    void forward값이_임시값_4일경우_repeat_함수로_임시값_만큼_문자열을_출력한다() {
        int tempForwardFour = 4;
        Assertions.assertThat("-".repeat(tempForwardFour)).isEqualTo("----");
    }
}
