package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 예외_테스트1() {
        assertThrows(IllegalArgumentException.class, () -> Application.checkUserNum("1234"));
    }

    @Test
    public void 예외_테스트2() {
        assertThrows(IllegalArgumentException.class, () -> Application.checkUserNum("51오"));
    }

    @Test
    public void 예외_테스트3() {
        assertThrows(IllegalArgumentException.class, () -> Application.checkUserNum("51o"));
    }

    @Test
    public void 예외_테스트4() {
        assertThrows(IllegalArgumentException.class, () -> Application.checkUserNum("664"));
    }

    @Test
    public void 예외_테스트5() {
        assertThrows(IllegalArgumentException.class, () -> Application.checkUserNum("015"));
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
