package baseball;

import java.util.List;

public class User {

  private List<Integer> user;
  private int strike;
  private int ball;

  public User(List<Integer> user) {
    this.user = user;
    this.strike = 0;
    this.ball = 0;
  }

  public List<Integer> getUser() {
    return user;
  }

  public int getStrike() {
    return strike;
  }

  public void setStrike(int strike) {
    this.strike = strike;
  }

  public int getBall() {
    return ball;
  }

  public void setBall(int ball) {
    this.ball = ball;
  }

  public void inputValidation(String input) {
    if (input.length() != 3) {
      throw new IllegalArgumentException("세 자리 숫자가 아니다.");
    }

    for (int i = 0; i < 3; i++) {
      char splitInput = input.charAt(i);
      if (!Character.isDigit(splitInput) || splitInput == '0') {
        throw new IllegalArgumentException("1~9 사이의 숫자를 입력하세요");
      }

      int inputInt = Character.getNumericValue(splitInput);
      if (user.contains(inputInt)) {
        throw new IllegalArgumentException("같은 숫자가 존재한다");
      }

      user.add(inputInt);
    }
  }

  public void viewResult() {
    if (strike > 0 && ball > 0) {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    } else if (strike > 0 && ball == 0) {
      System.out.println(strike + "스트라이크");
    } else if (strike == 0 && ball > 0) {
      System.out.println(ball + "볼");
    } else {
      System.out.println("낫싱");
    }
  }
}
