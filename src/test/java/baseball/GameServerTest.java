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
                    String output = output();
                    assertThat(output).contains("시작", "숫자를 입력", "낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "새로 시작하려면 1, 종료하려면 2를");
                    assertThat(output).hasLineCount(5);
                },
                1, 3, 5
        );
    }

    @Test
    void 클리어_후_계속해서_재시작할_수_있는가() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "264", "246", "1", "573", "357", "2");
                    String output = output();
                    assertThat(output).contains("시작", "숫자를 입력", "낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "새로 시작하려면 1, 종료하려면 2를", "2볼 1스트라이크", "3볼");
                    assertThat(output).hasLineCount(13);
                },
                1, 3, 5, 2, 4, 6, 3, 5, 7
        );
    }

    @Test
    void 사용자가_입력한_세자리수에_0이_포함될경우_IllegalArgumentException_예외를_터트린다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력값이_세자리가_아닐경우_IllegalArgumentException_예외를_터트린다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력값이_숫자가_아닐경우_IllegalArgumentException_예외를_터트린다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력값에_공백이_들어갈경우_IllegalArgumentException_예외를_터트린다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력값에_중복되는_숫자가_있을경우_IllegalArgumentException_예외를_터트린다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작과_종료를_선택할때_1_혹은_2가_아닌_수를_입력하면_IllegalArgumentException_예외를_터트린다() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}