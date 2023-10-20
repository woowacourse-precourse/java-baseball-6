package baseball.validation;

import baseball.exception.InvalidDuplicatedNumbersException;
import baseball.exception.InvalidNumberFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateDuplicatedNumber {
  public static Boolean validate(String value) {
    List<Integer> validateValues = Arrays.stream(value.split(""))
            .map(Integer::parseInt)
            .toList();
    if (validateValues.size() != validateValues.stream().distinct().count()) {
      throw new InvalidDuplicatedNumbersException();
    }
    return true;
  }
}
