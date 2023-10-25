package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.enums.Constant;
import baseball.enums.Message;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidateTest {

    private InputValidate inputValidate;

    @BeforeEach
    void setUp() {
        inputValidate = new InputValidate();
    }

    @Test
    void 입력_검증_테스트() throws Exception {
        //given
        String validInput = "123";
        String inValidInput = "1a3";

        //when and then
        inputValidate.validateNumeric(validInput);
        assertThatThrownBy(() -> inputValidate.validateNumeric(inValidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.NON_NUMERIC_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 입력_숫자_길이_테스트() throws Exception {
        //given
        String validInput = "123";
        String inValidInput = "1234";

        //when and then
        inputValidate.validateLength(validInput);
        assertThatThrownBy(() -> inputValidate.validateLength(inValidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.LENGTH_ERROR_MESSAGE.getMessage() + Constant.MAX_NUMBER_LENGTH.getConstant());
    }

    @Test
    void 입력_숫자_중복_테스트() throws Exception {
        //given
        String validInput = "123";
        String inValidInput = "122";

        //when and then
        inputValidate.validateDuplicateNumber(validInput);
        assertThatThrownBy(() -> inputValidate.validateDuplicateNumber(inValidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.DUPLICATE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 입력_커맨드_테스트() throws Exception {
        //given
        List<String> validInputs = List.of("1", "2");
        List<String> inValidInputs = List.of("12", "3");

        //when and then
        validInputs.stream()
                .forEach(inputValidate::validateGameCommand);
        assertThatThrownBy(() -> inValidInputs.stream()
                .forEach(inputValidate::validateGameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.GAME_COMMAND_ERROR_MESSAGE.getMessage());
    }
}