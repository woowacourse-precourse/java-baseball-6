package baseball.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReGameTest extends NsTest {
    private GameController gameController = GameController.StartBaseballGame();

    @Test
    @DisplayName("게임 2회 렌덤 테스트 : nothing ,  3 strike, 1 ball 1 strike, 3 strike")
    public void ReGameRandomNumberTest() {
        String[] userInput = {"465", "123","1","682","762","2"};
        String[] targetOutput = {"숫자를 입력해주세요 :", "낫싱", "3스트라이크","게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.","1볼 1스트라이크","3개의 숫자를 모두 맞히셨습니다!", "게임 종료"};
        assertRandomNumberInRangeTest(
                () -> {
                    run(userInput);
                    assertThat(output()).contains(targetOutput);
                },
                1, 2, 3,7,6,2
        );
    }

    @Override
    protected void runMain() {
        gameController.startGame();
    }
}
