package baseball.integration;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class IntegrationTest extends NsTest {

    @Test
    void 두자리_수가_주어지면_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 네자리_수가_주어지면_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_수가_있다면_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력이_음수라면_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 입력이_숫자가_아니라면_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}