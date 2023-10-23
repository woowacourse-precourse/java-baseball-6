package baseball;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 유효한_재시작_옵션_테스트() {
        Player player = new Player();
        String validOption = "1";

        int result = player.receiveRetryOption(validOption);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 유효하지_않은_재시작_옵션_예외_테스트() {
        Player player = new Player();
        String invalidOption = "3";

        assertThatThrownBy(() -> player.receiveRetryOption(invalidOption))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
