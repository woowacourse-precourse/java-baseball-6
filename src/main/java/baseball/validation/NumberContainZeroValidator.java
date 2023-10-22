package baseball.validation;

import java.util.Arrays;

/**
 * @author 민경수
 * @description number contain zero validator
 * @since 2023.10.23
 **********************************************************************************************************************/
public class NumberContainZeroValidator implements NumberValidator {

  @Override
  public void validate(int[] number) {
    if (Arrays.asList(number).contains(0)) {
      throw new IllegalArgumentException("숫자 0은 포함될 수 없습니다.");
    }
  }

}