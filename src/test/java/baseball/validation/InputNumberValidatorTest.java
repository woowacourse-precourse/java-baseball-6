package baseball.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InputNumberValidatorTest {

    @Test
    void 전체검증_메서드2() {
        String uncorrectExampleBySize = "1234";
        String uncorrectExampleByType = "안1";
        String uncorrectExampleByDuplicate = "112";

        assertThrows(IllegalArgumentException.class,
                () -> InputNumberValidator.validateInputNumber(uncorrectExampleBySize));
        assertThrows(IllegalArgumentException.class,
                () -> InputNumberValidator.validateInputNumber(uncorrectExampleByType));
        assertThrows(IllegalArgumentException.class,
                () -> InputNumberValidator.validateInputNumber(uncorrectExampleByDuplicate));
    }

    @Test
    void 숫자가_1이나_2가_아니면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validateGameStateInput("3"));
    }

//    @Test
//    void 숫자가_세자리가_아니면_예외발생() {
//        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validateInputSize("1234"));
//    }
//
//    @Test
//    void 숫자가_아니면_예외발생() {
//        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validateInputType("1과3"));
//    }
//
//    @Test
//    void 숫자가_중복이면_예외발생() {
//        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validateInputDuplication("22"));
//    }

}