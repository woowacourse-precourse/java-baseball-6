package baseball.play.start;

import baseball.play.restart.GameRestartCommand;
import baseball.play.start.compare.GameCompareContext;
import baseball.play.start.compare.GameResult;
import baseball.play.start.compare.GameResume;
import baseball.play.start.compare.WinningGame;
import baseball.play.start.create.GameCreateContext;
import baseball.play.start.create.RandomNumberCreateCommands;
import baseball.play.start.create.InputCommands;
import baseball.play.start.input.GameInputContext;
import baseball.play.start.input.GameStartedEvent;

public class GameStartContext {

  public static GameRestartCommand start(
      RandomNumberCreateCommands createCommands) {
    InputCommands inputCommands = GameCreateContext.inputCommand(createCommands);
    signleLineOutPut("숫자를 입력해주세요 : ");
    GameStartedEvent gameStartedEvent = GameInputContext.inputNumber(inputCommands);
    GameResult<GameResume, WinningGame> result = GameCompareContext.compare(gameStartedEvent);
    while (result.isResume()) {
      singleSpacedOutPut(result.getGameResume().getResumeMessage());
      gameStartedEvent = GameInputContext.inputNumber(inputCommands);
      result = GameCompareContext.compare(gameStartedEvent);
    }
    singleSpacedOutPut(result.getWinningGame().getWinningMessage());
    singleSpacedOutPut("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    return  GameRestartCommand.of("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }

  private static void singleSpacedOutPut(String message) {
    System.out.println(message);
  }
  private static void signleLineOutPut(String message) {
    System.out.print(message);
  }
}
