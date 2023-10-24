package baseball.play;

import baseball.play.restart.CommandConsoleContext;
import baseball.play.restart.CommandConsoleResult;
import baseball.play.restart.CompletelyQuietEvent;
import baseball.play.restart.GameReStartedEvent;
import baseball.play.restart.GameRestartCommand;
import baseball.play.start.GameStartContext;
import baseball.play.start.create.RandomNumberCreateCommands;

public class GamePlayContext {

  public static void play() {
    guide("숫자 야구 게임을 시작합니다.");
    RandomNumberCreateCommands createCommands = RandomNumberCreateCommands.of(1, 9, 3);
    GameRestartCommand restartCommand = GameStartContext.start(createCommands);
    CommandConsoleResult<GameReStartedEvent, CompletelyQuietEvent> console = CommandConsoleContext.play(
        restartCommand);
    while (console.isRestart()) {
      createCommands = RandomNumberCreateCommands.of(console.getRestart().getStartNum(),
          console.getRestart().getEndNum(), console.getRestart().getLimit());
      restartCommand = GameStartContext.start(createCommands);
      console = CommandConsoleContext.play(restartCommand);
    }
    guide(console.getQuit().getCompletelyQuietMessage());
  }

  private static void guide(String message) {
    System.out.println(message);
  }
}
