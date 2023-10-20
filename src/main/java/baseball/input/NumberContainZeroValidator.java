package baseball.input;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 민경수
 * @description number contain zero validator
 * @since 2023.10.20
 **********************************************************************************************************************/
public class NumberContainZeroValidator implements InputValidator{

  @Override
  public void validate(Integer number) {
    List<Integer> response = new ArrayList<>();
    String stringNumber = String.valueOf(number);
    for (int digitIndex = 0; digitIndex < stringNumber.length(); ++digitIndex) {
      Character digitChar = stringNumber.charAt(digitIndex);
      response.add(Character.getNumericValue(digitChar));
    }

    for (Integer integer : response) {
      if (integer == 0) {
        throw new IllegalArgumentException("1~9 사이의 숫자만 입력하실 수 있습니다.");
      }
    }
  }

}