package baseball.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputNumberValidatorTest {

    private InputNumberValidator inputNumberValidator = new InputNumberValidator();

    @Test
    void 전체검증_메서드2() {
        String correctExample = "316";
        String uncorrectExampleBySize = "1234";
        String uncorrectExampleByType = "안1";
        String uncorrectExampleByDuplicate = "112";

        assertTrue(inputNumberValidator.convertStrToList(correctExample) instanceof List<Integer>);

        assertThrows(IllegalArgumentException.class, () -> inputNumberValidator.validateInputNumber(uncorrectExampleBySize));
        assertThrows(IllegalArgumentException.class, () -> inputNumberValidator.validateInputNumber(uncorrectExampleByType));
        assertThrows(IllegalArgumentException.class, () -> inputNumberValidator.validateInputNumber(uncorrectExampleByDuplicate));
    }

//    @Test
//    void 전체검증_메서드1() {
//        String example = "316";
//        assertDoesNotThrow(() -> InputNumberValidator.validateInputSize(example));
//        assertDoesNotThrow(() -> InputNumberValidator.validateInputType(example));
//        assertDoesNotThrow(() -> InputNumberValidator.validateInputDuplication(example));
//
//        assertTrue(InputNumberValidator.convertStrToList(example) instanceof List<Integer>);
//    }

    @Test
    void String을_List로_변환() {
        String example = "316";
        assertTrue(inputNumberValidator.convertStrToList(example) instanceof List<Integer>);
    }

    @Test
    void 숫자가_1이나_2가_아니면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> inputNumberValidator.validateGameStateInput("3"));
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