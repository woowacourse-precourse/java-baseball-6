package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private List<Integer> PlayerNum = new ArrayList<>();

  public Player() {
    setPlayerNum();
  }

  public List<Integer> getPlayerNum() {
    return PlayerNum;
  }

  public void setPlayerNum() {
    System.out.print("숫자를 입력해주세요 : ");
    String input = readLine();

    if (input.length() != Constant.SIZE) {
      throw new IllegalArgumentException("숫자는 세 개 입력해야 합니다.");
    }

    for (char ch : input.toCharArray()) {
      if (!Character.isDigit(ch)) {
        throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
      } else if (Character.getNumericValue(ch) < Constant.MIN_NUMBER
          || Character.getNumericValue(ch) > Constant.MAX_NUMBER) {
        throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
      } else if (PlayerNum.contains(Character.getNumericValue(ch))) {
        throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
      } else {
        PlayerNum.add(Character.getNumericValue(ch));
      }
    }
  }
}
