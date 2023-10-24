package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomExceptionTest {

    private final CustomException customException = new CustomException();

    @Test
    @DisplayName("인풋 길이 3이상 예외 처리")
    public void checkInputValidation_LengthMoreThan3(){
        assertThrows(IllegalArgumentException.class,
                () -> customException.checkInputValidation("1234"));
    }

    @Test
    @DisplayName("숫자이외의 값이 들어올때 예외 처리")
    public void checkInputValidation_NotDigits(){
        assertThrows(IllegalArgumentException.class,
                () -> customException.checkInputValidation("12a"));
    }

    @Test
    @DisplayName("인풋 중복 값에 대한 예외 처리")
    public void checkInputValidation_Duplication(){
        assertThrows(IllegalArgumentException.class,
                () -> customException.checkInputValidation("122"));
    }

    @Test
    @DisplayName("중복 처리 함수에 대한 테스트 true")
    public void checkDuplicateValidation_DuplicationTrue(){
        assertTrue(customException.checkInputDuplication("122"));
    }

    @Test
    @DisplayName("중복 처리 함수에 대한 테스트 false")
    public void checkDuplicateValidation_DuplicationFalse(){
        assertFalse(customException.checkInputDuplication("123"));
    }
}
