package baseball.view;

import baseball.domain.dto.GuessResult;

public final class OutputView {

  public void printResult(final GuessResult result) {
    if (result.isNothing()) {
      System.out.print("낫싱");
    }
    if (result.ballCount() > 0) {
      System.out.printf("%d볼 ", result.ballCount());
    }
    if (result.strikeCount() > 0) {
      System.out.printf("%d스트라이크", result.strikeCount());
    }
    if (result.isThreeStrike()) {
      System.out.print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    System.out.println();
  }
}
