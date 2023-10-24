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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
