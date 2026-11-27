package baseball.controller;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballControllerTest extends NsTest {
    @Test
    @DisplayName("정답을 맞힐 때까지 진행하고 2를 입력하면 종료한다")
    void finishWhenExitSelected() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("789", "456", "425", "2");

                    assertThat(output())
                            .contains(
                                    "낫싱",
                                    "1볼 1스트라이크",
                                    "3스트라이크",
                                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
                            );
                },
                4, 2, 5
        );
    }

    @Test
    @DisplayName("1을 입력하면 새로운 정답으로 게임을 다시 시작한다")
    void restartWithNewAnswer() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("425", "1", "789", "135", "2");

                    assertThat(output())
                            .contains("낫싱", "3스트라이크");
                },
                4, 2, 5, 1, 3, 5
        );
    }

    @Test
    @DisplayName("재시작 선택이 1 또는 2가 아니면 예외가 발생한다")
    void rejectInvalidRestartChoice() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("425", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                4, 2, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
