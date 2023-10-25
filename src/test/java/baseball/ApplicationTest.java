package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 입력받은_수가_2자리_수라면() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_수가_숫자가_아니라면() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_수중에_중복되는_수가_있다면() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_값이_입력된다면() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    void 게임종료시_제시된_값이_아닌_값을_입력한다면(){
//        BaseBallGameEnd baseBallGameEnd = new BaseBallGameEnd();
//        when(Console.readLine()).thenReturn("12321");
//        assertThrows(IllegalArgumentException.class, () -> baseBallGameEnd.orderCheck());
//    }
//
//    @Test
//    void 게임종료시_게임_종료를_위해_2를_입력_한다면(){
//        BaseBallGameEnd baseBallGameEnd = new BaseBallGameEnd();
//        assertThat(baseBallGameEnd.orderCheck()).isFalse();
//    }

}


