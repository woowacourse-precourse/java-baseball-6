package baseball.service;

import baseball.domain.User;
import baseball.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService(new User());
    }

    @Test
    public void testValidInputNumber() {
        User user = new User();
        UserService userService = new UserService(user);

        // inputNumber 메서드 호출
        user.inputNumber(); // 사용자 입력 대신 직접 설정

        assertTrue(user.isValidInput());
    }

    @Test
    public void testInvalidInputNumber() {
        User user = new User();
        UserService userService = new UserService(user);

        // 유효하지 않은 숫자로 inputNumber 메서드 호출
        userService.inputNumber(); // 사용자 입력 대신 직접 설정 (예: "112")

        assertFalse(user.isValidInput());
    }

    @Test
    public void testValidRetrySelection() {
        User user = new User();
        UserService userService = new UserService(user);

        // selectRetry 메서드 호출
        user.selectRetry(); // 사용자 입력 대신 직접 설정 (예: "1")

        assertTrue(user.isValidRetry());
    }

    @Test
    public void testInvalidRetrySelection() {
        User user = new User();
        UserService userService = new UserService(user);

        // 유효하지 않은 선택으로 selectRetry 메서드 호출
        user.selectRetry(); // 사용자 입력 대신 직접 설정 (예: "3")

        assertFalse(user.isValidRetry());
    }
}
