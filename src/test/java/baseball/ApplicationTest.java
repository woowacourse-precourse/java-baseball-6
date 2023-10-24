package baseball;

import baseball.model.GameStatus;
import baseball.model.PlayerInputManager;
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
    void 숫자범위_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("104"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    void 숫자중복_예외테스트() {
        // given

        // when

        // then


    }

    @Test
    void 게임_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("123", "456", "789", "2");
            assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        },
                7, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
