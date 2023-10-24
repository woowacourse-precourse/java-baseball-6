package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest  {

    private InputValidate inputValidate;

    @Test
    @DisplayName("3글자 미만 또는 초과 입력 시, 예외처리 ")
    public void InputValidateTest()  {
        inputValidate = new InputValidate("abcd");
        assertThatThrownBy(()->inputValidate.validateSize()).isInstanceOf(IllegalArgumentException.class);
    }



}