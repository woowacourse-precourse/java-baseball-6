package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameMaster {

  boolean isContinued;

  public void start() {
    this.isContinued = true;
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public String progress() {
    System.out.print("숫자를 입력해주세요 : ");
    return Console.readLine();
  }

  public void printResult(String result) {
    if(result.equals("3스트라이크")) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      String answer = progressOrNot();
      //TODO: answer를 validator로 보내서 입력값이 올바른지 검증한다.
      return;
    }
    System.out.println(result);
  }

  public String progressOrNot() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    return Console.readLine();
  }
}
