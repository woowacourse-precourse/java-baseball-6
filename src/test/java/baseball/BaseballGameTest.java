package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest extends NsTest {

    @Test
    @DisplayName("같은 정답을 유지하며 정답을 맞힐 때까지 입력받는다")
    void repeatUntilCorrectAnswer() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("789", "456", "425");

                    assertThat(output())
                            .contains("낫싱", "1볼 1스트라이크")
                            .endsWith(
                                    "3스트라이크"
                                            + System.lineSeparator()
                                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
                            );
                },
                4, 2, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
