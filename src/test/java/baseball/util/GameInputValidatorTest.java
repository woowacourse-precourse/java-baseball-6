package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameInputValidatorTest {
    private GameInputValidator gameInputValidator;

    @BeforeEach
    public void setUp() {
        gameInputValidator = new GameInputValidator();
    }

    @Test
    @DisplayName("inputNum이 서로 다른 숫자가 아닌 경우")
    void 서로_다른_수가_아닌_경우() throws Exception {
        //given
        String inputNum = "122";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameInputValidator.validate(inputNum))
                .withMessage(ErrorMessage.SAME_INPUT_NUM.getErrorMessage());
    }

    @Test
    @DisplayName("두자리가 입력된 경우")
    void 두자리_수가_입력된_경우() throws Exception {
        //given
        String inputNum = "12";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameInputValidator.validate(inputNum))
                .withMessage(ErrorMessage.INVALID_GAME_INPUT_NUM.getErrorMessage());
    }

    @Test
    @DisplayName("네자리가 입력된 경우")
    void 네자리_수가_입력된_경우() throws Exception {
        //given
        String inputNum = "1234";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameInputValidator.validate(inputNum))
                .withMessage(ErrorMessage.INVALID_GAME_INPUT_NUM.getErrorMessage());
    }

    @Test
    @DisplayName("inputNum이 정상 값인 경우")
    void 정상값이_입력된_경우() throws Exception {
        //given
        String inputNum = "123";
        //when
        //then
        assertThatNoException()
                .isThrownBy(() -> gameInputValidator.validate(inputNum));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 들어온 경우")
    void 문자가_입력된_경우() throws Exception {
        //given
        String inputNum = "abc";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameInputValidator.validate(inputNum))
                .withMessage(ErrorMessage.INVALID_GAME_INPUT_NUM.getErrorMessage());
    }
}