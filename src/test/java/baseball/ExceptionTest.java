package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;
import java.io.IOException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class ExceptionTest extends NsTest {

    @Test
    public void validateNumberLengthExceptionTest(){
        //given
        String test1 = "123";
        String test2 = "1234";
        String test3 = "qwe";

        //when & then
        Assertions.assertDoesNotThrow(() -> Exceptions.validateNumberLength(test1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> Exceptions.validateNumberLength(test2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Exceptions.validateNumberLength(test3));
    }

    @Test
    public void validateUniqueNumbersExceptionTest(){
        //given
        String test1 = "123";
        String test2 = "111";

        //when & then
        Assertions.assertDoesNotThrow(() -> Exceptions.validateUniqueNumbers(test1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> Exceptions.validateUniqueNumbers(test2));
    }

    @Test
    public void validateRestartInputException(){
        //given
        String test1 = "1";
        String test2 = "2";
        String test3 = "qewr";
        String test4 = "5";

        //when & then
        Assertions.assertDoesNotThrow(() -> Exceptions.validateRestartInput(test1));
        Assertions.assertDoesNotThrow(() -> Exceptions.validateRestartInput(test2));

        Assertions.assertThrows(IllegalArgumentException.class, () -> Exceptions.validateRestartInput(test3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Exceptions.validateRestartInput(test4));
    }


    @Override
    public void runMain(){
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
