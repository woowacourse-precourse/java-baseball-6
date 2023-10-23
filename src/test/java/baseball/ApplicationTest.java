package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 중복_볼_검사() {
        BallUtils ballUtils = new BallUtils();
        List<Integer> list = ballUtils.getBalls();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0).equals(list.get(1))).isFalse();
        assertThat(list.get(0).equals(list.get(2))).isFalse();
        assertThat(list.get(2).equals(list.get(1))).isFalse();
    }

    @Test
    void 숫자_입력_테스트() {
        DisplayBoard board = new DisplayBoard();
        InputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        List<Integer> list = board.inputNumbers();
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
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
