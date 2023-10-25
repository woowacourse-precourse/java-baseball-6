package baseball;

import baseball.validator.NumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    NumberValidator numberValidator = new NumberValidator();

    @Test
    void 숫자입력_세자리_미만_입력시_예외_발생() {
        String input = "14";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberValidator.validateInputNumber(input, input.length() + 1);
        });
    }

    @Test
    void 숫자입력_중복_숫자_입력시_예외_발생() {
        String input = "121";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberValidator.validateInputNumber(input, input.length());
        });
    }

    @Test
    void 숫자입력_정수가_아닌_입력_예외_발생_알파벳() {
        String inputAlpha = "Aab";
        String inputSpecialCharacter = "%12";
        String inputBlank = " 23";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberValidator.validateInputNumber(inputAlpha, inputAlpha.length());
            numberValidator.validateInputNumber(inputSpecialCharacter, inputSpecialCharacter.length());
            numberValidator.validateInputNumber(inputBlank, inputBlank.length());
        });
    }

    @Test
    void 메뉴입력_메뉴_범위를_벗어난_입력_예외_발생(){
        String overInput = "1000";
        String underInput = "-1";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberValidator.validateMenu(overInput);
            numberValidator.validateMenu(underInput);
        });
    }

}
