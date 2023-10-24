package baseball.play.restart;

import baseball.play.start.RestartConfirmationCommand;
import camp.nextstep.edu.missionutils.Console;

public class CommandConsoleContext {

  public static CommandButtonResult<GameReStartedEvent, CompletelyQuietEvent> confirmButton(
      RestartConfirmationCommand restartCommand) {
    ValidatedCommandButton validatedCommandConsole = ValidatedCommandButton.of(Console.readLine());
    if (validatedCommandConsole.isRestart()) {
      return CommandButtonResult.restart(GameReStartedEvent.of(restartCommand.getStart(),
          restartCommand.getEnd(), restartCommand.getLimit()));
    }
    return CommandButtonResult.quit(CompletelyQuietEvent.of("게임을 종료합니다."));
  }
}
