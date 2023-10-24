package baseball;

import baseball.Controller.GameController;
import baseball.Model.ComputerNum;
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
    void ComputerNumCreate(){
        ComputerNum computerNumber = new ComputerNum();
        assertThat(computerNumber.getComputerNum().length()).isEqualTo(3);
    }

    @Test
    void GameHintTest() {
        GameController gameController = new GameController();
        gameController.GameSet("471");

        gameController.getHint();
    }

    @Test
    void 입력숫자_길이_예외테스트() {
        GameController gameController = new GameController();
        gameController.GameSet("4713");
    }

    @Test
    void 문자입력_예외테스트() {
        GameController gameController = new GameController();
        gameController.GameSet("a15");
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
