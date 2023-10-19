package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    Validator baseballNumberValidator = new BaseballNumberValidator();
    Validator gameTerminateValidator = new GameTerminationValidator();


    @Test
    void baseballNumberValidatorTestWithRightInput() {
        baseballNumberValidator.validate("123");
    }

    @Test
    void baseballNumberValidatorTestWithWrongInput() {
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("1234"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("12"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("12a"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("1"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate(""))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate(" "))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void gameTerminateValidatorTestWithRightInput() {
        gameTerminateValidator.validate("1");
        gameTerminateValidator.validate("2");
    }

    @Test
    void gameTerminateValidatorTestWithWrongInput() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("12"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("21"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("a"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("ab"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate(""))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate(" "))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("3"))
            .isInstanceOf(IllegalArgumentException.class);
    }



}
