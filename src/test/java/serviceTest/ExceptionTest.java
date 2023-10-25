package serviceTest;

import baseball.service.BaseballService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExceptionTest {

    private BaseballService baseballService = new BaseballService();
    //1. 잘못된 숫자 범위 테스트
    //2. 잘못된 문자 입력 테스트
    //
    @Test
    @DisplayName("숫자 3개가 아닐 때 예외 테스트")
    void NumberLengthExceptionTest(){
        //given
        String input = "1234";

        //then
        assertThrows(IllegalArgumentException.class, () -> baseballService.verifyException(input));
    }
    @ParameterizedTest
    @ValueSource(strings = {"012","abc","19a","!@#"})
    @DisplayName("1~9 사이의 숫자가 아닐 때 예외 테스트")
    void numberRangeExceptionTest(String input){

        //then
        assertThrows(IllegalArgumentException.class, () -> baseballService.verifyException(input));
    }

}
