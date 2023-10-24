package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 숫자야구_리스트_중복숫자_예외처리() {
        Assertions.assertThatThrownBy(() -> {
            Validator.validatedBaseballNumber(List.of(1, 2, 2));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자야구_리스트_범위_벗어난_숫자_예외처리() {
        Assertions.assertThatThrownBy(() -> {
            Validator.validatedBaseballNumber(List.of(0, 2, 3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자야구_리스트_3자리_아닌수_예외처리_1() {
        Assertions.assertThatThrownBy(() -> {
            Validator.validatedBaseballNumber(List.of(1, 2, 3, 4));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자야구_리스트_3자리_아닌수_예외처리_2() {
        Assertions.assertThatThrownBy(() -> {
            Validator.validatedBaseballNumber(List.of(1, 2));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
