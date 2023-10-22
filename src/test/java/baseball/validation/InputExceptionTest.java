package baseball.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputExceptionTest {
    @Test
    void 자리수_오류_테스트() {
        CheckGameNumbers checking = new CheckGameNumbers();
        String input1 = "1234";
        String input2 = "12";

        assertThatThrownBy(() -> checking.checkValidationOfNums(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> checking.checkValidationOfNums(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위_오류_테스트() {
        CheckGameNumbers checking = new CheckGameNumbers();
        String input1 = "014";
        String input2 = "*34";

        assertThatThrownBy(() -> checking.checkValidationOfNums(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> checking.checkValidationOfNums(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 서로다른_숫자_확인_테스트() {
        CheckGameNumbers checking = new CheckGameNumbers();
        String input1 = "114";
        String input2 = "344";

        assertThatThrownBy(() -> checking.checkValidationOfNums(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> checking.checkValidationOfNums(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 종료_및_재시작_입력_테스트() {
        CheckExitInput checking = new CheckExitInput();
        String[] input = {"11", "-1", "0"};

        for (String e : input) {
            assertThatThrownBy(() -> checking.checkValidationOfExit(e))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
