package baseball.legacy.baseballnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 민경수
 * @description base ball number converter
 * @since 2023.10.23
 **********************************************************************************************************************/
public class BaseBallNumberConverter {

  private List<BaseBallNumber> generateBaseBallNumberList(int number) {
    List<BaseBallNumber> baseBallNumberList = new ArrayList<>();

    String stringNumber = String.valueOf(number);
    for (int i = 0; i < stringNumber.length(); i++) {
      BaseBallNumber baseBallNumber = new BaseBallNumber(Character.getNumericValue(stringNumber.charAt(i)), i);
      baseBallNumberList.add(baseBallNumber);
    }

    return baseBallNumberList;
  }

  private List<BaseBallNumber> generateBaseBallNumberList(int[] number) {
    List<BaseBallNumber> baseBallNumberList = new ArrayList<>();

    for (int i = 0; i < number.length; i++) {
      BaseBallNumber baseBallNumber = new BaseBallNumber(number[i], i);
      baseBallNumberList.add(baseBallNumber);
    }

    return baseBallNumberList;
  }

}