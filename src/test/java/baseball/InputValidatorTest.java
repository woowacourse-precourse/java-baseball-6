package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.util.InputValidator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void validateBalls는_숫자가_아닌_입력의_경우_예외를_반환한다_() {
        assertThatThrownBy(() -> InputValidator.validateBalls("1ab"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateBalls는_숫자_입력의_경우_예외를_반환하지않는다_() {
        assertDoesNotThrow(() -> InputValidator.validateBalls("123"));
    }
    @Test
    void validateBallsCount는_리스트의_길이가_3이_아니면_예외를_반환한다() {
        List<Integer> list = List.of(1,2,3,4);
        assertThatThrownBy(() -> InputValidator.validateBallsCount(list))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateBallsCount는_리스트의_길이가_3이면_예외를_반환하지않는다() {
        List<Integer> list = List.of(1,2,3);
        assertDoesNotThrow(() -> InputValidator.validateBallsCount(list));
    }
}
