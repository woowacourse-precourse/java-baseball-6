package baseball.legacy.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.legacy.property.BaseballGameProperty;

/**
 * @author 민경수
 * @description random number validator
 * @since 2023.10.22
 **********************************************************************************************************************/
public class RandomNumberValidator extends RangeValidator {


  public RandomNumberValidator(BaseballGameProperty baseballGameProperty) {
    super(baseballGameProperty);
  }

  public boolean isAllowNumber(int number) {
    super.valid(number);

    List<Integer> list = this.generate(number);
    if (list.contains(0)) {
      return false;
    }

    if (isDistinct(list)) {
      return false;
    }

    return true;
  }

  private boolean isDistinct(List<Integer> list) {
    Set<Integer> distinct = new HashSet<>(list);

    return list.size() != distinct.size();
  }

  private List<Integer> generate(Integer number) {
    List<Integer> list = new ArrayList<>();

    String s = String.valueOf(number);
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; ++i) {
      list.add(Character.getNumericValue(chars[i]));
    }

    return list;
  }

}