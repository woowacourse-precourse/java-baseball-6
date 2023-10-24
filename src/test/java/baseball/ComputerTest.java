package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ComputerTest {

  @Test
  void 난수는_항상_3자리의_숫자여야_한다() {
    Computer computer = new Computer();
    String generatedNumber = String.valueOf(computer.getRandomNumber());
    assertEquals(3, generatedNumber.length());
  }

  @Test
  void 난수는_항상_서로_다른_숫자로_이뤄져야_한다() {
    Computer computer = new Computer();
    Set<Character> set = new HashSet<>();

    String generatedNumber = String.valueOf(computer.getRandomNumber());
    char[] generatedChars = generatedNumber.toCharArray();

    for(char each : generatedChars) {
      set.add(each);
    }
    assertEquals(generatedNumber.length(), set.size());
  }

  @Test
  void 난수는_항상_1과_9사이에_있다() {
    Computer computer = new Computer();
    String generatedNumber = String.valueOf(computer.getRandomNumber());
    boolean result = true;

    char[] generatedChars = generatedNumber.toCharArray();
    for(char each : generatedChars) {
      if(!(each >= '1' && each <= '9')) {
        result = false;
        return;
      }
    }
    assertTrue(result);
  }

  //TODO: 각각의 테스트의 결과는 항상 같다는 걸 어떻게 검증할까?

}