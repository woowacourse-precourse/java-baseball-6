package baseball.play.start.compare;

public sealed interface WinningGame permits ThreeStrike{
  String getWinningMessage();
}

final class ThreeStrike implements WinningGame {

  @Override
  public String getWinningMessage() {
    return "3스트라이크";
  }
}
