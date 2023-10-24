package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Computer;
import baseball.util.GameConstants;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void 중복_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤_숫자_자리수_테스트() {
        Computer computer = new Computer();
        List<Integer> nums = computer.generateRandomNums();

        assertThat(nums.size()).isEqualTo(GameConstants.DIGIT_SIZE);
    }

    @Test
    void 랜덤_숫자_중복_테스트() {
        Computer computer = new Computer();
        List<Integer> nums = computer.generateRandomNums();

        boolean hasDuplicates = nums.stream()
                .distinct()
                .count() < nums.size();

        assertThat(hasDuplicates).isEqualTo(false);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
