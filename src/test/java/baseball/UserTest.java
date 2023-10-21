package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testValidUserNum() {
        // 유효한 3자리 숫자를 입력
        user.setUserNum("123");
        assertEquals("123", user.getUserNum());
    }

    @Test
    void 예외_사용자_입력값_글자수_초과() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNum("1234");
        });
    }

    @Test
    void 예외_사용자_입력값_문자_입력() {
        User user = new User();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNum("aaa");
        });
    }
}
