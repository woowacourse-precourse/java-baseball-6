package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    static Player player = new Player();

    @Test
    void 게임_비정상_값_입력_테스트() {
        System.setIn(new ByteArrayInputStream("-1.2+3".getBytes()));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> player.getGameInput())
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 게임_중복_값_입력_테스트() {
        System.setIn(new ByteArrayInputStream("113".getBytes()));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> player.getGameInput())
                        .isInstanceOf(IllegalArgumentException.class));
    }


    @Test
    void 게임_재시작_비정상_값_입력_테스트() {
        System.setIn(new ByteArrayInputStream("-1".getBytes()));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> player.getRestartInput())
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 값_변환_테스트() {
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        List<Integer> input = player.getGameInput();
        input.get(0).equals(1);
        input.get(1).equals(2);
        input.get(2).equals(3);
    }
}
