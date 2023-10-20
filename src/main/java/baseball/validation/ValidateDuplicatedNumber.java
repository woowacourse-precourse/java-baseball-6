package baseball.validation;

import baseball.exception.InvalidDuplicatedNumbersException;

import java.util.Arrays;
import java.util.List;

public class ValidateDuplicatedNumber {
  public static void validate(String value) {
    List<Integer> validateValues = Arrays.stream(value.split(""))
            .map(Integer::parseInt)
            .toList();
    if (validateValues.size() != validateValues.stream().distinct().count()) {
      throw new InvalidDuplicatedNumbersException();
    }
  }
}
