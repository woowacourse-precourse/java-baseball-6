package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMsg;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_같을경우_예외_처리() {

        String duplicateNumber = "pobi,pobi";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(duplicateNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMsg.ERROR_CAR_NAME_SAME.getMessage())
        );
    }

    @Test
    void 자동차_이름이_길이가_1이하일_경우_예외_처리() {

        String stringInTheElementsLength1 = "abc,a,cv";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(stringInTheElementsLength1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMsg.ERROR_CAR_NAME_MIN_LENGTH.getMessage())
        );
    }

    @Test
    void 자동차_이름_길이가_6이상일_경우_예외_처리() {

        String stringInTheElementsLengthMore6 = "pobi,pobifd,java";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(stringInTheElementsLengthMore6))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMsg.ERROR_CAR_NAME_LENGTH_MORE_THAN_6.getMessage())
        );
    }

    @Test
    void 자동차_이름이_공백이_들어가_있을경우_예외_처리() {
        String stringInTheElementsSpaceBar = " ";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(stringInTheElementsSpaceBar))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMsg.ERROR_CAR_NAME_BLANK_BAR.getMessage())
        );
    }

    @Test
    void 시도할_횟수가_0일경우_예외_처리() {
        String element = "pobi,dfe";
        String cycleNumber = "0";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(element, cycleNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMsg.ERROR_GAME_CYCLE_SAME_0.getMessage())
        );
    }

    @Test
    void 시도할_횟수가_숫자가_아닌_경우_예외_처리() {
        String element = "pobi,dfe";
        String cycleNumberIsNotKorea = "한글";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(element, cycleNumberIsNotKorea))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMsg.ERROR_INPUT_NOT_NUMBER.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
