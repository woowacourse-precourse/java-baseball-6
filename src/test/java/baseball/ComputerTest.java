package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

  @DisplayName("난수는 항상 3자리 숫자여야 한다")
  @Test
  void always_3_digit() {
    Computer computer = new Computer();
    String generatedNumber = String.valueOf(computer.randomNumber);
    assertEquals(3, generatedNumber.length());
  }

  @DisplayName("난수는 항상 서로 다른 숫자로 이뤄져 있다")
  @Test
  void always_different_number() {
    Computer computer = new Computer();
    Set<Character> set = new HashSet<>();

    String generatedNumber = String.valueOf(computer.randomNumber);
    char[] generatedChars = generatedNumber.toCharArray();

    for(char each : generatedChars) {
      set.add(each);
    }
    assertEquals(generatedNumber.length(), set.size());
  }

  @DisplayName("난수로 이뤄진 숫자는 항상 1에서 9사이에 있다")
  @Test
  void always_between_1_and_9_() {
    Computer computer = new Computer();
    String generatedNumber = String.valueOf(computer.randomNumber);
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