package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @Nested
    class PlayerTest {

        @Test
        void 숫자_이외의_값을_입력하면_IllegalArgumentException을_던진다() {
            assertThatThrownBy(() -> new Player().guessNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 길이가_3이_넘어가면_IllegalArgumentException을_던진다() {
            assertThatThrownBy(() -> new Player().guessNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 중복된_숫자가_존재하면_IllegalArgumentException을_던진다() {
            assertThatThrownBy(() -> new Player().guessNumber("112"))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
