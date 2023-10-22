package baseball.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CheckGameNumbersTest {
    @Test
    void 자리수_오류_테스트() {
        //given
        CheckGameNumbers checking = new CheckGameNumbers();
        String input1 = "1234";
        String input2 = "12";

        //when
        ThreeDigitException exception1 = assertThrows(ThreeDigitException.class, () -> {
            checking.checkValidation(input1);
        });
        ThreeDigitException exception2 = assertThrows(ThreeDigitException.class, () -> {
            checking.checkValidation(input2);
        });

        //then
        assertThat(exception1.getMessage()).isEqualTo(ConstExceptionMessages.THREE_DIGIT_EXCEPTION_MSG);
        assertThat(exception2.getMessage()).isEqualTo(ConstExceptionMessages.THREE_DIGIT_EXCEPTION_MSG);
    }

    @Test
    void 숫자_범위_오류_테스트() {
        //given
        CheckGameNumbers checking = new CheckGameNumbers();
        String input1 = "012";
        String input2 = "12-";

        //when
        NumberRangeException exception1 = assertThrows(NumberRangeException.class, () -> {
            checking.checkValidation(input1);
        });
        NumberRangeException exception2 = assertThrows(NumberRangeException.class, () -> {
            checking.checkValidation(input2);
        });

        //then
        assertThat(exception1.getMessage()).isEqualTo(ConstExceptionMessages.RANGE_EXCEPTION_MSG);
        assertThat(exception2.getMessage()).isEqualTo(ConstExceptionMessages.RANGE_EXCEPTION_MSG);
    }

    @Test
    void 서로다른_숫자_확인_테스트() {
        //given
        CheckGameNumbers checking = new CheckGameNumbers();
        String input1 = "112";
        String input2 = "433";

        //when
        DifferentEachOtherException exception1 = assertThrows(DifferentEachOtherException.class, () -> {
            checking.checkValidation(input1);
        });
        DifferentEachOtherException exception2 = assertThrows(DifferentEachOtherException.class, () -> {
            checking.checkValidation(input2);
        });

        //then
        assertThat(exception1.getMessage()).isEqualTo(ConstExceptionMessages.DIFF_EACH_OTHER_EXCEPTION_MSG);
        assertThat(exception2.getMessage()).isEqualTo(ConstExceptionMessages.DIFF_EACH_OTHER_EXCEPTION_MSG);
    }
}
