package baseball.legacy.validation;

import baseball.legacy.property.BaseballGameProperty;

/**
 * @author 민경수
 * @description input number validator
 * @since 2023.10.22
 **********************************************************************************************************************/
public class InputNumberValidator extends RangeValidator{

  public InputNumberValidator(BaseballGameProperty baseballGameProperty) {
    super(baseballGameProperty);
  }

}