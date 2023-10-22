package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameServerTest extends NsTest {

    @Test
    void 클리어_후_바로_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("시작", "숫자를 입력", "낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "새로 시작하려면 1, 종료하려면 2를");
                },
                1, 3, 5
        );
    }

    @Test
    void 클리어_후_계속해서_재시작할_수_있는가() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "264", "246", "1", "573", "357", "2");
                    assertThat(output()).contains("시작", "숫자를 입력", "낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "새로 시작하려면 1, 종료하려면 2를", "2볼 1스트라이크", "3볼");
                },
                1, 3, 5, 2, 4, 6, 3, 5, 7
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}