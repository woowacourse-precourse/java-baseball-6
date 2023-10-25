package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
  private List<Integer> user;
  private String userInput;

  public UserNumber() {

  }

  public void inputUser() {
    System.out.print("숫자를 입력해주세요 : ");
    this.userInput = Console.readLine();
    validateInputLength(this.userInput);
    validateInputInt(this.userInput);
    this.user = Arrays.stream(this.userInput.split(""))
      .mapToInt(Integer::parseInt).boxed()
      .collect(Collectors.toList());
    validateInputCompare(this.user);
//    if (user.size() < 3) {
//      throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
//    }
  }

  public List<Integer> getUser() {
    return user;
  }

  private void validateInputLength(String userInput) {
    if (userInput.length() != 3) {
      throw new IllegalArgumentException("3자리를 입력해주세요.");
    }
  }

  private void validateInputInt(String userInput) {
    try {
      int i = Integer.parseInt(userInput);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
  }

  private void validateInputCompare(List<Integer> user) {
    if (user.get(0).equals(user.get(1)) || user.get(1).equals(user.get(2)) || user.get(0).equals(user.get(2))) {
      throw new IllegalArgumentException("중복된 숫자입니다.");
    }
  }

}
