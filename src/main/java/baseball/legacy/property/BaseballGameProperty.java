package baseball.legacy.property;

/**
 * @author 민경수
 * @description baseball game property
 * @since 2023.10.20
 **********************************************************************************************************************/
public class BaseballGameProperty {

  private Integer numberOfDigit;
  private Integer minNumberRangeFrom;
  private Integer maxNumberRangeTo;

  public BaseballGameProperty(Integer numberOfDigit, Integer minNumberRangeFrom, Integer maxNumberRangeTo) {
    this.numberOfDigit = numberOfDigit;
    this.minNumberRangeFrom = minNumberRangeFrom;
    this.maxNumberRangeTo = maxNumberRangeTo;
  }

  public int numberOfDigit() {
    return numberOfDigit;
  }

  public int minNumberRangeFrom() {
    return minNumberRangeFrom;
  }

  public int maxNumberRangeTo() {
    return maxNumberRangeTo;
  }

  public Integer minNumberRange() {
    StringBuilder builder = new StringBuilder();
    builder.append(1);
    for (int i = 1; i < numberOfDigit; ++i) {
      builder.append(0);
    }
    String num = builder.toString();
    return Integer.parseInt(num);
  }

  public Integer maxNumberRange() {
    return this.minNumberRange() * 10 - 1;
  }
}