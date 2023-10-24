package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class SetNumberTest {

    SetNumber number = new SetNumber();

    @Test
    void boolean_세자리수_이상_입력_받은_경우()
        throws IllegalAccessException, NoSuchMethodException, InvocationTargetException{

        Method method = SetNumber.class.getDeclaredMethod("isThreeDigits", String.class);
        method.setAccessible(true);

        String input = "4171";
        boolean expected = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expected);

    }

}
