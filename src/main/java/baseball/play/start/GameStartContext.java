package baseball.play.start;

import baseball.play.start.compare.GameCompareContext;
import baseball.play.start.compare.GameResult;
import baseball.play.start.compare.ResumingGame;
import baseball.play.start.compare.WinningGame;
import baseball.play.start.create.GameCreateContext;
import baseball.play.start.create.RandomNumberCreateCommands;
import baseball.play.start.create.InputCommands;
import baseball.play.start.input.GameInputContext;
import baseball.play.start.input.GameStartedEvent;

public class GameStartContext {

  public static RestartConfirmationCommand start(
      RandomNumberCreateCommands createCommands) {
    InputCommands inputCommands = GameCreateContext.inputCommand(createCommands);
    singleLineOutPut("숫자를 입력해주세요 : ");
    GameStartedEvent gameStartedEvent = GameInputContext.startedEvent(inputCommands);
    GameResult<ResumingGame, WinningGame> result = GameCompareContext.compare(gameStartedEvent);
    while (result.isResume()) {
      singleSpacedOutPut(result.getGameResume().getResumeMessage());
      gameStartedEvent = GameInputContext.startedEvent(
          InputCommands.of(result.getGameResume().randomNums()));
      result = GameCompareContext.compare(gameStartedEvent);
    }
    singleSpacedOutPut(result.getWinningGame().getWinningMessage());
    singleSpacedOutPut("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    return RestartConfirmationCommand.of(createCommands.getStartNum(),
        createCommands.getEndNum(), createCommands.getLimit());
  }

  private static void singleSpacedOutPut(String message) {
    System.out.println(message);
  }

  private static void singleLineOutPut(String message) {
    System.out.print(message);
  }
}
