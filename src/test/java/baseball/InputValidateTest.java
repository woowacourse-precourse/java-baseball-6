package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest  {

    private InputValidate inputValidate;

    @Test
    @DisplayName("3글자 미만 또는 초과 입력 시, 예외처리 ")
    void 입력_글자수_예외처리()  {
        inputValidate = new InputValidate("abcd");
        assertThatThrownBy(()->inputValidate.validateSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자를 입력한 경우 , 예외처리 ")
    void 입력_숫자인지_검증_예외처리(){
        inputValidate = new InputValidate("woa");
        assertThatThrownBy(()->inputValidate.validateNumber()).isInstanceOf(IllegalArgumentException.class);
    }



}