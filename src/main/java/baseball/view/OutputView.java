package baseball.view;

import baseball.domain.GameResult;

public final class OutputView {

  public void printResult(final GameResult result) {
    if (result.getBallCount() + result.getStrikeCount() == 0) {
      System.out.print("낫싱");
    }
    if (result.getBallCount() > 0) {
      System.out.printf("%d볼 ", result.getBallCount());
    }
    if (result.getStrikeCount() > 0) {
      System.out.printf("%d스트라이크", result.getStrikeCount());
    }
    if (result.isClear()) {
      System.out.print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    System.out.println();
  }
}
