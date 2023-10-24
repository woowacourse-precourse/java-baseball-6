package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserNum {
  public List<Integer> userNum() {

    System.out.println("숫자를 입력해주세요 : ");

    String input = Console.readLine();

    if (!ValidationInput(input)) {
      throw new IllegalArgumentException("1에서 9까지 서로 다른 3자리 숫자를 입력하세요.");
    }

    List<Integer> userNum = new ArrayList<>();

    for(String number : input.split("")) {
      userNum.add(Integer.parseInt(number));
    }

    return userNum;
  }

  private boolean ValidationInput(String input) {
    return Pattern.matches("^[1-9]{3}$", input)
        && input.chars().distinct().count() == 3;
  }
}