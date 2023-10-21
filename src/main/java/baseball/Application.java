package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

  public static void main(String[] args) {
    System.out.println("숫자 야구 게임을 시작합니다.");
    game();
  }

  public static void game() {
    int[] strike_ball;
    int result = 0;
    List<Integer> com_num = computer_num_create();
    while (result == 0) {
      String user_num = user_num_crete();
      strike_ball = check_num(com_num, user_num);
      result = result_print(strike_ball);
    }
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String user = Console.readLine();
    handleInvalidInput(user);
    if (Objects.equals(user, "1")) {
      game();
    }
  }

  public static List<Integer> computer_num_create() { // 컴퓨터 랜덤 숫자 생성
    List<Integer> computer_num = new ArrayList<>();
    while (computer_num.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer_num.contains(randomNumber)) {
        computer_num.add(randomNumber);
      }
    }
    return computer_num;
  }

  public static String user_num_crete() { // 사용자 숫자 받아오기
    System.out.print("숫자를 입력해주세요 :");
    String user_num = Console.readLine();
    containsDuplicates(user_num);
    isStringLengthCorrect(user_num);
    checkThreeDigitNumber(user_num);
    return user_num;
  }

  public static int[] check_num(List<Integer> com_num, String user_num) {
    int strike = 0;
    int ball = 0;
    for (int i = 0; i < user_num.length(); i++) {
      for (int j = 0; j < com_num.size(); j++) {
        if ((int) user_num.charAt(i) - 48 == com_num.get(j)) {
          if (i == j) {
            strike += 1;
          } else {
            ball += 1;
          }
        }
      }
    }
    return new int[]{strike, ball};
  }

  public static int result_print(int[] result) {
    int strike = result[0];
    int ball = result[1];
    if (ball == 0 && strike == 0) {
      System.out.println("낫싱");
    } else if (ball == 0 && strike > 0) {
      System.out.println(strike + "스트라이크");
      if (strike == 3) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return 1;
      }
    } else if (ball > 0 && strike == 0) {
      System.out.println(ball + "볼");
    } else if (ball > 0 && strike > 0) {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    return 0;
  }

  public static void isStringLengthCorrect(String user_num)
      throws IllegalArgumentException { // 자리수 검사
    if (user_num.length() != 3) {
      throw new IllegalArgumentException("3자리를 입력하세요.");
    }
  }

  public static void containsDuplicates(String user_num)
      throws IllegalArgumentException { // 중복되었는지 검사
    int first = user_num.charAt(0);
    int second = user_num.charAt(1);
    int third = user_num.charAt(2);
    if (first == second || second == third || first == third) {
      throw new IllegalArgumentException("중복된 숫자 입니다.");
    }
  }

  public static void handleInvalidInput(String user) throws IllegalArgumentException { // 1또는 2 검사
    if (!user.equals("1") && !user.equals("2")) {
      throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
  }

  public static void checkThreeDigitNumber(String user_num)
      throws NumberFormatException { // 입력된 문자열에 문자가 있는지 확인
    for (char c : user_num.toCharArray()) {
      if (!Character.isDigit(c)) {
        throw new NumberFormatException("문자가 포함되어 있습니다.");
      }
    }
  }
}