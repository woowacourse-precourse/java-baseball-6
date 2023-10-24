package baseball.play.restart;

import camp.nextstep.edu.missionutils.Console;

public class CommandConsoleContext {

  public static CommandConsoleResult<GameReStartedEvent, CompletelyQuietEvent> play(GameRestartCommand restartCommand) {
    guideRestarting(restartCommand);
    ValidatedCommandConsole validatedCommandConsole = ValidatedCommandConsole.of(Console.readLine());
    if (validatedCommandConsole.isRestart()) {
      return CommandConsoleResult.restart(GameReStartedEvent.of(1, 9, 3));
    }
    return CommandConsoleResult.quit(CompletelyQuietEvent.of("게임을 종료합니다."));
  }

  private static void guideRestarting(GameRestartCommand gameRestartCommand) {
    System.out.println(gameRestartCommand.getRestartOrEndMessage());
  }
}
