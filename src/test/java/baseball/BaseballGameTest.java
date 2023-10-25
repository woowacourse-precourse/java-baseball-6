package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class BaseballGameTest extends NsTest {

    private final BaseballGame baseballGame = new BaseballGame();

    @Test
    void 정답을_맞춘후_종료한다() {
        // given
        assertRandomNumberInRangeTest(
            () -> {
                run("245", "126", "435", "2");
                assertThat(output()).contains("1볼 1스트라이크", "낫싱", "3스트라이크", "게임 종료");
            },
            4, 3, 5
        );
    }

    @Test
    void 정답을_맞춘후_한번_더_재시작한다() {
        assertRandomNumberInRangeTest(
            () -> {
                run("245", "435", "1", "132", "123", "2");
                assertThat(output()).contains("1볼 1스트라이크", "3스트라이크", "게임 종료", "2볼 1스트라이크", "3스트라이크",
                    "게임 종료");
            },
            4, 3, 5, 1, 2, 3
        );
    }

    @Override
    protected void runMain() {
        baseballGame.start();
    }
    
}