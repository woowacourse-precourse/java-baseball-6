package baseball.view;

import baseball.domain.Result;

public class OutputView {

  public void printGameStart() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public void printResult(Result result) {
    System.out.println(result.toString());
  }

  public void printGameWon() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  public void printEndGame() {
    System.out.println("게임을 종료합니다.");
  }

  public static void printErrorMessage(String message) {
    System.out.println("오류: " + message);
  }

  public static void printAskPlayAgain() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }
}