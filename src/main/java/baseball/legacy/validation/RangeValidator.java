package baseball.legacy.validation;

import baseball.legacy.property.BaseballGameProperty;

/**
 * @author 민경수
 * @description range validator
 * @since 2023.10.22
 **********************************************************************************************************************/
public class RangeValidator {

  private BaseballGameProperty baseballGameProperty;

  public RangeValidator(BaseballGameProperty baseballGameProperty) {
    this.baseballGameProperty = baseballGameProperty;
  }

  protected int minInclusive() {
    return this.baseballGameProperty.minNumberRange();
  }

  protected int maxInclusive() {
    return this.baseballGameProperty.maxNumberRange();
  }

  public void valid(Integer validNumber) {
    if (!rangeIn(validNumber)) {
      throw new IllegalArgumentException("잘못된 범위의 숫자입니다. 입력된 숫자 = " + validNumber);
    }
  }

  protected boolean rangeIn(Integer validNumber) {
    return this.minInclusive() <= validNumber
      &&  this.maxInclusive() >= validNumber;
  }

}