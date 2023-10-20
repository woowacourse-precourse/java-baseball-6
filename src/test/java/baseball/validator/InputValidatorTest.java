package baseball.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();




    @DisplayName("입력이 특정 길이이면 true 를 반환한다.")
    @Test
    void isEqualLengthLimit() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "123";
        int limit = 3;
        Method method = InputValidator.class.getDeclaredMethod("isEqualLengthLimit", String.class, int.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(inputValidator, input, limit);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("입력이 특정 길이가 아니라면 false 를 반환한다.")
    @Test
    void isEqualLengthLimitWithReturnFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "123";
        int limit = 4;
        Method method = InputValidator.class.getDeclaredMethod("isEqualLengthLimit", String.class, int.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(inputValidator, input, limit);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("입력이 숫자만 포함하고 있다면 true 를 반환한다.")
    @Test
    void isContainOnlyDigit() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "123";
        int limit = 4;
        Method method = InputValidator.class.getDeclaredMethod("isContainOnlyDigit", String.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(inputValidator, input);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("입력이 숫자가 아닌 문자를 포함한다면 false 를 return 한다.")
    @Test
    void isContainOnlyDigitWithNonDigit() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "12g";
        Method method = InputValidator.class.getDeclaredMethod("isContainOnlyDigit", String.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(inputValidator, input);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("입력이 숫자만 포함되어 있지만 0 이 포함된 경우 false 를 return 한다.")
    @Test
    void isContainOnlyDigitWithZero() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "120";
        Method method = InputValidator.class.getDeclaredMethod("isContainOnlyDigit", String.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(inputValidator, input);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("입력의 길이가 특정 길이이면서 숫자만 포함되면 아무일도 일어나지 않는다.")
    @Test
    void validateInput(){
        //given
        String input = "123";
        int limit = 3;

        //when
        inputValidator.validateInput(input,limit);

        //then
    }

    @DisplayName("입력의 길이가 특정 길이가 아닌 경우 예외가 발생한다.")
    @Test
    void validateInputWithDiffLength(){
        //given
        String input = "123g";
        int limit = 3;

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateInput(input,limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값의 길이는 "+limit+"이어야 합니다.");
    }

    @DisplayName("입력에 문자가 포함된 경우 예외가 발생한다.")
    @Test
    void validateInputWithNonDigit(){
        //given
        String input = "12g";
        int limit = 3;

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateInput(input,limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1~9 사이의 값이어야 합니다.");
    }

    @DisplayName("입력에 숫자만 입력되지만 0 이 포함되는 경우 예외가 발생한다.")
    @Test
    void validateInputWithZero(){
        //given
        String input = "120";
        int limit = 3;

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateInput(input,limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1~9 사이의 값이어야 합니다.");
    }

    @DisplayName("종료 시 입력되는 입력 값이 1이거나 2이면 아무일도 일어나지 않는다.")
    @Test
    void validateExitInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input1 = "1";
        String input2 = "2";

        //when
        Method method = InputValidator.class.getDeclaredMethod("validateExitInput", String.class);
        method.setAccessible(true);

        method.invoke(inputValidator, input1);
        method.invoke(inputValidator, input2);

        //then
    }

    @DisplayName("종료 시 입력되는 입력 값이 1이거나 2가 아닌 경우 예외가 발생한다.")
    @Test
    void validateExitInputWithInputNOT1OR2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "3";

        //when
        Method method = InputValidator.class.getDeclaredMethod("validateExitInput", String.class);
        method.setAccessible(true);

        //then
        assertThatThrownBy(() -> method.invoke(inputValidator, input))
                .getCause()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1또는 2어야 합니다.");
    }

    @DisplayName("종료 시 입력되는 입력 값이 길이가 1이고 1또는 2인 경우 아무이도 발생하지 않는다.")
    @Test
    void validateExitInputWithLimit(){
        //given
        String input1 = "1";
        String input2 = "2";
        int limit = 1;

        //when
        inputValidator.validateInput(input1,limit);
        inputValidator.validateInput(input2,limit);

        //then
    }

    @DisplayName("종료 시 입력되는 입력 값이 길이가 1이 아닌 경우 예외가 발생한다.")
    @Test
    void validateExitInputWithLimitLengthDiffLimit(){
        //given
        String input = "12";
        int limit = 1;

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateInput(input,limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값의 길이는 "+limit+"이어야 합니다.");
    }

    @DisplayName("종료 시 입력되는 입력 값이 1~9 사이의 값이 아닌 경우 예외가 발생한다.")
    @Test
    void validateExitInputWithLimitIsNonDigit(){
        //given
        String input1 = "0";
        String input2 = " ";
        String input3 = "a";
        int limit = 1;

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateInput(input1,limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1~9 사이의 값이어야 합니다.");
        assertThatThrownBy(() -> inputValidator.validateInput(input2,limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1~9 사이의 값이어야 합니다.");
        assertThatThrownBy(() -> inputValidator.validateInput(input3,limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1~9 사이의 값이어야 합니다.");
    }


    @DisplayName("입력에 중복된 값이 없는 경우 아무일도 일어나지 않는다.")
    @Test
    void validateInputDuplicate(){
        //given
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        //when
        inputValidator.validateInputDuplicate(input);

        //then
    }

    @DisplayName("입력에 중복된 값이 있는 경우 예외가 발생한다.")
    @Test
    void validateInputDuplicateWithDuplicateValue(){
        //given
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(3);

        //when

        //then
        assertThatThrownBy(()-> inputValidator.validateInputDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 서로 다른 1~9 사이의 값이어야 합니다.");
    }

}