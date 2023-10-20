package baseball.property;

/**
 * @author 민경수
 * @description baseball game property
 * @since 2023.10.20
 **********************************************************************************************************************/
public class BaseballGameProperty {

  private Integer numberOfDigit;
  private Integer minNumberRangeFrom;
  private Integer maxNumberRangeFrom;

  public BaseballGameProperty(Integer numberOfDigit, Integer minNumberRangeFrom, Integer maxNumberRangeFrom) {
    this.numberOfDigit = numberOfDigit;
    this.minNumberRangeFrom = minNumberRangeFrom;
    this.maxNumberRangeFrom = maxNumberRangeFrom;
  }

}