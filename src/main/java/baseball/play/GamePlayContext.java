package baseball.play;

import baseball.play.restart.CommandConsoleContext;
import baseball.play.restart.CommandButtonResult;
import baseball.play.restart.CompletelyQuietEvent;
import baseball.play.restart.GameReStartedEvent;
import baseball.play.start.RestartConfirmationCommand;
import baseball.play.start.GameStartContext;
import baseball.play.start.create.RandomNumberCreateCommands;

public class GamePlayContext {

  public static void play() {
    guide("숫자 야구 게임을 시작합니다.");
    RandomNumberCreateCommands createCommands = RandomNumberCreateCommands.of(1, 9, 3);
    RestartConfirmationCommand confirmationCommand = GameStartContext.start(createCommands);
    guide("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    CommandButtonResult<GameReStartedEvent, CompletelyQuietEvent> console = CommandConsoleContext.confirmButton(
        confirmationCommand);
    while (console.isRestart()) {
      createCommands = RandomNumberCreateCommands.of(console.getRestart().getStartNum(),
          console.getRestart().getEndNum(), console.getRestart().getLimit());
      confirmationCommand = GameStartContext.start(createCommands);
      console = CommandConsoleContext.confirmButton(confirmationCommand);
    }
    guide(console.getQuit().getCompletelyQuietMessage());
  }

  private static void guide(String message) {
    System.out.println(message);
  }

}
