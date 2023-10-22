package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest extends NsTest {
//    @Test
//    void 사용자_입력_리스트_정상_변환_테스트() {
//        Player player = new Player();
//        String input = "123";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        List<Integer> playerNum = player.enter();
//        System.out.println(playerNum);
//
//        List<Integer> expected = List.of(1,2,3);
//        assertThat(expected).isEqualTo(playerNum);
//    }

    @Test
    void 사용자_중복된_숫자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_범위_벗어난_숫자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
