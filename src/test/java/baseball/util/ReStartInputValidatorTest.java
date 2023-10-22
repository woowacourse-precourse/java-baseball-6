package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class ReStartInputValidatorTest {

    private ReStartInputValidator reStartInputValidator;

    @BeforeEach
    public void setUp() {
        reStartInputValidator = new ReStartInputValidator();
    }

    @Test
    @DisplayName("1, 2외에 다른 값이 들어온 경우")
    void 다른_수가_들어온_경우() throws Exception {
        //given
        String[] restartNums = {"3", "4", "5", "6", "7", "8", "9", "test", "restart", "t"};
        //when
        //then
        for (String restartNum : restartNums) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> reStartInputValidator.validate(restartNum))
                    .withMessage(ErrorMessage.INVALID_RESTART_INPUT_NUM.getErrorMessage());
        }
    }
}