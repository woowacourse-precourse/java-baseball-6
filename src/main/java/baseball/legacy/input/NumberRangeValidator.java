package baseball.legacy.input;

import baseball.legacy.property.BaseballGameProperty;

/**
 * @author 민경수
 * @description number range validator
 * @since 2023.10.20
 **********************************************************************************************************************/
public class NumberRangeValidator implements InputValidator {

  private BaseballGameProperty property;

  public NumberRangeValidator(BaseballGameProperty property) {
    this.property = property;
  }

  protected int minInclusive() {
    return this.property.minNumberRange();
  }

  protected int maxInclusive() {
    return this.property.maxNumberRange();
  }

  @Override
  public void validate(Integer number) {
    if (minInclusive() >= number || maxInclusive() <= number) {
      throw new IllegalArgumentException("범위를 확인해주세요. 입력한 숫자 : " + number);
    }
  }

}