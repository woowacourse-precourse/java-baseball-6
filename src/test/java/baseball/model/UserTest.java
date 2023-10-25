package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
    }

    @DisplayName("정상적인 input에 의한 get결과 테스트")
    @Test
    public void setUserNumber_validInput() {
        String input = "123";

        assertDoesNotThrow(() -> testUser.setUserNumber(input));

        assertEquals(1, (int) testUser.getUserNumber().get(0));
        assertEquals(2, (int) testUser.getUserNumber().get(1));
        assertEquals(3, (int) testUser.getUserNumber().get(2));
    }

    @DisplayName("Size가 올바르지 않을 떄 exception 테스트")
    @Test
    public void setUserNumber_invalidSize() {
        String input = "12";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testUser.setUserNumber(input);
        });

        String expectedMessage = "3자리 숫자를 입력하지 않았습니다.";

        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @DisplayName("1-9사이의 숫자가 아닐 떄 exception 테스트")
    @Test
    public void setUserNumber_invalidRange() {
        String input = "12a"; // Contains '0' which is out of range

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testUser.setUserNumber(input);
        });

        String expectedMessage = "1-9 사이의 숫자로 구성되지 않았습니다.";

        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @DisplayName("중복 검사 exception 테스트")
    @Test
    public void setUserNumber_duplicateNumbers() {
        String input = "122"; // Contains duplicate numbers

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testUser.setUserNumber(input);
        });

        String expectedMessage = "입력 값은 서로 다른 세 자리 숫자여야 합니다.";

        assertTrue(exception.getMessage().contains(expectedMessage));
    }

}