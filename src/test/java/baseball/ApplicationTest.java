package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    class GameServiceTest {

        @Test
        void strike를_올바르게_리턴한다() {
            GameService gameService = new GameService();
            gameService.computeStrike(List.of(1, 2, 3), List.of(1, 2, 3));
            assertThat(gameService.getStrike()).isEqualTo(3);

            gameService.computeStrike(List.of(1, 2, 3), List.of(1, 2, 4));
            assertThat(gameService.getStrike()).isEqualTo(2);

            gameService.computeStrike(List.of(1, 2, 3), List.of(1, 4, 5));
            assertThat(gameService.getStrike()).isEqualTo(1);
        }

        @Test
        void ball을_올바르게_리턴한다() {
            GameService gameService = new GameService();
            gameService.computeBall(List.of(1, 2, 3), List.of(1, 2, 3));
            assertThat(gameService.getBall()).isEqualTo(0);

            gameService.computeBall(List.of(1, 2, 3), List.of(1, 3, 4));
            assertThat(gameService.getBall()).isEqualTo(1);

            gameService.computeBall(List.of(1, 2, 3), List.of(4, 1, 2));
            assertThat(gameService.getBall()).isEqualTo(2);
        }
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
