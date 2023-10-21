package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void generateThreeDifferentDigit() {
        List<Integer> computer = BaseballNumberGenerator.generateThreeDigits();
        assertThat(computer.size()).isEqualTo(3);
        for (int digit : computer) {
            assertThat(Collections.frequency(computer, digit)).isEqualTo(1);
            assertThat(digit).isGreaterThanOrEqualTo(1);
            assertThat(digit).isLessThanOrEqualTo(9);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
