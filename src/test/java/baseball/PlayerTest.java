package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerTest extends NsTest {
  private static final InputStream originalSystemIn = System.in;

  @BeforeEach
  public void setUp() {
  }

  @AfterEach
  public void teardown() {

    System.setIn(originalSystemIn);
  }

  @Test
  @DisplayName("숫자가 세 자리 수가 아닌 경우")
  public void invalidThreeNumbers() {
    System.setIn(new ByteArrayInputStream("1234".getBytes()));
    String read = Console.readLine();
    Player player = new Player();

    //when,
    boolean isValid = player.validateInput(read);

    //then
    assertEquals(false, isValid);
    Console.close();
    // 첫 번째 테스트
  }

  @Test
  public void test2() {
    System.setIn(new ByteArrayInputStream("abcd".getBytes()));
    String read = Console.readLine();
    //when, then
    Player player = new Player();
    boolean isValid = player.validateInput(read);

    //then
    assertEquals(false, isValid);

    Console.close();
    //when, then
  }
  @Override
  protected void runMain() {

  }
}
