package baseball.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {
    String input;
    User user;
    @BeforeEach
    void 입력(){
        input = "291";
        user = new User(input);
    }
    @Test
    void 숫자_길이_테스트(){
        user.checkSize(input);
    }
    @Test
    void 숫자_범위_테스트() {
        List<Integer> userNumbers = user.parseStringToInteger(input);
        user.checkRange(userNumbers);
    }

    @Test
    void 중복_테스트() {
        List<Integer> userNumbers = user.parseStringToInteger(input);
        user.checkDuplicate(userNumbers);
    }
}