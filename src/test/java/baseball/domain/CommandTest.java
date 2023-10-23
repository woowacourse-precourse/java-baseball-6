package baseball.domain;

import baseball.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Command 클래스 테스트")
class CommandTest {

    @Test
    @DisplayName("getValue 메서드 테스트")
    void testGetValue() {
        assertEquals("1", Command.RETRY.getValue());
        assertEquals("2", Command.EXIT.getValue());
    }

    @Nested
    @DisplayName("fromValue 메서드 테스트")
    class FromValueTest {
        @Test
        @DisplayName("fromValue 메서드 테스트 - 옳바른 입력값")
        void testFromValueWithValidValue() {
            Command command = Command.fromValue("1");
            assertEquals(Command.RETRY, command);

            command = Command.fromValue("2");
            assertEquals(Command.EXIT, command);
        }

        @Test
        @DisplayName("fromValue 메서드 테스트 - 잘못된 입력값")
        void testFromValueWithInvalidValue() {
            String invalidValue = "3";
            assertThrows(InvalidInputException.class, () -> {
                Command.fromValue(invalidValue);
            });
        }
    }
}



