package baseball;

import java.util.List;

public class User {
  private List<Integer> user;

  public User(List<Integer> user) {
    this.user = user;
  }

  public List<Integer> getUser() {
    return user;
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
}
