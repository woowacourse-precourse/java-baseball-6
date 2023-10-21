package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.Player;
import org.junit.jupiter.api.Test;

public class PlayerNumberTest {

    @Test
    void 플레이어_입력값_자리수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Player player = new Player("1234");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 플레이어_입력값_자연수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Player player = new Player("1.3");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 플레이어_입력값_중복값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Player player = new Player("122");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 플레이어_입력값_범위_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Player player = new Player("012");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
