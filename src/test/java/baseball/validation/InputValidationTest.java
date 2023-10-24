package baseball.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("예측_숫자_유효_테스트")
    void validExpectedNums() {

        List<Integer> overSize = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        List<Integer> outOfRange = new ArrayList<>(Arrays.asList(1, 0, 2));
        List<Integer> duplicated = new ArrayList<>(Arrays.asList(1, 1, 2));

        Assertions.assertThatThrownBy(() -> InputValidation.validExpectedNums(overSize))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> InputValidation.validExpectedNums(outOfRange))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> InputValidation.validExpectedNums(duplicated))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시작_입력_테스트")
    void validRestartInput() {
        int input = 3;
        Assertions.assertThatThrownBy(() -> InputValidation.validRestartInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}