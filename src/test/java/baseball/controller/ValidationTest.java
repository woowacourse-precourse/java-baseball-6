package baseball.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import baseball.Validation;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    public void 입력_내용_숫자만_허용_공백() {
        String input1 = "12 ";
        String input2 = "1 2";
        String input3 = " 12";
        String input4 = "1 2 3";

        assertThatThrownBy(() -> Validation.validationGameNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.validationGameNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.validationGameNumber(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.validationGameNumber(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력_내용_숫자만_허용_영어() {
        String input1 = "12a";
        String input2 = "A12";

        assertThatThrownBy(() -> Validation.validationGameNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.validationGameNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력_내용_숫자만_허용_특수문자() {
        String input1 = "12#";
        String input2 = "*12";

        assertThatThrownBy(() -> Validation.validationGameNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.validationGameNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력_숫자_중복_안됨() {
        String input1 = "112";
        String input2 = "777";

        assertThatThrownBy(() -> Validation.validationGameNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.validationGameNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력_숫자_정해진_자릿수() {
        String input1 = "1234";
        String input2 = "12";

        assertThatThrownBy(() -> Validation.validationGameNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.validationGameNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 게임종료_입력_정해진_숫자() {
        String input1 = "3";

        assertThatThrownBy(() -> Validation.validationGameNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}