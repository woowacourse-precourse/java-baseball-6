package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userTest {

    // 잘 입력된 번호가 문제가 없는지
    @DisplayName("성공적인 input 테스트")
    @Test
    public void validateInput_test() throws Exception {
        //given
        String input = "123";
        user user = new user();

        //when
        user.setUserNumber(input);
        
        //then
        assertEquals(input, user.getUserNumber());
    }

     // 3개를 입력하지 않았을 경우
    @DisplayName("숫자 3개를 입력하지 않았을 경우 테스트")
    @Test
    public void invalidLength_test() throws Exception {
        //given
        String input = "12";
        user user = new user();

        //when
        
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNumber(input);
        });
    }

    @DisplayName("0 - 9 사이의 숫자가 아닌 경우")
    @Test
    public void invalidNumber_test() throws Exception {
        //given
        String input = "12a";
        user user = new user();
        //when
         
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNumber(input);
        });
    }

    @DisplayName("숫자 중복 검사 테스트")
    @Test
    public void duplicate_test() throws Exception {
        //given
        String input = "112";
        user user = new user();
        //when
        
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNumber(input);
        });
     } 

}