package baseball.view;

import baseball.domain.Pitching;

public interface ConsoleView {

  void printGameStartMessage();

  void printGuessResult(Pitching pitching);

  void printGameResult();

  String getUserGuess();

  String getUserDecision();

}
