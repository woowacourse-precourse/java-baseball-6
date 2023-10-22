package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

  private RandomNumber computer;

  @BeforeEach
  void createComputerAndSetRandomNumber() {
    computer = new RandomNumber();
  }

  @Test
  void isRandomNumberLengthEqualThree() {
    int randomNumberLength = String.valueOf(computer.getRandomNumber()).length();
    assertThat(randomNumberLength).isEqualTo(3);
  }

  @Test
  void areRandomNumberDigitsAllDifferent() {
    String randomNumber = String.valueOf(computer.getRandomNumber());
    boolean check1 = !randomNumber.substring(0, 1).equals(randomNumber.substring(1, 2));
    boolean check2 = !randomNumber.substring(1, 2).equals(randomNumber.substring(2, 3));
    boolean check3 = !randomNumber.substring(0, 1).equals(randomNumber.substring(2, 3));
    assertTrue(check1 && check2 && check3);

  }
}
