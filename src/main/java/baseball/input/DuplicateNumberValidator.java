package baseball.input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 민경수
 * @description duplicate number validator
 * @since 2023.10.20
 **********************************************************************************************************************/
public class DuplicateNumberValidator implements InputValidator {

  @Override
  public void validate(Integer number) {
    List<Integer> response = new ArrayList<>();
    String stringNumber = String.valueOf(number);
    for (int digitIndex = 0; digitIndex < stringNumber.length(); ++digitIndex) {
      Character digitChar = stringNumber.charAt(digitIndex);
      response.add(Character.getNumericValue(digitChar));
    }

    Set<Integer> checkNumberSet = new HashSet<>();
    for (Integer integer : response) {
      checkNumberSet.add(integer);
    }

    if (checkNumberSet.size() != response.size()) {
      throw new IllegalArgumentException("반복되는 숫자가 포함되어 있습니다. 입력하신 숫자는 " + stringNumber + " 입니다.");
    }
  }

}