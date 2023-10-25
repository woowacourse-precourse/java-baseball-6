package baseball.domain.baseballplayer.referee;

import baseball.config.BaseBallGameConfigFactory;
import baseball.domain.baseballplayer.referee.Referee;
import baseball.domain.baseballplayer.team.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest extends NsTest {

    private Referee referee;

    @Test
    void 낫싱_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5, 2, 4, 6
        );
    }

    @Test
    void 원_볼_원_스트라이크_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("1볼 1스트라이크");
                },
                1, 3, 5, 1, 5, 9
        );
    }

    @Test
    void 투_볼_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("2볼");
                },
                1, 3, 5, 3, 5, 9
        );
    }

    @Test
    void 쓰리_스트라이크_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("3스트라이크");
                },
                1, 3, 5, 1, 3, 5
        );
    }

    @Test
    void 라운드_종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("3스트라이크");
                    assertThat(referee.isRoundOver()).isTrue();
                },
                1, 3, 5, 1, 3, 5
        );
    }

    @Test
    void 라운드_미종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("2볼 1스트라이크");
                    assertThat(referee.isRoundOver()).isFalse();
                },
                1, 3, 5, 3, 1, 5
        );
    }

    @Override
    protected void runMain() {
        Computer defenseTeam = Computer.newInstance();
        Computer offenseTeam = Computer.newInstance();
        defenseTeam.createNewBall();
        offenseTeam.createNewBall();
        this.referee = Referee.newInstance(Rule.newInstance());
        referee.printResult(defenseTeam, offenseTeam);
    }

}