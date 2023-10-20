package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author 민경수
 * @description random number generator
 * @since 2023.10.20
 **********************************************************************************************************************/
public class RandomNumberGenerator implements NumberGenerator{

  @Override
  public int generateNumber() {
    int randomNumber = Randoms.pickNumberInRange(100, 999);

    return randomNumber;
  }

}