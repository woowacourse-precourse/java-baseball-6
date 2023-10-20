package baseball.input;

/**
 * @author 민경수
 * @description number range validator
 * @since 2023.10.20
 **********************************************************************************************************************/
public class NumberRangeValidator implements InputValidator{

  @Override
  public void validate(Integer number) {
    if (100 >= number || 999 <= number) {
      throw new IllegalArgumentException("범위를 확인해주세요. 입력한 숫자 : " + number);
    }
  }

}