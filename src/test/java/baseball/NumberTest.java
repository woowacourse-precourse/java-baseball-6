package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class NumberTest {
    Number number = new Number();

    @Test
    void boolean_세자리수_이상_입력_받았을_경우_false_반환()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isThreeDigits", String.class);
        method.setAccessible(true);

        String input = "1342";
        boolean expected = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void boolean_입력받은_숫자가_숫자가_아닌_경우_false_반환()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isNumber", String.class);
        method.setAccessible(true);

        String input = "13ㄱ2";
        boolean expected = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void boolean_중복된_숫자를_입력받은_경우_false_반환()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isNotDuplicate", String.class);
        method.setAccessible(true);

        String input = "133";
        boolean expected = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void boolean_유효하지_않는_숫자를_입력받은_경우_오류_발생()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isValidString", String.class);
        method.setAccessible(true);

        String notNumber = "12ㄱ";
        String notThreeDigitsNumber = "12345";
        String duplicateNumber = "122";

        boolean expected = false;

        boolean result = (boolean) method.invoke(number, notNumber);
        assertThat(result).isEqualTo(expected);

        result = (boolean) method.invoke(number, notThreeDigitsNumber);
        assertThat(result).isEqualTo(expected);

        result = (boolean) method.invoke(number, duplicateNumber);
        assertThat(result).isEqualTo(expected);
    }


}
