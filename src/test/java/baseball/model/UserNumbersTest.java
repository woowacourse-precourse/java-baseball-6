package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNumbersTest {
    @Test
    public void 문자열_숫자_변환_테스트(){
        //given
        String str = "123";
        //when
        Number[] numbers = UserNumbers.turnToNumberList(str);
        //then
        Assertions.assertEquals(1,numbers[0].number);
        Assertions.assertEquals(2,numbers[1].number);
        Assertions.assertEquals(3,numbers[2].number);
    }

    @Test
    public void 사용자_숫자_생성_테스트(){
        //given
        String str = "123";
        //when
        UserNumbers userNumbers = new UserNumbers(str);
        //then
        Assertions.assertEquals(1,userNumbers.numbers[0].number);
        Assertions.assertEquals(2,userNumbers.numbers[1].number);
        Assertions.assertEquals(3,userNumbers.numbers[2].number);
    }
}