package baseball.input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import baseball.controller.ViewController;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.exception.DuplicatedInputException;
import baseball.view.exception.NotIntegerInputException;
import baseball.view.exception.OutOfLengthInputException;
import baseball.view.exception.UsingZeroInputException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ConsoleTest extends NsTest {

    ViewController viewController = new ViewController(new InputView(), new OutputView());


    @Test
    void 사용자입력시_정수_개수오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(OutOfLengthInputException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(OutOfLengthInputException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(OutOfLengthInputException.class)
        );
    }

    @Test
    void 사용자입력시_정수_입력형식_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwe"))
                        .isInstanceOf(NotIntegerInputException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1+2"))
                        .isInstanceOf(NotIntegerInputException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(NotIntegerInputException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Q14"))
                        .isInstanceOf(NotIntegerInputException.class)
        );
    }

    @Test
    void 사용자입력시_정수_0입력_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(UsingZeroInputException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("000"))
                        .isInstanceOf(UsingZeroInputException.class)
        );
    }

    @Test
    void 사용자입력시_정수_중복_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(DuplicatedInputException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("444"))
                        .isInstanceOf(DuplicatedInputException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
