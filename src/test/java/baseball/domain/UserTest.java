package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import baseball.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;

    @BeforeEach
    public void setup() {
        User user = new User();
        user.inputNumber();
        user.selectRetry();
    }

    @Test
    public void testInputNumber() {
        // 사용자 입력을 시뮬레이트하기 위한 입력값 설정
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        user.inputNumber();

        assertEquals(input, user.returnBaseballNumber());
    }

    @Test
    public void testSelectRetry() {
        // 사용자 입력을 시뮬레이트하기 위한 입력값 설정
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        user.selectRetry();

        assertEquals(input, user.returnRetryNumber());
    }

    @Test
    public void testIsValidRetry() {
        // 유효한 retry 값
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(user.isValidRetry());

        // 유효하지 않은 retry 값
        input = "3";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(user.isValidRetry());
    }

    @Test
    public void testIsValidInput() {
        // 유효한 야구 숫자 입력
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(user.isValidInput());

        // 유효하지 않은 야구 숫자 입력 (중복된 숫자)
        input = "112";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(user.isValidInput());

        // 유효하지 않은 야구 숫자 입력 (0이 포함된 경우)
        input = "045";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(user.isValidInput());

        // 유효하지 않은 야구 숫자 입력 (4자리)
        input = "1234";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(user.isValidInput());
    }
}
