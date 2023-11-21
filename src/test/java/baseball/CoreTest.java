package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Baseball;
import org.junit.jupiter.api.Test;

public class CoreTest {

    Baseball baseball;

    @Test
    void 스트라이크3_계산_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    baseball = new Baseball();
                    assertThat(baseball.getResult(123)).contains("3스트라이크");
                },
                1, 2, 3
        );
    }

    @Test
    void 낫싱_계산_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    baseball = new Baseball();
                    assertThat(baseball.getResult(456)).contains("낫싱");
                },
                1, 2, 3
        );
    }

    @Test
    void 볼2_스트라이크1_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    baseball = new Baseball();
                    assertThat(baseball.getResult(132)).contains("2볼 1스트라이크");
                },
                1, 2, 3
        );
    }

}
