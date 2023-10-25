package baseball.domain.baseballplayer.team;

import baseball.domain.baseballplayer.dto.Ball;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest extends NsTest {

    private Ball ball;

    @Test
    void 컴퓨터_랜덤_번호_생성_성공_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(ball.numbers()).isEqualTo(List.of(1, 3, 5));
                },
                1, 3, 5
        );
    }

    @Override
    protected void runMain() {
        Computer computer = Computer.newInstance();
        computer.createNewBall();
        ball = computer.getBall();
    }
}