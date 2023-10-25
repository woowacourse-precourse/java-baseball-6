package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Retry {

  public boolean retry() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    
    String answer = Console.readLine();
    exception_num(answer);
    char answer_char = answer.charAt(0);

    if (answer_char == '1')
      return true;

    return false;
  }
  public void exception_num(String s) {
    if (s.contains("1") != true && s.contains("2") != true) {
      throw new IllegalArgumentException("1과 2 외에는 입력할 수 없습니다.");
    }
  }
}
