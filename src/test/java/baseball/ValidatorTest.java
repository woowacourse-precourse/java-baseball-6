package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    Validator baseballNumberValidator = new BaseballNumberValidator();
    Validator gameTerminateValidator = new GameTerminationValidator();


    @Test
    void baseballNumberValidatorTestWithRightInput() {
        baseballNumberValidator.validate("123");
    }

    @Test
    @DisplayName("숫자를 더 입력한 테스트")
    void baseballNumberValidatorTestWithWrongInput() {
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("1234"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("숫자를 적게 입력한 테스트")
    void baseballNumberValidatorTestWithWrongInput2() {
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("12"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자와 다른 문자를 섞어서 입력한 테스트")
    void baseballNumberValidatorTestWithWrongInput3() {
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("12a"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백을 입력한 테스트")
    void baseballNumberValidatorTestWithWrongInput4() {
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("아무것도 입력하지 않은 테스트")
    void baseballNumberValidatorTestWithWrongInput5() {
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 이외의 문자만 입력한 테스트")
    void baseballNumberValidatorTestWithWrongInput6() {
        Assertions.assertThatThrownBy(() -> baseballNumberValidator.validate("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void gameTerminateValidatorTestWithRightInput() {
        gameTerminateValidator.validate("1");
        gameTerminateValidator.validate("2");
    }

    @Test
    @DisplayName("숫자를 2개 입력한 테스트")
    void gameTerminateValidatorTestWithWrongInput() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("12"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자를 2개 입력한 테스트2")
    void gameTerminateValidatorTestWithWrongInput2() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("21"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 이외의 문자를 입력한 테스트")
    void gameTerminateValidatorTestWithWrongInput3() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("a"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 이외의 문자를 여러개 입력한 테스트")
    void gameTerminateValidatorTestWithWrongInput4() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("ab"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백을 입력한 테스트")
    void gameTerminateValidatorTestWithWrongInput5() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("아무것도 입력하지 않는 테스트")
    void gameTerminateValidatorTestWithWrongInput6() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1,2를 제외한 나머지 숫자를 입력한 테스트")
    void gameTerminateValidatorTestWithWrongInput7() {
        Assertions.assertThatThrownBy(() -> gameTerminateValidator.validate("3"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
