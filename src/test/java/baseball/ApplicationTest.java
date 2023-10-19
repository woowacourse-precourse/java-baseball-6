package baseball;

import baseball.Game.BaseBallGame;
import baseball.Game.BaseBallGameImpl;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * @Description: 유저가 입력 하는 값에 대한 예외 테스트
     * */
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
     * */
    static Integer computerNumber = 123;
    static BaseBallGame baseBallGame = new BaseBallGameImpl();
    @Test
    void 스트라이크_테스트() {
        assertThat(baseBallGame.countStrike(123)).isEqualTo(3);
        assertThat(baseBallGame.countStrike(124)).isEqualTo(2);
        assertThat(baseBallGame.countStrike(134)).isEqualTo(1);
        assertThat(baseBallGame.countStrike(234)).isZero();
    }

    @Test
    void 볼_테스트() {
        assertThat(baseBallGame.countBall(123)).isZero();
        assertThat(baseBallGame.countBall(124)).isZero();
        assertThat(baseBallGame.countBall(134)).isEqualTo(1);
        assertThat(baseBallGame.countBall(234)).isEqualTo(2);
        assertThat(baseBallGame.countBall(231)).isEqualTo(3);
    }

    @Test
    void 낫싱_테스트(){
        assertThat(baseBallGame.isNothing(123)).isFalse();
        assertThat(baseBallGame.isNothing(999)).isTrue();
    }

    @Test
    void 랜덤_수_생성_테스트(){
        assertThat(baseBallGame.makeRandomNumber()).isBetween(100, 999);
        assertThat(baseBallGame.makeRandomNumber()).isBetween(100, 999);
        assertThat(baseBallGame.makeRandomNumber()).isBetween(100, 999);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
