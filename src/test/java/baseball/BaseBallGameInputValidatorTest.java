package baseball;

import baseball.constans.ErrorMessage;
import baseball.validator.UserInputValidator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseBallGameInputValidatorTest extends NsTest {

    @Test
    void 중복문자테스트() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    run("111");
                });

        Assertions.assertEquals(exception.getMessage(),
                ErrorMessage.NUMBER_DUPLICATED_EXCEPTION.getMessage());

    }

    @Test
    void 숫자범위테스트() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    run("012");
                });

        Assertions.assertEquals(exception.getMessage(),
                ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void 숫자길이테스트() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    run("1234");
                });

        Assertions.assertEquals(exception.getMessage(),
                ErrorMessage.NUMBER_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    void 재시작여부입력테스트() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    UserInputValidator.validateFinishOrRestart("3");
                });

        Assertions.assertEquals(exception.getMessage(),
                ErrorMessage.NUMBER_NOT_CORRECT_EXCEPTION.getMessage());
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
