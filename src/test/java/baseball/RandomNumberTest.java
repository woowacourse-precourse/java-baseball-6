package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {

  @Test
  void isRandomNumberLengthEqualThree() {
    RandomNumber randomNumber = new RandomNumber();
    int randomNumberLength = String.valueOf(randomNumber.getRandomNumber()).length();
    assertThat(randomNumberLength).isEqualTo(3);
  }

}
