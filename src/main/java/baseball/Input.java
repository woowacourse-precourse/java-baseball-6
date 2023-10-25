package baseball;
public class Input {
  public static void verifiedInput(String num) {

    if (!num.chars().allMatch(Character::isDigit)) {//숫자인지 확인
      throw new IllegalArgumentException("숫자를 입력 해야 합니다.");
    }
    if (num.length() != Constants.INPUT_SIZE) {//3자리 수인지 확인
      throw new IllegalArgumentException("세자리 수를 입력 해야 합니다.");
    }

    for (int i = 0; i < Constants.INPUT_SIZE - 1; i++) {//중복된 숫자로 이루어져 있는지 확인
      containSameNum(num, i);
    }
  }

  private static void containSameNum(String num, int i) {
    String s1 = num.substring(i, i + 1);
    String s2 = num.substring(i + 1);
    if (s2.contains(s1)) {
      throw new IllegalArgumentException("서로 다른 수로 이루어 져야 한다.");
    }
  }
}
