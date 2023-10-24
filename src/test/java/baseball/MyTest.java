package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Config.DiContainer;
import baseball.ProcessGame.BaseBallGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class MyTest extends NsTest {
    /**
     * @Description: 유저가 입력 하는 값에 대한 예외 테스트
     */
    @Test
    void 예외_테스트_중복된_정수가_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_범위보다_큰_정수가_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_범위보다_작은_정수가_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("98"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_실수가_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자가_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    /**
     * @Description: 야구 게임에 대한 테스트 코드(정상 시나리오)
     */
    BaseBallGame baseBallGame = DiContainer.getBaseBallGame();

    @Test
    void 랜덤_수_생성_테스트() {
        assertThat(baseBallGame.makeRandomNumber()).isNotNull();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
