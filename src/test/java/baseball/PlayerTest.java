package baseball;

import static baseball.Constants.IN_GAME;
import static baseball.Constants.RE_GAME;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertFalse;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PlayerTest extends NsTest {

  private static final InputStream originalSystemIn = System.in;

  @AfterEach
  public void teardown() {
    System.setIn(originalSystemIn);
  }

  @Test()
  public void invalidThreeNumbers() {
    System.setIn(new ByteArrayInputStream("1234\n".getBytes()));
    Player player = new Player();

    //when, then
    assertSimpleTest(
        () -> {
          boolean isValid = player.validateNumericInput(Console.readLine(), IN_GAME);
          assertFalse(isValid);
        }
    );
    Console.close();
  }

  @Test
  public void 재경기일_때_1과_2가_아닌_경우() {
    System.setIn(new ByteArrayInputStream("3\n".getBytes()));
    Player player = new Player();
    assertSimpleTest(
        () -> {
          boolean isValid = player.userInputNumbers(RE_GAME);
          ;
          assertFalse(isValid);
        }
    );
    Console.close();
  }

  @Test
  public void 재경기일_때_숫자가_아닌_경우() {
    System.setIn(new ByteArrayInputStream("a\n".getBytes()));
    Player player = new Player();
    assertSimpleTest(
        () -> {
          boolean isValid = player.userInputNumbers(RE_GAME);
          ;
          assertFalse(isValid);
        }
    );
    Console.close();

  }

  @Test
  public void checkDuplicatedNumber() {
    System.setIn(new ByteArrayInputStream("111\n".getBytes()));
    Player player = new Player();

    assertSimpleTest(
        () -> {
          boolean isValid = player.validateNumericInput(Console.readLine(), IN_GAME);
          assertFalse(isValid);
        }
    );
    Console.close();
  }

  @Test
  public void invalidaNotNumbers() {
    System.setIn(new ByteArrayInputStream("abcd\n".getBytes()));
    Player player = new Player();

    //when, then

    //then
    assertSimpleTest(
        () -> {
          boolean isValid = player.validateNumericInput(Console.readLine(), IN_GAME);
          assertFalse(isValid);
        }
    );
    Console.close();
  }

  public void runMain() {
  }
}