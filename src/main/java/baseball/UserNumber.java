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

  public void inputUser() { // user 값 입력 받기
    System.out.print("숫자를 입력해주세요 : ");
    this.userInput = Console.readLine();
    validateInputLength(this.userInput);  // 유효성 검사 : 값 길이 체크
    validateInputInt(this.userInput);  // 유효성 검사 : 타입 체크
    this.user = Arrays.stream(this.userInput.split(""))
      .mapToInt(Integer::parseInt).boxed()
      .collect(Collectors.toList());  // 형 변환 Array
    validateInputCompare(this.user);  // 유효성 검사 : 중복 값 입력 체크
  }

  public List<Integer> getUser() {  // user 값 가져오기
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
