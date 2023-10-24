package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import javax.management.InvalidApplicationException;
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
    void 예외_테스트_수_많음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_수_적음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 메뉴_비정상_입력() {
        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "0");
                    },
                    1, 2, 3
            );
        }, "1보다 작음")
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "3");
                    },
                    1, 2, 3
            );
        }, "2보다 큼")
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
