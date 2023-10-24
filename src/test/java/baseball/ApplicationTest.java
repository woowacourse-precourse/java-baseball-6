package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.controller.ComputerController;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 컴퓨터가_생성하는_숫자가_올바른지_테스트() {
        List<Integer> generatedNumbers = ComputerController.getBaseballNumber();

        // 숫자가 정확히 3개인지 확인
        assertThat(generatedNumbers).hasSize(3);

        // 모든 숫자가 1~9 범위 안에 있는지 확인
        for (int num : generatedNumbers) {
            assertThat(num).isBetween(1, 9);
        }

        // 중복된 숫자가 없는지 확인
        int distinctCount = new HashSet<>(generatedNumbers).size();
        assertThat(distinctCount).isEqualTo(3);
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
