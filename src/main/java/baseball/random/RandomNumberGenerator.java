package baseball.random;

import baseball.property.BaseballGameProperty;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author 민경수
 * @description random number generator
 * @since 2023.10.23
 **********************************************************************************************************************/
public class RandomNumberGenerator implements NumberGenerator{

  private BaseballGameProperty baseballGameProperty;

  public RandomNumberGenerator(BaseballGameProperty baseballGameProperty) {
    this.baseballGameProperty = baseballGameProperty;
  }

  @Override
  public int[] generateNumber() {
    int[] randomNumbers = new int[baseballGameProperty.digit()];

    for (int i = 0; i < baseballGameProperty.digit(); i++) {
      randomNumbers[i] = Randoms.pickNumberInRange(baseballGameProperty.usableNumberFrom(), baseballGameProperty.usableSingleNumberTo());
    }

    return randomNumbers;
  }

}