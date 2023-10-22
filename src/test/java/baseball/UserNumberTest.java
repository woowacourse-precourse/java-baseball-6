package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class UserNumberTest {

  private User userNumber;

  @BeforeEach
  void setUp() {
    userNumber = new User();
  }

  @Test
  void readValidUserNumberFromConsole() {
    try (MockedStatic<Console> theMock = Mockito.mockStatic(Console.class)) {
      theMock.when(Console::readLine).thenReturn("123");
      userNumber.readUserNumberFromConsole();
      assertEquals(123, userNumber.getUserNumber());
    }
  }

  @Test
  void readInvalidUserNumberThrowsException() {
    try (MockedStatic<Console> theMock = Mockito.mockStatic(Console.class)) {
      theMock.when(Console::readLine).thenReturn("12a");
      assertThrows(IllegalArgumentException.class, userNumber::readUserNumberFromConsole);
    }
  }

  @Test
  void isUserNumberSetByTest() {
    userNumber.setUserNumber("123");
    assertEquals(123, userNumber.getUserNumber());
  }

  @Test
  void isUserNumberLengthEqualsThree() {
    assertThrows(IllegalArgumentException.class, () -> {
      userNumber.setUserNumber("12");
    });
  }

  @Test
  void isUserNumberNotString() {
    assertThrows(IllegalArgumentException.class, () -> {
      userNumber.setUserNumber("abc");
    });
  }
}
