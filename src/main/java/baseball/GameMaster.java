package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class GameMaster {

  boolean shouldContinueRound;
  boolean isCorrectAnswerFound;

  public GameMaster() {
    this.shouldContinueRound = true;
  }

  public void init() {
    this.isCorrectAnswerFound = false;
  }

  public void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public String progress() {
    System.out.print("숫자를 입력해주세요 : ");
    return Console.readLine();
  }

  public String checkResult(String result) {
    System.out.println(result);
    if(result.equals("3스트라이크")) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      return progressOrNot();
    }
    return null;
  }

  public String progressOrNot() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    return Console.readLine();
  }

  public String printResult(Map<String, Integer> resultTable) {
    StringBuilder sb = new StringBuilder();
    int strike = resultTable.get("스트라이크");
    int ball = resultTable.get("볼");

    if (strike == 0 && ball == 0) {
      sb.append("낫싱");
    } else if(strike != 0 && ball == 0) {
      sb.append(strike).append("스트라이크");
    } else if(strike == 0 && ball != 0) {
      sb.append(ball).append("볼");
    } else {
      sb.append(ball).append("볼 ").append(strike).append("스트라이크");
    }

    return sb.toString();
  }

  public void oneMoreRound(boolean status) {
    this.shouldContinueRound = status;
  }

}
