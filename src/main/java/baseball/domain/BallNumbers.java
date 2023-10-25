package baseball.domain;

import java.util.List;

public class BallNumbers {
  private final List<SingleDigitNumber> singleDigitNumbers;

  public BallNumbers(List<SingleDigitNumber> singleDigitNumbers){
    this.singleDigitNumbers = singleDigitNumbers;
  }

  public SingleDigitNumber getNumberAt(int index) {
    return singleDigitNumbers.get(index);
  }
}
