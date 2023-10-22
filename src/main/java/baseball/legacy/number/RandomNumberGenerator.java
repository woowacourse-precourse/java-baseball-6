package baseball.legacy.number;

import baseball.legacy.property.BaseballGameProperty;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author 민경수
 * @description random number generator
 * @since 2023.10.20
 **********************************************************************************************************************/
public class RandomNumberGenerator implements NumberGenerator {
  private BaseballGameProperty baseballGameProperty;

  public RandomNumberGenerator(BaseballGameProperty baseballGameProperty) {
    this.baseballGameProperty = baseballGameProperty;
  }

  @Override
  public int[] generateValidRandomNumber() {
    int[] numberArray = new int[baseballGameProperty.numberOfDigit()];
    for (int i = 0; i < baseballGameProperty.numberOfDigit(); i++) {
      numberArray[i] = Randoms.pickNumberInRange(baseballGameProperty.minNumberRangeFrom(), baseballGameProperty.maxNumberRangeTo());
    }

    return numberArray;
  }

}