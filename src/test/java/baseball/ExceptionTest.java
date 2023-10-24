package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {

    @Test
    void 사용자가_숫자가_아닌_값을_입력() {
        String[] testValues = {"1(3", "1.5352", "안녕", "!@#", " ", "2   6"};

        for (String testValue : testValues) {
            assertThatThrownBy(() -> runException(testValue))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 사용자의_숫자가_세자리수가_아님() {
        String[] testValues = {"12", "3452675", "0"};

        for (String testValue : testValues) {
            assertThatThrownBy(() -> runException(testValue))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 사용자의_숫자가_중복됨() {
        String[] testValues = {"122", "333", "000"};

        for (String testValue : testValues) {
            assertThatThrownBy(() -> runException(testValue))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
